package com.its.memberBoard.controller;

import com.its.memberBoard.dto.MemberDTO;
import com.its.memberBoard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/saveForm")
    public String saveForm() {
        return "/member/save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) throws IOException {
        memberService.save(memberDTO);
        return "/member/login";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/member/login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
        MemberDTO memberLogin = memberService.login(memberDTO);
        if (memberLogin != null) {
            model.addAttribute("memberLogin", memberLogin);
            session.setAttribute("loginMemberId", memberLogin.getMemberId());
            session.setAttribute("loginId", memberLogin.getId());
            return "redirect:/paging";
        } else {
            return "/member/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @GetMapping("/findAllMember")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAllMember();
        model.addAttribute("memberList", memberDTOList);
        return "/member/list";

    }


    @GetMapping("/member/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        memberService.delete(id);
        return "/index";

    }

    @GetMapping("/myPage")
    public String myPage() {
        return "/member/detail";
    }

    @GetMapping("/member/detail")
    public String findById(@RequestParam("id") Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "/member/detail";
    }

    @GetMapping("/update")
    public String myPage(HttpSession session, Model model) {
        Long updateId = (Long) session.getAttribute("loginId");
        MemberDTO memberDTO = memberService.findById(updateId);
        model.addAttribute("updateMember", memberDTO);
        return "/member/update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        boolean updateResult = memberService.update(memberDTO);
        if (updateResult) {
            return "redirect:/member/detail?id=" + memberDTO.getId();
        } else {
            return "/index";
        }
    }

    @PostMapping("/duplicate-check")
    public @ResponseBody String duplicateCheck(@RequestParam("memberId") String memberId) {
        String checkResult = memberService.duplicateCheck(memberId);
        return checkResult;
    }


}

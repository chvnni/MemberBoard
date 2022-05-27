package com.its.memberBoard.controller;

import com.its.memberBoard.dto.BoardDTO;
import com.its.memberBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 글 작성화면 이동
    @GetMapping("/save-form")
    public String saveForm() {
        return "/board/save";
    }

    // 글 작성
    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boolean saveResult = boardService.save(boardDTO);
        if (saveResult) {
            System.out.println("글작성 완료");
            return "/board/findAll";
        } else {
            System.out.println("글작성 실패");
            return "index";
        }
    }

    // 전체목록
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "/board/list";
    }

//    // 페이징처리
//    @GetMapping("/paging")
//    public String paging(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
//        List<BoardDTO> boardList = boardService.pagingList(page);
//        PageDTO paging = boardService.paging(page);
//        model.addAttribute("boardList", boardList);
//        model.addAttribute("paging", paging);
//        return "/board/list";







    }

package com.its.memberBoard.controller;

import com.its.memberBoard.dto.BoardDTO;
import com.its.memberBoard.dto.CommentDTO;
import com.its.memberBoard.dto.PageDTO;
import com.its.memberBoard.service.BoardService;
import com.its.memberBoard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    // 글 작성화면 이동
    @GetMapping("/save-form")
    public String saveForm() {
        return "/board/save";
    }

    // 글 작성(파일첨부)
    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/paging";

    }

    // 페이징처리된 전체목록
    @GetMapping("/paging")
    public String paging(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
        List<BoardDTO> boardList = boardService.pagingList(page);
        PageDTO paging = boardService.paging(page);
        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);
        return "/board/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchType") String searchType, @RequestParam("q") String q, Model model) {
        List<BoardDTO> searchList = boardService.search(searchType, q);
        model.addAttribute("boardList", searchList);
        return "/board/list";
    }

    @GetMapping("/detail")
    public String findBoard(@RequestParam("id") Long id, Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        BoardDTO boardDTO = boardService.findBoard(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);
        List<CommentDTO> commentDTOList = commentService.findAllCom(id);
        model.addAttribute("commentList", commentDTOList);
        return "/board/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        commentService.delete(id);
        boardService.delete(id);
        return "redirect:/paging";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findBoard(id);
        model.addAttribute("boardUpdate", boardDTO);
        return "/board/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.update(boardDTO);
        return "redirect:/detail?id=" + boardDTO.getId();
    }


}

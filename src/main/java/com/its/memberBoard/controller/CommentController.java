package com.its.memberBoard.controller;

import com.its.memberBoard.dto.CommentDTO;
import com.its.memberBoard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글
    @PostMapping("/saveComment")
    public @ResponseBody List<CommentDTO> saveComment(@ModelAttribute CommentDTO commentDTO) {
        commentService.saveComment(commentDTO);
        List<CommentDTO> commentDTOList = commentService.findAllCom(commentDTO.getBoardId());
        return commentDTOList;
    }





}

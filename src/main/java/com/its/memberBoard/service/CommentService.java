package com.its.memberBoard.service;

import com.its.memberBoard.dto.CommentDTO;
import com.its.memberBoard.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(CommentDTO commentDTO) {
        commentRepository.saveComment(commentDTO);

    }


    public List<CommentDTO> findAllCom(Long boardId) {
        return commentRepository.findAllCom(boardId);
    }


    public void delete(Long id) {
        commentRepository.delete(id);

    }
}

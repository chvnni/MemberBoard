package com.its.memberBoard.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {

    private Long id; // 댓글번호
    private Long boardId; // 게시글번호
    private String commentWriter; // 댓글작성자
    private String commentContents; // 댓글 내용
    private Timestamp commentCreatedDate; // 댓글작성시간

}

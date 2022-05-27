package com.its.memberBoard.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private long id; // 댓글번호
    private String boardId; // 게시글번호
    private String commentWriter; // 댓글작성자
    private String commentContents; // 댓글 내용
    private Timestamp commentCreatedDate; // 댓글작성시간

}

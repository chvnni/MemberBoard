package com.its.memberBoard.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardDTO {
    private long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedDate;
    private String boardFileName;



}

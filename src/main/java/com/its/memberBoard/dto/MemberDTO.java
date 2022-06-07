package com.its.memberBoard.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MemberDTO {
    private Long id;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberEmail;
    private String memberMobile;
    private MultipartFile memberFile; // jsp에서 컨트롤러로 넘어올 때 파일을 담아오는 용도
    private String memberFileName; // 파일이름 담을 용도


}

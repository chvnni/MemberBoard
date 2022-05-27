package com.its.memberBoard.service;

import com.its.memberBoard.dto.MemberDTO;
import com.its.memberBoard.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public void save(MemberDTO memberDTO) throws IOException {
        MultipartFile memberFile = memberDTO.getMemberFile(); // 1. DTO 객체에 담긴 파일을 꺼냄
        String memberFileName = memberFile.getOriginalFilename(); // 2. 파일의 이름을 가져옴
        memberFileName = System.currentTimeMillis() + "-" + memberFileName; // 2-1. 파일 이름 중복을 피하기 위한 조치
        memberDTO.setMemberFileName(memberFileName); // 3. 파일 이름을 DTO 객체의 memberFileName에 저장
        String savePath = "D:\\spring_img\\" + memberFileName; // 4. 파일의 저장 위치 지정
        // 5. 파일 저장처리
        if (!memberFile.isEmpty()) {
            memberFile.transferTo(new File(savePath));
        }
        memberRepository.save(memberDTO); // 6. DTO 객체 repository로 전달

    }


    public MemberDTO login(MemberDTO memberDTO) {
        MemberDTO memberLogin = memberRepository.login(memberDTO);
        return memberLogin;

    }






}

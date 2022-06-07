package com.its.memberBoard.repository;

import com.its.memberBoard.dto.MemberDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    SqlSessionTemplate sql;

    public void save(MemberDTO memberDTO) {
        sql.insert("Member.save", memberDTO);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO);

    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public List<MemberDTO> findAllMember() {
        return sql.selectList("Member.findAllMember");

    }


    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById", id);

    }


    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update", memberDTO);
    }

    public String duplicateCheck(String memberId) {
        return sql.selectOne("Member.duplicate", memberId);

    }


}

package com.its.memberBoard.repository;

import com.its.memberBoard.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    @Autowired
    SqlSessionTemplate sql;

    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.save", boardDTO);

    }


    public List<BoardDTO> pagingList(Map<String, Integer> pagingParam) {
        return sql.selectList("Board.pagingList", pagingParam);

    }

    public int boardCount() {
        return sql.selectOne("Board.count");

    }


    public List<BoardDTO> search(Map<String, String> searchParam) {
        return sql.selectList("Board.search", searchParam);

    }


    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);

    }


    public BoardDTO findBoard(Long id) {
        return sql.selectOne("Board.findBoard", id);


    }


    public void delete(Long id) {
        sql.delete("Board.delete", id);

    }


    public void fileUpdate(BoardDTO boardDTO) {
        sql.update("Board.fileUpdate", boardDTO);

    }

    public void noFileUpdate(BoardDTO boardDTO) {
        sql.update("Board.noFileUpdate", boardDTO);

    }
}

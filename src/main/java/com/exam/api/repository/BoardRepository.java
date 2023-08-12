package com.exam.api.repository;

import com.exam.api.dto.UserJoinBoard;
import com.exam.api.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {

    @Query("SELECT new com.exam.api.dto.UserJoinBoard(b.board_id, b.title, u.email) FROM Board b JOIN b.userInfo u")
    public List<UserJoinBoard> getBoardListInfo(); // 게시물 리스트 정보 가져오기
}

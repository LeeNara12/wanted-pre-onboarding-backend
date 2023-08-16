package com.exam.api.repository;

import com.exam.api.dto.UserJoinBoard;
import com.exam.api.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {

    @Query("SELECT new com.exam.api.dto.UserJoinBoard(b.board_id, b.title, u.user_id, u.email) FROM Board b JOIN b.userInfo u")
    public Page<UserJoinBoard> getBoardListInfo(Pageable pageable); // 게시물 리스트 정보 가져오기

    @Query("SELECT new com.exam.api.dto.UserJoinBoard(b.board_id, b.title, u.user_id, u.email) FROM Board b JOIN b.userInfo u " +
            "where email = ?1")
    public UserJoinBoard getBoardEntity(String email);

}

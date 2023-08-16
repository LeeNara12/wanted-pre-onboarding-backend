package com.exam.api.Service;

import com.exam.api.dto.UserJoinBoard;
import com.exam.api.entity.Board;
import com.exam.api.entity.UserInfo;
import com.exam.api.repository.BoardRepository;
import com.exam.api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;



    public void join(UserInfo userInfo){ //회원정보 저장
        userInfoRepository.save(userInfo);
    }

    public boolean emailExists(String email){ //이메일 존재 여부
        return userInfoRepository.existsByEmail(email);
    }

    public boolean pwdExists(String pwd){ //이메일 존재 여부
        return userInfoRepository.existsByPwd(pwd);
    }

    public UserJoinBoard getBoardEntity(String email){
        return boardRepository.getBoardEntity(email);
    }







    //글 작성 처리
    public void write(Board board){
        boardRepository.save(board);
    }

    //게시글 리스트 정보 불러오기 (b.글번호, b.제목, u.작성자)
    public Page<UserJoinBoard> boardList(Pageable pageable){
        return boardRepository.getBoardListInfo(pageable);
    }

    //특정 게시글 불러오기(상세보기)
    public Board view(Integer id){
        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제하기
    public void delete(Integer board_id){
        boardRepository.deleteById(board_id);
    }

    //특정 게시글 수정하기
    public void update(Board board){//title과 content 변경
        Board updateBoard = boardRepository.findById(board.getBoard_id()).get();
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContent(board.getContent());
        boardRepository.save(updateBoard); //DB에 반영
    }
}

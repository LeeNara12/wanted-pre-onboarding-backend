package com.exam.api.Service;

import com.exam.api.dto.UserJoinBoard;
import com.exam.api.entity.Board;
import com.exam.api.entity.UserInfo;
import com.exam.api.repository.BoardRepository;
import com.exam.api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    //글 작성 처리
    public void write(Board board){
        boardRepository.save(board);
    }


    //게시글 리스트 정보 불러오기 (b.글번호, b.제목, u.작성자)
    public List<UserJoinBoard> boardList(){
        return boardRepository.getBoardListInfo();
    }


    //특정 게시글 불러오기
    public Board view(Integer id){
        return boardRepository.findById(id).get();
    }

}

package com.exam.api.Service;

import com.exam.api.entity.Board;
import com.exam.api.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    public void write(Board board){
        boardRepository.save(board);
    }

    public List<Board> list(){
        return boardRepository.findAll();
    }
}

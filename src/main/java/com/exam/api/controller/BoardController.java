package com.exam.api.controller;

import com.exam.api.Service.BoardService;
import com.exam.api.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired //읽어와서 주입 DI(Defendency Injection) 외부에서 두 객체 간의 관계를 결정해주는 디자인 패턴
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/board/writePro")
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
    }
}

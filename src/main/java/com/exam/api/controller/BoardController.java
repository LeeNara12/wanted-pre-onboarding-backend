package com.exam.api.controller;

import com.exam.api.Service.BoardService;
import com.exam.api.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired //읽어와서 주입 DI(Defendency Injection) 외부에서 두 객체 간의 관계를 결정해주는 디자인 패턴
    private BoardService boardService;

    @GetMapping("/board/write") //게시글 작성페이지로 이동
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/board/writePro") //게시글 db에 저장
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }


    @GetMapping("/board/view") //게시물 상세보기 페이지(수정, 삭제)로 이동
    public String boardView(Model model, Integer board_id){
        model.addAttribute("board", boardService.view(board_id));
        return "detailView";
    }




}

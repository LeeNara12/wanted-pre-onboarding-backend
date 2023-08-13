package com.exam.api.controller;

import com.exam.api.Service.BoardService;
import com.exam.api.dto.UserJoinBoard;
import com.exam.api.entity.Board;
import com.exam.api.entity.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller

public class BoardController {

    @Autowired //읽어와서 주입 DI(Defendency Injection) 외부에서 두 객체 간의 관계를 결정해주는 디자인 패턴
    private BoardService boardService;




    @GetMapping("/board/write") //게시글 작성페이지로 이동
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/board/writePro") //게시글 작성 처리
    public String boardWritePro(Board board, Model model){

        UserInfo info = new UserInfo();
        info.setUser_id(1);
        board.setUserInfo(info);// 임시

        //경고창 메시지 알고리즘
        if((board.getTitle() != null) && (!"".equals(board.getTitle()))
            &&(board.getContent() != null) && (!"".equals(board.getContent())) //제목과 내용의 값이 무조건 있어야 함
        ){
            boardService.write(board);
            model.addAttribute("message","글 작성이 완료되었습니다.");
            model.addAttribute("url","/board/list");

        }else{
            model.addAttribute("message","제목과 내용은 필수 값 입니다.");
            model.addAttribute("url","/board/write");

        }

        return "alert";
    }

    @GetMapping("/board/list")// 목록으로 이동
    public String boardList(Model model,
                            @PageableDefault(page = 0, size = 10, sort = "board_id", direction = Sort.Direction.DESC) Pageable pageable){

        Page<UserJoinBoard> list = boardService.boardList(pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4, 1);
        int endPage = Math.min(startPage + 9, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "boardList";
    }


    @GetMapping("/board/view") //게시물 상세보기 페이지(수정, 삭제)로 이동
    public String boardView(Model model, @RequestParam Integer board_id){
        model.addAttribute("board", boardService.view(board_id));

        return "detailView";
    }


    @GetMapping("/board/delete") //게시물 삭제 여부 선택
    public String boardDeleteChoice(@RequestParam Integer board_id, Model model){

        model.addAttribute("message","게시글을 삭제하시겠습니까?");
        model.addAttribute("yesUrl","/board/deletePro/"+board_id);
        model.addAttribute("noUrl","/board/view?board_id="+board_id);
        model.addAttribute("board_id", board_id);

        return "confirm";
    }


    @DeleteMapping("/board/deletePro/{board_id}") //게시물 삭제 처리
    @ResponseBody
    public ResponseEntity<String> boardDeletePro(@PathVariable Integer board_id){
        System.out.println("게시글 삭제 요청 : "+ board_id);
        boardService.delete(board_id);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }


    @GetMapping("/board/deletePro/{board_id}") //게시물 삭제 안내
    public String boardDeleteClear(Model model){

        model.addAttribute("message","삭제가 성공적으로 완료되었습니다.");
        model.addAttribute("url","/board/list");

        return "alert";
    }


    @PostMapping("/board/update") //게시물 수정 처리
    public String boardUpdate(@ModelAttribute Board board, Model model){
        boardService.update(board);

        model.addAttribute("message", "수정이 완료되었습니다.");
        model.addAttribute("url", "/board/list");

        return "alert";
    }


}

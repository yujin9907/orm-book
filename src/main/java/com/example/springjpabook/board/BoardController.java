package com.example.springjpabook.board;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.SequenceGenerator;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/dummy")
    public ResponseEntity<Board> set() {
        Board result = boardRepository.save(Board.builder().title("더미타이틀").content("테스트데이터").build());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

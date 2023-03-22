package com.example.springjpabook.board;

import com.example.springjpabook.step4.board.Board;
import com.example.springjpabook.step4.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
@Slf4j
public class BoardRepositoryTest {

    @Autowired private BoardRepository boardRepository;

    @BeforeEach
    public void setUp() {
        Board board = Board.builder().title("test").content("dummy").build();
        boardRepository.save(board);
    }

    @Test
    public void testSetUp() {
        log.debug("실행됨");
        List<Board> boardPS = boardRepository.findAll();

        log.debug(boardPS.get(0).getId().toString());
    }
}

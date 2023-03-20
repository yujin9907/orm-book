package com.example.springjpabook.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "board")
@SequenceGenerator(
        name = "board_seq_generator",
        sequenceName = "board_seq",
        initialValue = 1, allocationSize = 1 // 증가 디폴트 값은 50임
)
public class Board {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_generator")
    private @Id BigInteger id;
    private String title;
    private String content;
}

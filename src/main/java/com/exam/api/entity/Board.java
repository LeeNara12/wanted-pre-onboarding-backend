package com.exam.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity //DB에 있는 테이블 의미함
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
}

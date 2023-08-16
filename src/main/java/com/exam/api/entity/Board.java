package com.exam.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity //DB에 있는 테이블 의미함
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
}

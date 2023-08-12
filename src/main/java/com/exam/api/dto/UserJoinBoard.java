package com.exam.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserJoinBoard {

    private Integer board_id;
    private String title;
    private String email;//작성자


}

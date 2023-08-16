package com.exam.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    //유효성 검사 규칙 : @을 포함한 이메일 형식
    @Pattern(regexp = "^[0-9a-zA-Z]+@[0-9a-zA-Z.]+$", message = "이메일 형식으로 작성해주세요.")
    private String email;

    //유효성 검사 규칙 : 최소 8자 이상
    @Pattern(regexp = "^[0-9a-zA-Z]+$")
    @Size(min = 8, message = "비밀번호는 최소 8자이며, 숫자와 영문자만 가능합니다.")
    private String pwd;


}

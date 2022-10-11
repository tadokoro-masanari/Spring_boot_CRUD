package com.example.springdemo.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MemberRequest implements Serializable {

    // 名前
    private String name;

    // 誕生日
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    // 得意な言語
    private String programming_language;

    // 趣味
    private String hobby;

    // ディビジョンID
    private Integer division_id;

}

package com.example.springdemo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名前
     */
    @Column(name = "name")
    private String name;

    /**
     * 誕生日
     */
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 得意な言語
     */
    @Column(name = "programming_language")
    private String programming_language;

    /**
     * 趣味
     */
    @Column(name = "hobby")
    private String hobby;

    /**
     * ディビジョンID
     */
    @Column(name = "division_id")
    private Integer division_id;
}
package com.example.springdemo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DivisionRequest implements Serializable {
    // 名前
    private String name;
}

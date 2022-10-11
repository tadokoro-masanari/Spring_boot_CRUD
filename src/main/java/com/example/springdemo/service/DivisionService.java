package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.dto.DivisionRequest;
import com.example.springdemo.entity.Division;
import com.example.springdemo.repository.DivisionRepository;

@Service
public class DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    // 全件取得
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    // 登録
    public void insert(DivisionRequest divisionRequest) {
        // データベースに登録する値を保持するインスタンス
        Division division = new Division();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        division.setName(divisionRequest.getName());

        // データベースに登録する
        divisionRepository.save(division);
    }

    // IDを指定して取得
    public Division findOne(Integer id) {
        return divisionRepository.findById(id).get();
    }

    // 更新
    public void update(Integer id, DivisionRequest divisionRequest) {
        Division division = findOne(id);
        division.setName(divisionRequest.getName());

        divisionRepository.save(division);
    }
}
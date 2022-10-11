package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.dto.MemberRequest;
import com.example.springdemo.entity.Member;

import com.example.springdemo.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    // 全件取得
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // IDを指定して取得
    public Member findOne(Integer id) {
        return memberRepository.findById(id).get();
    }

    // 登録
    public void insert(MemberRequest memberRequest) {
        // データベースに登録する値を保持するインスタンス
        Member member = new Member();

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        member.setName(memberRequest.getName());
        member.setBirthday(memberRequest.getBirthday());
        member.setHobby(memberRequest.getHobby());
        member.setProgramming_language(memberRequest.getProgramming_language());
        member.setDivision_id(memberRequest.getDivision_id());

        // データベースに登録する
        memberRepository.save(member);
    }

    // 更新
    public void update(Integer id, MemberRequest memberRequest) {
        // 指定したIDのデータを取得
        Member member = findOne(id);

        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
        member.setName(memberRequest.getName());
        member.setBirthday(memberRequest.getBirthday());
        member.setHobby(memberRequest.getHobby());
        member.setProgramming_language(memberRequest.getProgramming_language());
        member.setDivision_id(memberRequest.getDivision_id());

        // データベースに登録する
        memberRepository.save(member);
    }

    // 削除
    public void delete(Integer id) {
        memberRepository.deleteById(id);
    }
}

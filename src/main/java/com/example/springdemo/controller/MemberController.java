package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.dto.MemberRequest;
import com.example.springdemo.entity.Division;
import com.example.springdemo.entity.Member;
import com.example.springdemo.repository.MemberRepository;
import com.example.springdemo.service.DivisionService;
import com.example.springdemo.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberService memberService;
    MemberRepository memberRepository;
    DivisionService divisionService;

    @GetMapping("index")
    public String index(Model model) {
        List<Member> memberList = memberService.findAll();
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("memberList", memberList);
        model.addAttribute("divisionList", divisionList);
        return "member/index";
    }

    @GetMapping("create")
    public String create() {
        return "member/create";
    }

    @PostMapping("store")
    public String store(MemberRequest memberRequest) {
        memberService.insert(memberRequest);
        return "redirect:index";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Member member = memberService.findOne(id);
        model.addAttribute("member", member);
        return "member/detail";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Member member = memberService.findOne(id);
        model.addAttribute("member", member);
        return "member/edit";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id, MemberRequest memberUpdateRequest) {
        memberService.update(id, memberUpdateRequest);
        return "redirect:/member/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        memberService.delete(id);
        return "redirect:/member/index";
    }
}
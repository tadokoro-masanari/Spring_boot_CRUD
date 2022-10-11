package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
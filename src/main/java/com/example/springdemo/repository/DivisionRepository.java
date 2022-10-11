package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.entity.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {

}

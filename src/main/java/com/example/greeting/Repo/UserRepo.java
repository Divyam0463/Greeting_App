package com.example.greeting.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.greeting.Model.Greeting;

public interface UserRepo extends JpaRepository<Greeting, Long> {
  
}

package com.example.greeting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.Model.Greeting;
import com.example.greeting.Repo.UserRepo;

@RestController
public class UC4_Controller {
  @Autowired
  public UserRepo userRepo ; 

  @PostMapping("/add")
  public String addEntry(@RequestBody Greeting greeting){
    userRepo.save(greeting) ; 
    return "greeting added" ; 
  }

  @GetMapping("/getRepoEntries")
  public List<Greeting> getMethod(){
    return userRepo.findAll() ; 
  }
}
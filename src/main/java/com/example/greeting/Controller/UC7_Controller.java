package com.example.greeting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.Model.Greeting;
import com.example.greeting.Repo.UserRepo;

@RestController
public class UC7_Controller {

  @Autowired
  public UserRepo userRepo ; 

  @PutMapping("/editMessage/{id}")
  public Greeting updateMessage(@PathVariable Long id, @RequestBody Greeting updated_greeting){
    Greeting greeting =  userRepo.findById(id).get();
    greeting.setMessage(updated_greeting.getMessage());
    greeting.setSender(updated_greeting.getSender());
    userRepo.save(greeting) ; 

    return greeting ; 
  }
}

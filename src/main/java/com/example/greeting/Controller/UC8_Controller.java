package com.example.greeting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.Model.Greeting;
import com.example.greeting.Repo.UserRepo;

@RestController
public class UC8_Controller {
  @Autowired
  public UserRepo userRepo  ; 

  @DeleteMapping("/delete/{id}")
  public List<Greeting> deleteEntry(@PathVariable Long id){
    userRepo.deleteById(id);
    return userRepo.findAll() ;  
  }
}

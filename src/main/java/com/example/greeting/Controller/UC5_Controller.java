package com.example.greeting.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.greeting.Model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.greeting.Repo.UserRepo;


@RestController
public class UC5_Controller {

  @Autowired
  public UserRepo userRepo ; 

  @GetMapping("/findById/{id}")
  public Greeting findById(@PathVariable Long id){
    Greeting greeting = userRepo.findById(id).get() ; 
    //findbyid() will return an "Optional" return type, thats why we use get()  
    return greeting ; 
  }
}

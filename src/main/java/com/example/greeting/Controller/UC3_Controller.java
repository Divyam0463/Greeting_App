package com.example.greeting.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.Model.Greeting;
import com.example.greeting.Model.User;

@RestController
public class UC3_Controller {
  //UC3
   @GetMapping("/{fullname}")
  public Greeting getMessage(@PathVariable String fullname){
    User user = new User("john" , "doe") ; 
    if ((user.getFirstName()+user.getLastName()).equals(fullname)) {
      Greeting greeting = new Greeting() ; 
      greeting.setMessage("hello");
      greeting.setSender(user.getFirstName()+" "+user.getLastName());

      return greeting ; 
    }
    return null ; 
  }

  @GetMapping("/firstOrlast/{name}")  
  public Greeting getName(@PathVariable String name){
    User user = new User("john", "doe"); 
    
    if(user.getFirstName().equalsIgnoreCase(name) || user.getLastName().equalsIgnoreCase(name)){
      Greeting greeting = new Greeting() ; 
      greeting.setMessage("hello");
      greeting.setSender(user.getFirstName());

      return greeting ; 
    }
    return null ; 
  }

  @GetMapping("/JUST_helloworld")
  public Greeting getName(){
    Greeting greeting = new Greeting() ;
    greeting.setMessage("hello");
    greeting.setSender("may"); 

    return greeting ; 
  }
}

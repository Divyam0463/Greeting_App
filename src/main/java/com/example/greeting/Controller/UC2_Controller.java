package com.example.greeting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.Service.GreetingService;

@RestController
public class UC2_Controller {
  @Autowired
  public GreetingService service ; 

  @GetMapping("/fetch")
  public String getHello(){
    return service.getService() ; 
  } 

}

package com.example.greeting.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greeting {

  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
    private Long id ;

    @Column
    private String message;
    @Column
    private String sender;

    public String getMessage() {
      return message;
    }

    public String getSender() {
      return sender;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public void setSender(String sender) {
      this.sender = sender;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }
}


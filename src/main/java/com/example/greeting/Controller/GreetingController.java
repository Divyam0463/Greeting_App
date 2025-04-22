package com.example.greeting.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.Model.Greeting;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private List<Greeting> greetings = new ArrayList<>();

    //GET
    @GetMapping
    public List<Greeting> checkGet() {
        return greetings;
    }

    // POST - Accept a Greeting object (in JSON)
    @PostMapping
    public Greeting checkPost(@RequestBody Greeting greeting) {
        greetings.add(greeting);
        return greeting;
    }

    // PUT - Update by sender
    @PutMapping("/{sender}")
    public Greeting checkUpdate(@PathVariable String sender, @RequestBody Greeting updated_greeting) {
        for (Greeting greeting:greetings) {
            if (greeting.getSender().equalsIgnoreCase(sender)) {
                greeting.setMessage(updated_greeting.getMessage());
                greeting.setSender(updated_greeting.getSender());

                return greeting; // Return the updated Greeting object
            }
        }
        return null ;
    }

    // DELETE - Delete a greeting by sender
    @DeleteMapping("/{sender}")
    public String deleteGreeting(@PathVariable String sender) {
        boolean removed = greetings.removeIf(greeting -> greeting.getSender().equalsIgnoreCase(sender));
        if (removed) {
            return "Greeting with sender '" + sender + "' removed successfully";
        } else {
            return "Greeting with sender '" + sender + "' not found";
        }
    }
}


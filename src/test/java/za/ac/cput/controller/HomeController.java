package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {
    public String welcome(){
        return "Welcome to our Audit Application.";
    }
}

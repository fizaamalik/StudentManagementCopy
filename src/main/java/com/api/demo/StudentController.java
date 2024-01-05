package com.api.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @GetMapping
    public String get(){

        return "GET:: student controller";

    }

    @PutMapping
    public String put(){
        return "PUT:: student controller";
    }



}

package com.api.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/global")
public class GlobalController {
    @GetMapping
    public String get(){

        return "GET:: global controller";

    }

    @PutMapping
    public String put(){
        return "PUT:: global controller";
    }

    @PostMapping
    public String post(){
        return "POST:: global controller";
    }

    @DeleteMapping
    public String delete(){
        return "DELETE:: global controller";
    }

//    @GetMapping
//    public ResponseEntity<String> sayHello(){
//        return ResponseEntity.ok("hello from secured endpoint");
//    }
}

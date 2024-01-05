package com.api.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@PreAuthorize("hasRole('COLLEGE')")
@RestController
@RequestMapping("/api/v1/college")
public class CollegeController {

    @PreAuthorize("hasAuthority('college:read')")
    @GetMapping
    public String get(){

        return "GET:: college controller";

    }
    @PreAuthorize("hasAuthority('college:update')")
    @PutMapping
    public String put(){
        return "PUT:: college controller";
    }
    @PreAuthorize("hasAuthority('college:create')")
    @PostMapping
    public String post(){
        return "POST:: college controller";
    }

    @PreAuthorize("hasAuthority('college:delete')")
    @DeleteMapping
    public String delete(){
        return "DELETE:: college controller";
    }
}

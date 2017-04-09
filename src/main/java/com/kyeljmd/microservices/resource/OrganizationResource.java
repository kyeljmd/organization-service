package com.kyeljmd.microservices.resource;

import org.springframework.web.bind.annotation.*;

@RestController("/api/organization")
public class OrganizationResource {

    @GetMapping
    public String get() {
        return "Organization Get Resource";
    }

    @PostMapping
    public String post() {
        return "Organization  Post Resource";
    }

    @DeleteMapping
    public String delete() {
        return "Organization Delete Resource";
    }

    @PatchMapping
    public String patch() {
        return "Organization Patch Resource";
    }
}

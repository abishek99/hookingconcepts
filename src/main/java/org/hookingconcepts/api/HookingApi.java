package org.hookingconcepts.api;

import org.hookingconcepts.service.HookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HookingApi {

    @Autowired
    private HookingService hookingService;

    @GetMapping("/getmessage")
    public String getMessage() {
        return hookingService.getMessage();
    }
}

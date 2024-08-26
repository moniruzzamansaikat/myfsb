package com.example.myfsb_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SiteController {
    @GetMapping("/saikat")
    public String saikat() {
        return "saikat";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about()
    {
        return "about";
    }

    @GetMapping("/fuck")
    public String fuck()
    {
        return "about";
    }

}

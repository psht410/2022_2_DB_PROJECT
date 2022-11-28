package com.example.test3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
//    @GetMapping("/")
//    public String a(Model model){
//        model.addAttribute("a", "main");
//
//        return "index";
//    }

    @GetMapping("/{type}")
    public String a(Model model, @PathVariable String type){
        model.addAttribute("type", type);

        return "index";
    }
}

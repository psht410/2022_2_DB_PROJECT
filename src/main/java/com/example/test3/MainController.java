package com.example.test3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
//    , @PathVariable String type
    @GetMapping("/")
    public String a(Model model){
        List<String> headers = Arrays.asList("cno", "cname", "price", "change_rate", "volume");
        List<String> headers2 = Arrays.asList("cno", "cname", "overview", "volume", "sector");
        List<Map<String, Object>> rows = new ArrayList<>();
        List<Map<String, Object>> data = new ArrayList<>();
        List<Map<String, Object>> data2 = new ArrayList<>();

        data.add((Map.of("mno", "1", "group_name", "Group 1")));
        data.add((Map.of("mno", "1", "group_name", "Group 2")));
        data.add((Map.of("mno", "1", "group_name", "Group 3")));

        data2.add((Map.of("cno", "1001", "cname", "AAA", "overview", "개요 1", "volume", "320000", "sector", "제조업")));
        data2.add((Map.of( "cno", "1002", "cname", "BBB", "overview", "개요 2", "volume", "640000", "sector", "통신판매업")));
        data2.add((Map.of( "cno", "1003", "cname", "CCC", "overview", "개요 3", "volume", "48000", "sector", "야가다")));
        data2.add((Map.of( "cno", "1004", "cname", "DDD", "overview", "개요 4", "volume", "3000", "sector", "무역업")));

        rows.add(Map.of("cno", "1001", "cname", "AAA", "price", "15000", "change_rate", "3.5", "volume", "320000"));
        rows.add(Map.of("cno", "1002", "cname", "BBB", "price", "7700", "change_rate", "2.7", "volume", "640000"));
        rows.add(Map.of("cno", "1003", "cname", "CCC", "price", "9300", "change_rate", "8.9", "volume", "48000"));

        model.addAttribute("headers", headers);
        model.addAttribute("headers2", headers2);
        model.addAttribute("rows", rows);
        model.addAttribute("data", data);
        model.addAttribute("data2", data2);

        return "index";
    }
}

package com.example.test3;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



@Controller
public class MainController {

    // @PathVariable String type
    @GetMapping("/")
    public String getIndex(Model model){


        return "index";
    }
    @GetMapping("/pos")
    // possessed stocks
    public String getPossessed(Model model){
        List<String> header_possessed = Arrays.asList("cno", "cname", "quantity", "appraisal", "loss", "rate", "price_cur", "price_buy");
        List<Map<String, Object>> data_possessed = new ArrayList<>();

        data_possessed.add((Map.of("cno", "1001", "cname", "AAA", "quantity", "5000", "appraisal", 5000*100, "loss", 5000*100 - 5000*80, "rate", String.format("%.0f %%", ((double)(5000*100) / (5000*80))*100-100), "price_cur", 100*5000, "price_buy", 80*5000)));
        data_possessed.add((Map.of("cno", "1003", "cname", "CCC", "quantity", "200", "appraisal", 200*1000, "loss", 200*750 - 200*1000, "rate", String.format("%.0f %%", ((double)(200*750) / (200*1000))*100-100), "price_cur", 1000*200, "price_buy", 750*200)));

        model.addAttribute("header_possessed", header_possessed);
        model.addAttribute("data_possessed", data_possessed);

        return "possessed";
    }

    @GetMapping("/fav")
    // interest group
    public String getFav(Model model){
        List<String> header_fav = Arrays.asList("cno", "cname", "price", "change_rate", "volume");
        List<String> header_addStock = Arrays.asList("cno", "cname", "overview", "volume", "sector");

        List<Map<String, Object>> data_fav = new ArrayList<>();
        List<Map<String, Object>> data_favGroup = new ArrayList<>();
        List<Map<String, Object>> data_addStock = new ArrayList<>();

        data_favGroup.add((Map.of("mno", "1", "group_name", "Group 1")));
        data_favGroup.add((Map.of("mno", "1", "group_name", "Group 2")));
        data_favGroup.add((Map.of("mno", "1", "group_name", "Group 3")));

        data_fav.add(Map.of("cno", "1001", "cname", "AAA", "price", "15000", "change_rate", "3.5", "volume", "320000"));
        data_fav.add(Map.of("cno", "1002", "cname", "BBB", "price", "7700", "change_rate", "2.7", "volume", "640000"));
        data_fav.add(Map.of("cno", "1003", "cname", "CCC", "price", "9300", "change_rate", "8.9", "volume", "48000"));

        data_addStock.add((Map.of("cno", "1001", "cname", "AAA", "overview", "개요 1", "volume", "320000", "sector", "제조업")));
        data_addStock.add((Map.of( "cno", "1002", "cname", "BBB", "overview", "개요 2", "volume", "640000", "sector", "통신판매업")));
        data_addStock.add((Map.of( "cno", "1003", "cname", "CCC", "overview", "개요 3", "volume", "48000", "sector", "야가다")));
        data_addStock.add((Map.of( "cno", "1004", "cname", "DDD", "overview", "개요 4", "volume", "3000", "sector", "무역업")));

        model.addAttribute("header_fav", header_fav);
        model.addAttribute("header_addStock", header_addStock);
        model.addAttribute("data_fav", data_fav);
        model.addAttribute("data_favGroup", data_favGroup);
        model.addAttribute("data_addStock", data_addStock);

        return "favorite";
    }

    @GetMapping("/history")
    // order history
    public String getHistory(Model model){
        List<String> header_history = Arrays.asList("cno", "cname", "type", "price", "quantity", "order_time", "state");
        List<Map<String, Object>> data_history = new ArrayList<>();

        LocalDateTime time = LocalDateTime.now();
        String strTime = time.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

        data_history.add((Map.of("cno", "1001", "cname", "AAA", "type", "매수", "price", "15500", "quantity", "300","order_time", strTime, "state", "체결")));
        data_history.add((Map.of("cno", "1001", "cname", "AAA", "type", "매도", "price", "15000", "quantity", "200","order_time", strTime, "state", "미체결")));
        data_history.add((Map.of("cno", "1002", "cname", "BBB", "type", "매수", "price", "7700", "quantity", "100","order_time", strTime, "state", "체결")));

        model.addAttribute("header_history", header_history);
        model.addAttribute("data_history", data_history);

        return "history";
    }
    
}

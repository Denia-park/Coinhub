package com.example.coinhub.controller;

import com.example.coinhub.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {
    @Autowired
    private MarketService marketService;

    @GetMapping("/price")
    public  double getPrice(@RequestParam String market, @RequestParam String coin) {
        return marketService.getPrice(market, coin);
    }
}

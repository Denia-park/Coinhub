package com.example.coinhub.controller;

import com.example.coinhub.service.CommonMarketService;
import com.example.coinhub.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MarketController {
    private final Map<String, MarketService> marketServices;
    private final CommonMarketService commonMarketService;

    @GetMapping("/price")
    public double getPrice(@RequestParam String market, @RequestParam String coin) {
        return commonMarketService.getPrice(market, coin);
    }

    @GetMapping("/coins")
    public List<String> getCoins(@RequestParam String market) {
        return CommonMarketService.getMarketService(marketServices, market).getCoins();
    }

    @GetMapping("/common-coins")
    public List<String> getCommonCoins(@RequestParam String market1, @RequestParam String market2) {
        return commonMarketService.getCommonCoin(market1, market2);
    }
}

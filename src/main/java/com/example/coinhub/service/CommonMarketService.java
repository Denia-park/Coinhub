package com.example.coinhub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommonMarketService {
    private final Map<String, MarketService> marketServices;

    public static MarketService getCommonCoins(Map<String, MarketService> marketServices, String market) {
        for (String key : marketServices.keySet()) {
            if (key.substring(0, market.length()).equals(market.toLowerCase())) {
                return marketServices.get(key);
            }
        }
        return null;
    }

    public double getPrice(String market, String coin) {
        MarketService marketService = getCommonCoins(marketServices, market);

        return marketService.getCoinCurrentPrice(coin);
    }
}

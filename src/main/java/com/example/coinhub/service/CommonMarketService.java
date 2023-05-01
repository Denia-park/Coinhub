package com.example.coinhub.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommonMarketService {
    private final Map<String, MarketService> marketServices;

    public static MarketService getMarketService(Map<String, MarketService> marketServices, String market) {
        for (String key : marketServices.keySet()) {
            if (key.substring(0, market.length()).equals(market.toLowerCase())) {
                return marketServices.get(key);
            }
        }
        return null;
    }

    public List<String> getCommonCoin(String fromMarket, String toMarket) {
        //마켓 서비스 가져와
        MarketService fromMarketService = getMarketService(marketServices, fromMarket);
        MarketService toMarketService = getMarketService(marketServices, toMarket);

        //각 마켓의 거래가능 코인 불러오기
        List<String> fromMarketCoins = fromMarketService.getCoins();
        List<String> toMarketCoins = toMarketService.getCoins();

        //공통의 것 찾기
        List<String> commonCoins = fromMarketCoins.stream()
                .filter(coin -> toMarketCoins.contains(coin))
                .collect(Collectors.toList());

        return commonCoins;
    }

    public double getPrice(String market, String coin) {
        MarketService marketService = getMarketService(marketServices, market);

        return marketService.getCoinCurrentPrice(coin);
    }
}

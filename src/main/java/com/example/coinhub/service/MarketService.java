package com.example.coinhub.service;

import com.example.coinhub.dto.CoinBuyDTO;
import com.example.coinhub.dto.CoinSellDTO;

import java.util.List;

public interface MarketService {
    double getCoinCurrentPrice(String coin);

    List<String> getCoins();

    CoinBuyDTO calculateBuy(List<String> commonCoins, double amount);

    CoinSellDTO calculateSell(CoinBuyDTO buyDTO);
}

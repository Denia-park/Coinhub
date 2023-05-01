package com.example.coinhub.service;

import com.example.coinhub.feign.BithumbFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BithumbMarketService implements MarketService {
    private final BithumbFeignClient bithumbFeignClient;

    @Override
    public double getCoinCurrentPrice(String coin) {
        String value = bithumbFeignClient.getCoinPrice(coin.toUpperCase() + "_KRW")
                .getData()
                .getClosing_price();

        return Double.parseDouble(value);
    }

    @Override
    public List<String> getCoins() {
        //API 활용해서 가져와야지
        List<String> result = new ArrayList<>();
        bithumbFeignClient.getAssetStatus().getData().forEach((k, v) -> {
            if (v.getDeposit_status() == 1 && v.getWithdrawal_status() == 1) {
                result.add(k.toUpperCase());
            }
        });

        return result;
    }
}

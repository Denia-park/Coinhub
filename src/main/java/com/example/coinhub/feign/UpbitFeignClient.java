package com.example.coinhub.feign;

import com.example.coinhub.constant.CacheConstants;
import com.example.coinhub.model.UpbitCoinPrice;
import com.example.coinhub.model.UpbitMarketCode;
import com.example.coinhub.model.UpbitOrderBooks;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "upbit", url = "https://api.upbit.com/v1")
public interface UpbitFeignClient {
    @Cacheable(CacheConstants.UPBIT_COIN_PRICE)
    @GetMapping("/ticker")
    List<UpbitCoinPrice> getCoinPrice(@RequestParam("markets") String coin);

    @Cacheable(CacheConstants.UPBIT_MARKET_CODE)
    @GetMapping("/market/all")
    List<UpbitMarketCode> getMarketCode();

    @Cacheable(CacheConstants.UPBIT_ORDER_BOOKS)
    @GetMapping("/orderbook")
    List<UpbitOrderBooks> getOrderBooks(@RequestParam List<String> markets);
}

package com.example.price_monitor.controller;

import com.example.price_monitor.model.coinbase.price.PriceResponse;
import com.example.price_monitor.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    @Autowired
    private CoinbaseService coinbaseService;

    @RequestMapping("/{currencyPair}/market-price")
    public ResponseEntity<PriceResponse> getMarketPrice(@PathVariable String currencyPair) {
        var spotPriceCurrencyPair = coinbaseService.getSpotPriceCurrencyPair(currencyPair);
        var priceResponse = PriceResponse.from(spotPriceCurrencyPair);
        return ResponseEntity.ok(priceResponse);

    }
}

package com.example.reportgenerator.rest;

import com.example.reportgenerator.dto.ProductReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductAPIClient {

    private final WebClient client;

    @Autowired
    public ProductAPIClient(WebClient c) {
        client = c;
    }

    public ProductReportData getProductReportData(String dateStart, String dateEnd) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("statistics/products")
                        .queryParam("dateStart", dateStart)
                        .queryParam("dateEnd", dateEnd)
                        .build())
                .retrieve()
                .bodyToMono(ProductReportData.class)
                .block();
    }


}

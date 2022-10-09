package com.example.reportgenerator.rest;

import com.example.reportgenerator.dto.OrderReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OrderAPIClient {

    private final WebClient client;

    @Autowired
    public OrderAPIClient(WebClient c) {
        client = c;
    }

    public OrderReportData getOrderReportData(String dateStart, String dateEnd) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("statistics/orders")
                        .queryParam("dateStart", dateStart)
                        .queryParam("dateEnd", dateEnd)
                        .build())
                .retrieve()
                .bodyToMono(OrderReportData.class)
                .block();
    }

}

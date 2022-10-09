package com.example.reportgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
@Getter
@ToString
public class OrderReportValues {

    @JsonProperty("orderId")
    Long orderId;

    @JsonProperty("orderStatus")
    String orderStatus;

    @JsonProperty("dateDone")
    Date dateDone;

    @JsonProperty("productNamesNum")
    int productNamesNum;

    @JsonProperty("categoriesNum")
    int categoriesNum;

    @JsonProperty("providersNum")
    int providersNum;

    @JsonProperty("cost")
    double cost;

    @JsonProperty("avgProductPrice")
    double avgProductPrice;

    @JsonProperty("overallProductsNum")
    int overallProductsNum;


}

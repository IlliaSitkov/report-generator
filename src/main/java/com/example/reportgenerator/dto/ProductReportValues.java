package com.example.reportgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductReportValues {

    @JsonProperty(value = "articul")
    private Long articul;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "soldQuantity")
    private int soldQuantity;

    @JsonProperty(value = "soldCost")
    private double soldCost;

    @JsonProperty(value = "averageQuantityInOrder")
    private int averageQuantityInOrder;

    @JsonProperty(value = "quantityOfCustomers")
    private int quantityOfCustomers;
}

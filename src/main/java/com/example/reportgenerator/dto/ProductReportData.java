package com.example.reportgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class ProductReportData {

    @JsonProperty("productReportValues")
    private Iterable<ProductReportValues> productReportValues;

    @JsonProperty("soldProductsQuantity")
    private int soldProductsQuantity;

    @JsonProperty("dateStart")
    private Date dateStart;

    @JsonProperty("dateEnd")
    private Date dateEnd;
}

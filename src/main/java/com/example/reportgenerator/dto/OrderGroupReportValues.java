package com.example.reportgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderGroupReportValues {

    @JsonProperty("status")
    String status;

    @JsonProperty("orderNum")
    int orderNum;

    @JsonProperty("orderGroupCost")
    double orderGroupCost;

    @JsonProperty("avgOrderCost")
    double avgOrderCost;

}

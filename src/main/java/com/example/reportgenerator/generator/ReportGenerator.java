package com.example.reportgenerator.generator;

import com.example.reportgenerator.dto.OrderGroupReportValues;
import com.example.reportgenerator.dto.OrderReportValues;
import com.example.reportgenerator.dto.ProductReportValues;

import java.util.Date;

public interface ReportGenerator {

    void generateOrdersReport(Date dateStart,
                                     Date dateEnd,
                                     String filePath,
                                     double fullIncome,
                                     int ordersQuantity,
                                     double averageOrderCost,
                                     Iterable<OrderGroupReportValues> orderGroupReportValues,
                                     Iterable<OrderReportValues> orderReportValues);
    void generateProductsReport(Date dateStart,
                                Date dateEnd,
                                String filePath,
                                int soldProductsQuantity,
                                Iterable<ProductReportValues> productReportValues);

}

package com.example.reportgenerator.service.reportservice;

import com.example.reportgenerator.dto.*;
import com.example.reportgenerator.generator.ReportGenerator;
import com.example.reportgenerator.rest.OrderAPIClient;
import com.example.reportgenerator.rest.ProductAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportGenerator reportGenerator;

    private final OrderAPIClient orderClient;

    private final ProductAPIClient productClient;

    @Autowired
    public ReportServiceImpl(ReportGenerator reportGenerator, OrderAPIClient orderClient, ProductAPIClient productClient) {
        this.reportGenerator = reportGenerator;
        this.orderClient = orderClient;
        this.productClient = productClient;
    }

    @Override
    public void generateOrdersReport(String dateStart, String dateEnd, String filePath) {
        OrderReportData data = orderClient.getOrderReportData(dateStart, dateEnd);
        double fullIncome = data.getFullIncome();
        int ordersQuantity = data.getOrdersQuantity();
        double averageOrderCost = data.getAverageOrderCost();
        Iterable<OrderGroupReportValues> orderGroupReportValues = data.getOrderGroupReportValues();
        Iterable<OrderReportValues> orderReportValues = data.getOrderReportValues();
        Date dStart = data.getDateStart();
        Date dEnd = data.getDateEnd();

        reportGenerator.generateOrdersReport(
                dStart, dEnd, filePath,
                fullIncome, ordersQuantity, averageOrderCost,
                orderGroupReportValues, orderReportValues
        );
    }

    @Override
    public void generateProductsReport(String dateStart, String dateEnd, String filePath) {

        ProductReportData data = productClient.getProductReportData(dateStart, dateEnd);

        int soldProductsQuantity = data.getSoldProductsQuantity();
        Iterable<ProductReportValues> productReportValues = data.getProductReportValues();
        Date dStart = data.getDateStart();
        Date dEnd = data.getDateEnd();

        reportGenerator.generateProductsReport(
                dStart, dEnd, filePath,
                soldProductsQuantity, productReportValues
        );
    }
}
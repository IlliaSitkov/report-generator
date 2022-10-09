package com.example.reportgenerator.service.reportservice;

public interface ReportService {

    void generateOrdersReport(String dateStart, String dateEnd, String filePath);
    void generateProductsReport(String dateStart, String dateEnd, String filePath);

}

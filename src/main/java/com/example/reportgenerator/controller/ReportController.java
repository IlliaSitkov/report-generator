package com.example.reportgenerator.controller;

import com.example.reportgenerator.service.fileservice.FileService;
import com.example.reportgenerator.service.reportservice.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@Validated
@RequestMapping("/reports")
public class ReportController {


    private final ReportService reportService;

    private final FileService fileService;

    @Autowired
    public ReportController(ReportService reportService, FileService fileService) {
        this.reportService = reportService;
        this.fileService = fileService;
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getOrdersReport(@RequestParam(value = "dateStart", required = false) String dateStart, @RequestParam(value = "dateEnd",required = false) String dateEnd) {
        String filePath = "src/main/resources/static/ordersReport.pdf";
        reportService.generateOrdersReport(dateStart,dateEnd, filePath);
        return fileService.getFileByteArray(filePath);
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] getProductsReport(@RequestParam(value = "dateStart", required = false) String dateStart, @RequestParam(value = "dateEnd",required = false) String dateEnd) {
        String filePath = "src/main/resources/static/productsReport.pdf";
        reportService.generateProductsReport(dateStart,dateEnd, filePath);
        return fileService.getFileByteArray(filePath);
    }


}

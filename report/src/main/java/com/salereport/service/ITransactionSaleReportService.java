package com.salereport.service;

import com.tablet.model.Transaction;

import java.io.IOException;
import java.util.List;

public interface ITransactionSaleReportService {
    void excelReport(List<Transaction> listSaleTransaction) throws IOException;
}

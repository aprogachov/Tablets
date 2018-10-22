package com.salereport.mapper;

import com.tablet.model.Transaction;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TransactionSaleMapper {
    List<Transaction> getTransactions(@Param("dateFrom") Date dateFrom, @Param("dateBefore") Date dateBefore);
}

package com.learn.bank.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Transaction {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
    private Type type;
    private String date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;

    public Date getSubmissionDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.date = dateFormat.format(date);
    }



}

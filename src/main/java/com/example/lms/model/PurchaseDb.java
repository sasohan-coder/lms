package com.example.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDb {
    private String book;
    private String vendor;
    private String date;
    private int quantity;
    private double pricePerBook;
    private double totalAmount;
}
package com.example.lms.Dto;

import com.example.lms.model.PurchaseDb;

public record PurchaseDto(
        String book,
        String vendor,
        String date,
        int quantity,
        double pricePerBook,
        double totalAmount) {

    public PurchaseDb toPurchase() {
        return new PurchaseDb(book, vendor, date, quantity, pricePerBook, totalAmount);
    }
}
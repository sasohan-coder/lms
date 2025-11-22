package com.example.lms.Dto;

import com.example.lms.model.VendorDb;

public record VendorDto(
        String name,
        String company,
        String phone,
        String email) {

    public VendorDb toVendor() {
        return new VendorDb(name, company, phone, email);
    }
}
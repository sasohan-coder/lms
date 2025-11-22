package com.example.lms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDb {
    private String name;
    private String company;
    private String phone;
    private String email;
}
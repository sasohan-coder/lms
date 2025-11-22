package com.example.lms.Service;

import com.example.lms.model.VendorDb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorDbService {
    private final List<VendorDb> vendorList = new ArrayList<>();

    public VendorDb save(VendorDb vendor) {
        vendorList.add(vendor);
        System.out.println("Vendor saved: " + vendor.getName() + ", Total vendors: " + vendorList.size());
        return vendor;
    }

    public List<VendorDb> getAll() {
        System.out.println("Returning " + vendorList.size() + " vendors");
        return new ArrayList<>(vendorList);
    }
}
package com.example.lms.Service;

import com.example.lms.model.PurchaseDb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseDbService {
    private final List<PurchaseDb> purchaseList = new ArrayList<>();
private final BookDbService bookDbService;

public PurchaseDbService(BookDbService bookDbService){
    this.bookDbService = bookDbService;
}


    public PurchaseDb save(PurchaseDb purchase) {
        purchaseList.add(purchase);
        System.out.println("Purchase saved: " + purchase.getBook() + ", Total purchases: " + purchaseList.size());
        bookDbService.updateStock(purchase.getBook(), purchase.getQuantity());
        return purchase;
    }

    public List<PurchaseDb> getAll() {
        System.out.println("Returning " + purchaseList.size() + " purchases");
        return new ArrayList<>(purchaseList);
    }
}
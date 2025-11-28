package com.example.lms.Controller;

import com.example.lms.Dto.*;
import com.example.lms.Service.BookDbService;
import com.example.lms.Service.PurchaseDbService;
import com.example.lms.Service.StudentDbService;
import com.example.lms.Service.VendorDbService;
import com.example.lms.model.BookDb;
import com.example.lms.model.PurchaseDb;
import com.example.lms.model.StudentDb;
import com.example.lms.model.VendorDb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AllController {

    private final BookDbService bookDbService;
    private final VendorDbService vendorDbService;
private final PurchaseDbService purchaseDbService;
private final StudentDbService studentDbService;
    public AllController(BookDbService bookDbService, VendorDbService vendorDbService, PurchaseDbService purchaseDbService, StudentDbService studentDbService) {
        this.bookDbService = bookDbService;
        this.vendorDbService = vendorDbService;
        this.purchaseDbService = purchaseDbService;
        this.studentDbService = studentDbService;
    }





    @GetMapping("/addbook")
    public String addbook(Model model){
        model.addAttribute("dto", new BookDto("", "", "","","",0));
        return "AddBook";
    }

    @PostMapping("/addbook")
    public String doAddBook(@ModelAttribute BookDto dto) {
        System.out.println("Adding Book: " + dto);
        BookDb book = bookDbService.save(dto.toBook());
        System.out.println("Book added successfully: " + book.getName());
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String books(Model model){
        List<BookDb> bookList = bookDbService.getAll();
        model.addAttribute("bookList", bookList);
        return "BooksAllotment";
    }


    @GetMapping("/addvendor")
    public String addVendor(Model model) {
        model.addAttribute("dto", new VendorDto("", "", "", ""));
        return "AddVendor";
    }

    @PostMapping("/addvendor")
    public String doAddVendor(@ModelAttribute VendorDto dto) {
        System.out.println("Adding Vendor: " + dto);
        VendorDb vendor = vendorDbService.save(dto.toVendor());
        System.out.println("Vendor added successfully: " + vendor.getName());
        return "redirect:/vendors";
    }

    @GetMapping("/vendors")
    public String vendors(Model model) {
        List<VendorDb> vendorList = vendorDbService.getAll();
        model.addAttribute("vendorList", vendorList);
        return "Vendor";
    }

    @GetMapping("/purchaselist")
    public String purchaselist(Model model){
        List<PurchaseDb> purchaseList = purchaseDbService.getAll();
        model.addAttribute("purchaseList", purchaseList);
        return "purchaselist";
    }

    @GetMapping("/addpurchase")
    public String addpurchaselist(Model model){
        model.addAttribute("dto", new PurchaseDto("", "", "", 0, 0.0, 0.0));
        model.addAttribute("books", bookDbService.getAll());
        model.addAttribute("vendors", vendorDbService.getAll());
        return "addpurchase";
    }

    @PostMapping("/addpurchase")
    public String doAddPurchase(@ModelAttribute PurchaseDto dto) {
        // Convert DTO to entity first
        PurchaseDb purchase = dto.toPurchase();

        // Save the purchase
        PurchaseDb savedPurchase = purchaseDbService.save(purchase);
        return "redirect:/purchaselist";
    }


    @GetMapping("/student")
    public String student(Model model){
        List<StudentDb> studentList = studentDbService.getAll();
        model.addAttribute("studentList", studentList);
        return "Student";
    }

    @GetMapping("/addstudent")
    public String addstudent(Model model){
        model.addAttribute("dto", new StudentDto("", "", ""));
        return "AddStudent";
    }

    @PostMapping("/addstudent")
    public String doAddStudent(@ModelAttribute StudentDto dto) {
        System.out.println("Adding Student: " + dto);
        StudentDb student = studentDbService.save(dto.toStudent());
        System.out.println("Student added successfully: " + student.getName());
        return "redirect:/student";
    }





    @GetMapping("/buybook")
    public String buybook(Model model) {
        model.addAttribute("books", bookDbService.getAll());
        model.addAttribute("students", studentDbService.getAll());
        model.addAttribute("dto", new BookSubmitDto("","","",0)); // নতুন DTO যোগ করুন
        return "buybook";
    }

    @PostMapping("/buybook")
    public String submitBook(@ModelAttribute("dto") BookSubmitDto dto, Model model) {
        try {
            // Validation
            if (dto.getCount() <= 0) {
                model.addAttribute("error", "Count must be greater than 0!");
                model.addAttribute("books", bookDbService.getAll());
                model.addAttribute("students", studentDbService.getAll());
                return "buybook";
            }

            // Decrease book quantity
            boolean success = bookDbService.decreaseBookQuantity(dto.getBookName(), dto.getCount());

            if (success) {
                model.addAttribute("message", "Book submitted successfully! Stock updated.");
            } else {
                model.addAttribute("error", "Not enough books in stock!");
            }

        } catch (Exception e) {
            model.addAttribute("error", "Error: " + e.getMessage());
        }


        model.addAttribute("books", bookDbService.getAll());
        model.addAttribute("students", studentDbService.getAll());
        return "buybook";
    }

}
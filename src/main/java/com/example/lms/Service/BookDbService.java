package com.example.lms.Service;

import com.example.lms.model.BookDb;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookDbService {
    private final List<BookDb> bookList = new ArrayList<>();

    public BookDb save(BookDb book) {
        bookList.add(book);
        System.out.println("Book saved: " + book.getName() + ", Total books: " + bookList.size());
        return book;
    }

    public List<BookDb> getAll() {
        System.out.println("Returning " + bookList.size() + " books");
        return new ArrayList<>(bookList);
    }

    public void updateStock(String bookName, int quantityToAdd) {
        for (BookDb book : bookList) {
            if (book.getName().equals(bookName)) {
                int currentStock = book.getStock();
                book.setStock(currentStock + quantityToAdd);
                System.out.println("Stock updated for " + bookName + ": " + currentStock + " -> " + book.getStock());
                return;
            }
        }
        System.out.println("Book not found: " + bookName);
    }

    public boolean decreaseBookQuantity(String bookName, int quantityToDecrease) {
        for (BookDb book : bookList) {
            if (book.getName().equals(bookName)) {
                int currentStock = book.getStock();
                if (currentStock >= quantityToDecrease) {
                    book.setStock(currentStock - quantityToDecrease);
                    System.out.println("Stock decreased for " + bookName + ": " + currentStock + " -> " + book.getStock());
                    return true;
                } else {
                    System.out.println("Not enough stock for " + bookName + ". Available: " + currentStock + ", Requested: " + quantityToDecrease);
                    return false;
                }
            }
        }
        System.out.println("Book not found: " + bookName);
        return false;
    }

}
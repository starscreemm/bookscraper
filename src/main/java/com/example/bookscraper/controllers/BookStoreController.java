package com.example.bookscraper.controllers;

import com.example.bookscraper.models.Book;
import com.example.bookscraper.services.BookStoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookStoreController {
    private BookStoreService service;

    @GetMapping
    public List<Book> findBooks(@RequestParam String query) {
        return service.findBooks(query);
    }
}

package com.example.bookscraper.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

public record Book(
        String title,
        String description,
        String price,
        boolean available,
        List<String> authors,
        String imgUrl,
        String bookUrl
) {
}

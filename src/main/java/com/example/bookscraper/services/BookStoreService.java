package com.example.bookscraper.services;

import com.example.bookscraper.models.Book;
import com.example.bookscraper.stores.BookStore;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookStoreService {
    private WebDriver driver;
    private List<BookStore> bookStores;

    public List<Book> findBooks(String query) {
        return bookStores.stream().flatMap(store -> {
            driver.get(String.format(store.getUrl(), query));
            List<WebElement> elements = driver.findElements(By.cssSelector(store.getBookUrlSelector()));
            return elements.stream().map(bookUrl -> {
                driver.get(bookUrl.getAttribute("href"));
                WebElement element = driver.findElement(By.id("art_data"));
                return store.extractBookFrom(element);
            });
        }).collect(Collectors.toList());
    }
}

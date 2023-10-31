package com.example.bookscraper.stores;

import com.example.bookscraper.models.Book;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;

@RequiredArgsConstructor
@Getter
public abstract class BookStore {
    private final String url;
    private final String mainSelector;
    private final String bookDetailsSelector;
    private final String titleBookSelector;
    private final String descriptionBookSelector;
    private final String imgBookSelector;
    private final String bookUrlSelector;
    private final String authorsListBookSelector;
    private final String priceBookSelector;
    private final String availableBookSelector;

//    private final String isbnBookSelector;
//    private final String publicationBookSelector;
//    private final String producerBookSelector;

    public abstract Book extractBookFrom(WebElement element);

}

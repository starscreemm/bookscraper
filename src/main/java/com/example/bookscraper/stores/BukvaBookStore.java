package com.example.bookscraper.stores;

import com.example.bookscraper.models.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BukvaBookStore extends BookStore {
    public BukvaBookStore(
           @Value("${store.bukva.searchUrl}") String url,
           @Value("${store.bukva.mainSelector}") String mainSelector,
           @Value("${store.bukva.bookDetailsSelector}") String bookDetailsSelector,
           @Value("${store.bukva.titleBookSelector}") String titleBookSelector,
           @Value("${store.bukva.descriptionBookSelector}") String descriptionBookSelector,
           @Value("${store.bukva.imgBookSelector}") String imgBookSelector,
           @Value("${store.bukva.bookUrlSelector}") String bookUrlSelector,
           @Value("${store.bukva.authorsListBookSelector}") String authorsListBookSelector,
           @Value("${store.bukva.priceBookSelector}") String priceBookSelector,
           @Value("${store.bukva.availableBookSelector}") String availableBookSelector
    ) {
        super(
                url,
                mainSelector,
                bookDetailsSelector,
                titleBookSelector,
                descriptionBookSelector,
                imgBookSelector,
                bookUrlSelector,
                authorsListBookSelector,
                priceBookSelector,
                availableBookSelector
        );

    }

    @Override
    public Book extractBookFrom(WebElement element) {
        List<WebElement> titlesElems = element.findElements(By.cssSelector(getTitleBookSelector()));
        if (titlesElems.isEmpty()) {
            return null;
        }
        String title = titlesElems.get(0).getText();

        List<WebElement> descriptionElems = element.findElements(By.cssSelector(getDescriptionBookSelector()));
        String description = descriptionElems.isEmpty() ? "" : descriptionElems.get(0).getText();

        List<WebElement> bookUrlElems = element.findElements(By.cssSelector(getBookUrlSelector()));
        String bookUrl = bookUrlElems.isEmpty() ? "" : bookUrlElems.get(0).getAttribute("href");

        List<WebElement> imgUrlElems = element.findElements(By.cssSelector(getImgBookSelector()));
        String imgUrl = imgUrlElems.isEmpty() ? "" : imgUrlElems.get(0).getAttribute("src");

        List<WebElement> priceElems = element.findElements(By.cssSelector(getPriceBookSelector()));
        String price = priceElems.isEmpty() ? "" : imgUrlElems.get(0).getText();

        List<WebElement> authorsListElems = element.findElements(By.cssSelector(getAuthorsListBookSelector()));
        String authorsList = authorsListElems.isEmpty() ? "" : authorsListElems.get(0).getText().trim();
        List<String> authors = List.of(authorsList.split(", "));

        List<WebElement> availableElems = element.findElements(By.cssSelector(getAvailableBookSelector()));
        String availableText = availableElems.isEmpty() ? "" : availableElems.get(0).getText().toLowerCase();
        boolean available = availableText.equals("купити");

        return new Book(title, description, price, available, authors, imgUrl, bookUrl);
    }
}

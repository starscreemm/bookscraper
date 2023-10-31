package com.example.bookscraper.configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class SeleniumConfiguration {

    @Bean
    public WebDriver driver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        var resource = SeleniumConfiguration.class.getResource("/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(resource).getPath());
        return driver;
    }
}

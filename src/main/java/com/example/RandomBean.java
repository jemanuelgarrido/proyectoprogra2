package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import org.asynchttpclient.*;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
@Named
@ViewScoped
public class RandomBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(RandomBean.class.getName());

    private transient AsyncHttpClient client;
    private Random random;
    private int min = 10; // Default value
    private int max = 20; // Default value

    @PostConstruct
    public void init() {
        client = new DefaultAsyncHttpClient();
    }

    public void fetchTrivia() {
        CompletableFuture.runAsync(() -> {
            try {
                String url = String.format("https://numbersapi.p.rapidapi.com/random/trivia?json=true&fragment=true&min=%d&max=%d", min, max);
                String responseBody = client.prepare("GET", url)
                        .setHeader("X-RapidAPI-Key", "be1e2af274msh084c172c1372646p1184f4jsn1ec45330330c")
                        .setHeader("X-RapidAPI-Host", "numbersapi.p.rapidapi.com")
                        .execute()
                        .toCompletableFuture()
                        .thenApply(response -> response.getResponseBody())
                        .join();

                ObjectMapper objectMapper = new ObjectMapper();
                this.random = objectMapper.readValue(responseBody, Random.class);
                LOGGER.info("Trivia fetched: " + random);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error fetching trivia", e);
            }
        });
    }

    @PreDestroy
    public void cleanup() {
        try {
            if (client != null) {
                client.close();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error closing client", e);
        }
    }
}

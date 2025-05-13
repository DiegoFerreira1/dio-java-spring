package me.dio.model;

import lombok.Data;
import java.util.List;

@Data
public class User {

    private String name;
    private Account account;
    private List<Feature> features;
    private List<Card> card;
    private List<News> news;
}

package me.dio.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Card {

    private String number;
    private BigDecimal limit;
}

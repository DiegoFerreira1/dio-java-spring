package me.dio.model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity(name = "tb_account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;


    private String agency;
    // 99.999.999.999,99
    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;
}


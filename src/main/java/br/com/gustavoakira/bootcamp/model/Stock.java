package br.com.gustavoakira.bootcamp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_stock")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "variation")
    private Double variation;

    @Column(name = "date")
    private LocalDate date;
}

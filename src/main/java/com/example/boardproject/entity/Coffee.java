package com.example.boardproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String price;

    public void patch(com.example.boardproject.dto.CoffeeUpdateDto dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
    }
}


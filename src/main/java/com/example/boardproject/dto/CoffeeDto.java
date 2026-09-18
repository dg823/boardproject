package com.example.boardproject.dto;

import com.example.boardproject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CoffeeDto {
    private Long id;
    private String name;
    private String price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}


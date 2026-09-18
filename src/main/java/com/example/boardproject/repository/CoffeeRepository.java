package com.example.boardproject.repository;

import com.example.boardproject.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}


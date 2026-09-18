package com.example.boardproject.api;

import com.example.boardproject.dto.CoffeeDto;
import com.example.boardproject.dto.CoffeeUpdateDto;
import com.example.boardproject.entity.Coffee;
import com.example.boardproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class CoffeeApiController {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/api/coffees")
    public Iterable<Coffee> list() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/api/coffees/{id}")
    public Coffee read(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/coffees")
    public Coffee create(@RequestBody CoffeeDto coffeeDto) {
        Coffee coffee = coffeeDto.toEntity();
        return coffeeRepository.save(coffee);
    }

    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeUpdateDto coffeeUpdateDto) {
        if (!id.equals(coffeeUpdateDto.getId())) {
            log.warn("ID 불일치 pathId={}, bodyId={}", id, coffeeUpdateDto.getId());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Coffee target = coffeeRepository.findById(id).orElse(null);

        if (target == null) {
            log.warn("존재하지 않는 커피 수정 요청 id={}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        target.patch(coffeeUpdateDto);
        Coffee updated = coffeeRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if (target == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}


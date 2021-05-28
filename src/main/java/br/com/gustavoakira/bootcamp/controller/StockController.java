package br.com.gustavoakira.bootcamp.controller;

import br.com.gustavoakira.bootcamp.model.dto.StockDTO;
import br.com.gustavoakira.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){

        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StockDTO> delete(Long id){
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("today")
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());
    }
}

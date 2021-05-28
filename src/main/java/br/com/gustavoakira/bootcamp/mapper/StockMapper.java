package br.com.gustavoakira.bootcamp.mapper;

import br.com.gustavoakira.bootcamp.model.Stock;
import br.com.gustavoakira.bootcamp.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        stock.setDate(dto.getDate());
        return stock;
    }

    public  StockDTO toDTO(Stock stock){
        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setVariation(stock.getVariation());
        dto.setPrice(stock.getPrice());
        dto.setDate(stock.getDate());
        dto.setName(stock.getName());
        return dto;
    }

    public List<StockDTO> toDTO(List<Stock> list) {

        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

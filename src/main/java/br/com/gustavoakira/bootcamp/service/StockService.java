package br.com.gustavoakira.bootcamp.service;

import br.com.gustavoakira.bootcamp.exception.BusinessException;
import br.com.gustavoakira.bootcamp.exception.NotFoundException;
import br.com.gustavoakira.bootcamp.mapper.StockMapper;
import br.com.gustavoakira.bootcamp.model.Stock;
import br.com.gustavoakira.bootcamp.model.dto.StockDTO;
import br.com.gustavoakira.bootcamp.repository.StockRepository;
import br.com.gustavoakira.bootcamp.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;
    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(),dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(),dto.getDate(),dto.getId());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDTO(stock);
    }
    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> list = repository.findAll();
        return mapper.toDTO(list);
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }
    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }
}

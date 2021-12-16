package com.systemhospital.service;

import com.systemhospital.core.GenericObjectMapper;
import com.systemhospital.core.GenericEntity_;
import com.systemhospital.entities.Historic;
import com.systemhospital.entitiesDto.HistoricDto;
import com.systemhospital.repository.HistoricRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricService {
    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private HistoricRepository historicRepository;

    public List<HistoricDto> historictFindAll(Integer page, Integer pageSize){
        return this.mapper.mapListTo(this.historicRepository.findAll(
                PageRequest.of(page,pageSize, Sort.by("id")))
                .stream().toList()
                , HistoricDto.class);
    }


    public HistoricDto historicFindById(Long historicId){
        return this.mapper.mapTo(this.historicRepository.findById(historicId), HistoricDto.class);
    }


    public ResponseEntity<HistoricDto> saveHistoric(HistoricDto historicDto){
        Historic newHistoric =  this.mapper.mapTo(historicDto, Historic.class);
        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.historicRepository.save(newHistoric), HistoricDto.class));
    }

    public ResponseEntity<HistoricDto> updateHistoric(HistoricDto historicDto){
        Historic updateHistoric = this.mapper.mapTo(historicDto, Historic.class);
        Historic searchHistoric = this.historicRepository.findById(historicDto.getId()).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(updateHistoric, searchHistoric, GenericEntity_.ID);

        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.historicRepository.save(updateHistoric), HistoricDto.class));
    }

    public void deletHistoric(Long historicId){
        this.historicRepository.deleteById(historicId);
    }
}

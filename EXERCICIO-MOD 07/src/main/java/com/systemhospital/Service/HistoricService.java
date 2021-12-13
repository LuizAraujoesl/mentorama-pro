package com.systemhospital.Service;

import com.systemhospital.core.GenericObjectMapper;
import com.systemhospital.entities.GenericEntity_;
import com.systemhospital.entities.Historic;
import com.systemhospital.entitiesDto.HistoricDto;
import com.systemhospital.entitiesDto.PatientDto;
import com.systemhospital.repository.HistoricRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<HistoricDto> historictFindAll(){
        return this.mapper.mapListTo(this.historicRepository.findAll(), HistoricDto.class);
    }


    public HistoricDto historicFindById(Integer historicId){
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

    public void deletHistoric(Integer historicId){
        this.historicRepository.deleteById(historicId);
    }
}

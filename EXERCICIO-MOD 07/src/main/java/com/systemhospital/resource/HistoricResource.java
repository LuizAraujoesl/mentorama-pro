package com.systemhospital.resource;

import com.systemhospital.Service.HistoricService;
import com.systemhospital.entitiesDto.HistoricDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/historic")
public class HistoricResource {

    @Autowired
    private HistoricService historicService;

    @GetMapping
    public ResponseEntity<List<HistoricDto>> findall(){
        return ResponseEntity.status(HttpStatus.OK).body(this.historicService.historictFindAll());
    }

    @GetMapping(value = "/id")
    public ResponseEntity<HistoricDto> findaById(@PathVariable Integer id ){
        return ResponseEntity.status(HttpStatus.OK).body(this.historicService.historicFindById(id));
    }

    @PostMapping(value = "/new-patient")
    public ResponseEntity<HistoricDto> saveHistoric(@RequestBody HistoricDto historicDto){
        return this.historicService.saveHistoric(historicDto);
    }

    @PutMapping( value = "/update-patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HistoricDto> updateHistoric(@RequestBody HistoricDto historicDto){
        return this.historicService.updateHistoric(historicDto);
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity deleteHistoric(@PathVariable Integer id ){
        this.historicService.deletHistoric(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

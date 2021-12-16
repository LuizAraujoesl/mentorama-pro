package com.systemhospital.resource;


import com.systemhospital.entities.Patient;
import com.systemhospital.service.PatientService;
import com.systemhospital.entitiesDto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientResource {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDto>> findall(@RequestParam("page") Integer page,
                                                    @RequestParam("pageSize") Integer pageSize){
          return ResponseEntity.status(HttpStatus.OK).body(this.patientService.patientFindAll(page, pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> findaById(@PathVariable Integer id ){
        return ResponseEntity.status(HttpStatus.OK).body(this.patientService.patientFindById(id));
    }

    @PostMapping(value = "/new-patient")
    public ResponseEntity<PatientDto> savePatient(@RequestBody PatientDto patientDto){
        return this.patientService.savePatient(patientDto);
    }

    @PutMapping( value = "/update-patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto){
        return this.patientService.savePatient(patientDto);
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity deleteHistoric(@PathVariable Integer id ){
        this.patientService.deletPatient(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}

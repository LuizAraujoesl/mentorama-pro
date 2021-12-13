package com.systemhospital.Service;

import com.systemhospital.core.GenericObjectMapper;
import com.systemhospital.entities.GenericEntity_;
import com.systemhospital.entities.Patient;
import com.systemhospital.entitiesDto.PatientDto;
import com.systemhospital.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDto>  patientFindAll(){
        return this.mapper.mapListTo(this.patientRepository.findAll(), PatientDto.class);
    }


    public PatientDto patientFindById(Integer patientId){
        return this.mapper.mapTo(this.patientRepository.findById(patientId), PatientDto.class);
    }


    public ResponseEntity<PatientDto> savePatient(PatientDto patientDto){
        Patient newPatient =  this.mapper.mapTo(patientDto, Patient.class);
        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.patientRepository.save(newPatient), PatientDto.class));
    }

    public ResponseEntity<PatientDto> updatePatient(PatientDto patientDto){
        Patient updatePatient = this.mapper.mapTo(patientDto, Patient.class);
        Patient searchPatient = this.patientRepository.findById(patientDto.getId()).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(updatePatient, searchPatient, GenericEntity_.ID);

        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.patientRepository.save(updatePatient), PatientDto.class));
    }

    public void deletPatient(Integer patientId){
        this.patientRepository.deleteById(patientId);
    }
}

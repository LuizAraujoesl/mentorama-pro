package com.systemhospital.service;

import com.systemhospital.core.GenericObjectMapper;
import com.systemhospital.core.GenericEntity_;
import com.systemhospital.entities.ProfessionalMedicine;
import com.systemhospital.entitiesDto.ProfessionalMedicineDto;
import com.systemhospital.repository.ProfessionalMedicineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionaisMedicineService {
    @Autowired
    private GenericObjectMapper mapper;

    @Autowired
    private ProfessionalMedicineRepository profissional;

    public List<ProfessionalMedicineDto> profissionalFindAll(Integer page, Integer pageSize){
        return this.mapper.mapListTo(this.profissional.findAll(
                PageRequest.of(page,pageSize,
                        Sort.by("id")))
                        .stream().toList()
                , ProfessionalMedicineDto.class);
    }


    public ProfessionalMedicineDto profissionalFindById(Integer profissionalId){
        return this.mapper.mapTo(this.profissional.findById(profissionalId), ProfessionalMedicineDto.class);
    }


    public ResponseEntity<ProfessionalMedicineDto> saveProfissional(ProfessionalMedicineDto professionalMedicineDto){
        ProfessionalMedicine newProfissional =  this.mapper.mapTo(professionalMedicineDto, ProfessionalMedicine.class);
        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.profissional.save(newProfissional), ProfessionalMedicineDto.class));
    }

    public ResponseEntity<ProfessionalMedicineDto> updateProfissional(ProfessionalMedicineDto professionalMedicineDto){
        ProfessionalMedicine updateProfessional = this.mapper.mapTo(professionalMedicineDto, ProfessionalMedicine.class);
        ProfessionalMedicine searchProfissional = this.profissional.findById(professionalMedicineDto.getMatricula()).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(updateProfessional, searchProfissional, GenericEntity_.ID);

        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.profissional.save(updateProfessional), ProfessionalMedicineDto.class));
    }

    public void deletProfissional(Integer profissionalId){
        this.profissional.deleteById(profissionalId);
    }
}

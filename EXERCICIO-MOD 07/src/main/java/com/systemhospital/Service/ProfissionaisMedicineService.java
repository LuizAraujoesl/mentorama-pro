package com.systemhospital.Service;

import com.systemhospital.core.GenericObjectMapper;
import com.systemhospital.entities.GenericEntity_;
import com.systemhospital.entities.Historic;
import com.systemhospital.entities.ProfessionalMedicine;
import com.systemhospital.entitiesDto.HistoricDto;
import com.systemhospital.entitiesDto.ProfissionalMedicineDto;
import com.systemhospital.repository.HistoricRepository;
import com.systemhospital.repository.ProfessionalMedicineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ProfissionalMedicineDto> profissionalFindAll(){
        return this.mapper.mapListTo(this.profissional.findAll(), ProfissionalMedicineDto.class);
    }


    public ProfissionalMedicineDto profissionalFindById(Integer profissionalId){
        return this.mapper.mapTo(this.profissional.findById(profissionalId), ProfissionalMedicineDto.class);
    }


    public ResponseEntity<ProfissionalMedicineDto> saveProfissional(ProfissionalMedicineDto profissionalMedicineDto){
        ProfessionalMedicine newProfissional =  this.mapper.mapTo(profissionalMedicineDto, ProfessionalMedicine.class);
        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.profissional.save(newProfissional), ProfissionalMedicineDto.class));
    }

    public ResponseEntity<ProfissionalMedicineDto> updateProfissional(ProfissionalMedicineDto profissionalMedicineDto){
        ProfessionalMedicine updateProfessional = this.mapper.mapTo(profissionalMedicineDto, ProfessionalMedicine.class);
        ProfessionalMedicine searchProfissional = this.profissional.findById(profissionalMedicineDto.getMatricula()).orElseThrow(RuntimeException::new);
        BeanUtils.copyProperties(updateProfessional, searchProfissional, GenericEntity_.ID);

        return ResponseEntity.status(HttpStatus.OK).body(
                this.mapper.mapTo(this.profissional.save(updateProfessional), ProfissionalMedicineDto.class));
    }

    public void deletProfissional(Integer profissionalId){
        this.profissional.deleteById(profissionalId);
    }
}

package com.systemhospital.resource;

import com.systemhospital.Service.PatientService;
import com.systemhospital.Service.ProfissionaisMedicineService;
import com.systemhospital.entitiesDto.PatientDto;
import com.systemhospital.entitiesDto.ProfissionalMedicineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profissional")
public class ProfissionaisMedicineResource {

    @Autowired
    private ProfissionaisMedicineService profService;

    @GetMapping
    public ResponseEntity<List<ProfissionalMedicineDto>> findall(){
        return ResponseEntity.status(HttpStatus.OK).body(this.profService.profissionalFindAll());
    }

    @GetMapping(value = "/id")
    public ResponseEntity<ProfissionalMedicineDto> findaById(@PathVariable Integer id ){
        return ResponseEntity.status(HttpStatus.OK).body(this.profService.profissionalFindById(id));
    }

    @PostMapping(value = "/new-profissional")
    public ResponseEntity<ProfissionalMedicineDto> saveProfissional(@RequestBody ProfissionalMedicineDto profissionalDto){
        return this.profService.saveProfissional(profissionalDto);
    }

    @PutMapping( value = "/update-profissional", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfissionalMedicineDto> updateProfissional(@RequestBody ProfissionalMedicineDto profissionalDto){
        return this.profService.saveProfissional(profissionalDto);
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity deleteProfissional(@PathVariable Integer id ){
        this.profService.deletProfissional(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

package com.systemhospital.repository;

import com.systemhospital.entities.ProfessionalMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalMedicineRepository extends JpaRepository<ProfessionalMedicine, Integer> {
}

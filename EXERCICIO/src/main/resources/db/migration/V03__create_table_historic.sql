    CREATE TABLE IF NOT EXISTS historic (
         id  serial not null ,
         checkin  timestamp  null ,
         checkout   timestamp  null ,
         diagnosticDescription varchar (500),
         patient_id long,
         professional_medicine_id long,
         primary key (id),
        CONSTRAINT fk_patient_id FOREIGN KEY (patient_id) REFERENCES patient(id),
        CONSTRAINT fk_professional_medicine_id FOREIGN KEY (professional_medicine_id) REFERENCES professional_medicine(matricula)
    );




    INSERT INTO  historic (checkin, checkout, diagnosticDescription, patient_id, professional_medicine_id)
    VALUES ('2021-11-01 14:00:00','2021-11-01 14:40:00', 'Dor de Cabeca', 1, 4 );

    INSERT INTO  historic (checkin, checkout, diagnosticDescription, patient_id, professional_medicine_id )
    VALUES ('2021-11-01 15:00:00','2021-11-01 15:40:00', 'Diarreia', 3, 2 );

    INSERT INTO  historic (checkin, checkout, diagnosticDescription, patient_id, professional_medicine_id)
    VALUES ('2021-11-01 17:00:00','2021-11-01 17:40:00', 'Apendicite', 5 , 3);

    INSERT INTO  historic (checkin, checkout, diagnosticDescription, patient_id, professional_medicine_id)
    VALUES ('2021-11-01 18:00:00','2021-11-01 18:40:00', 'Colica Renal', 4, 5);

    INSERT INTO  historic (checkin, checkout, diagnosticDescription, patient_id, professional_medicine_id)
    VALUES ('2021-11-01 19:00:00','2021-11-01 19:40:00', 'Covidd-19', 4, 3);
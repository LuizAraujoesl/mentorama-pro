
    CREATE TABLE IF NOT EXISTS professional_medicine (
        matricula  serial not null ,
        name       varchar(100) not null,
        gender        varchar(1)  not null,
        department varchar(100) not null ,
        office        varchar(50)  not null ,
        phone     varchar(14),
        primary key (matricula)
    );


    INSERT INTO professional_medicine(name, gender, department, office, phone) VALUES
          ( 'Fernanda da Silva','F', 'Dp. Enfermaria', 'Enfermeira', '62997654533');

    INSERT INTO professional_medicine(name, gender, department, office, phone) VALUES
        ( 'Jose Alencar', 'M', 'Dp. Clinico Geranl', 'Medico', '62997656733');

    INSERT INTO professional_medicine(name, gender, department, office, phone) VALUES
        ('Gustavo Yamashita','M', 'Dp. Cirugia ', 'Cirurgiao geral', '629979648533');

    INSERT INTO professional_medicine(name, gender, department, office, phone) VALUES
        ( 'Suzana Magrao', 'M', 'Dp. Dermatologia ', 'Dermatologista', '629979648533');

    INSERT INTO professional_medicine(name, gender, department, office, phone) VALUES
        ( 'Suzaki Makamoto', 'M', 'Dp. Cirurgia ', 'Cirugiao do Torax', '62998484833');

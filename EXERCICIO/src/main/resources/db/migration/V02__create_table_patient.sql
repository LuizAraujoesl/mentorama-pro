    CREATE TABLE IF NOT EXISTS patient (
        id  serial not null ,
        name      varchar (100) not null,
        gender       varchar(1) not null,
        phone     varchar(14),
        data  date,
        primary key (id)
    );

    INSERT INTO  patient(name,gender,phone, data) VALUES
        ('Agata Silveira', 'F','6389337739', '1997-06-14');

    INSERT INTO  patient(name,gender,phone, data) VALUES
        ('Juliano Morais','M', '6299029288', '2000-02-14');

    INSERT INTO  patient(name,gender,phone, data) VALUES
        ('Pablo Fernandez','M', '656669686', '1968-12-16');

    INSERT INTO  patient(name,gender,phone, data) VALUES
        ('Junior Vasconselos', 'M','6389334444', '1999-12-11');

    INSERT INTO  patient(name,gender,phone, data) VALUES
        ('Lucas Ferreia','M', '64939394994', '1991-03-15');
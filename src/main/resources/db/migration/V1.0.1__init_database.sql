CREATE TABLE departement(
    id int auto_increment primary key,
    name varchar(50) not null
);

CREATE TABLE employee(
    id int auto_increment primary key,
    name varchar(100),
    gender enum('MALE','FEMAL','OTHER') NOT NULL,
    salary double,
    phone varchar(15),
    department_id int,
    foreign key (department_id) references departement(id)
);


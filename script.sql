create table amount_units
(
    id bigserial constraint amount_units_pk
        primary key,
    title text
);

create table types
(
    id    bigserial constraint type_form_pk
        primary key,
    title text not null
);

create table medicines
(
    id             bigserial constraint medicines_pk
        primary key,
    title          text not null,
    amount         integer,
    type_id        integer
        constraint type_fk
            references types,
    amount_unit_id integer
        constraint amount_unit_fk
            references amount_units
);

INSERT INTO types (title) VALUES ('Таблетки');
INSERT INTO types (title) VALUES ('Капсулы');
INSERT INTO types (title) VALUES ('Раствор для инъекций');
INSERT INTO types (title) VALUES ('Мазь');
INSERT INTO types (title) VALUES ('Гель');
INSERT INTO types (title) VALUES ('Раствор');
INSERT INTO types (title) VALUES ('Капли');
INSERT INTO types (title) VALUES ('Прочее');


INSERT INTO amount_units (title) VALUES ('шт');
INSERT INTO amount_units (title) VALUES ('г');
INSERT INTO amount_units (title) VALUES ('мг');
INSERT INTO amount_units (title) VALUES ('мкг');
INSERT INTO amount_units (title) VALUES ('л');
INSERT INTO amount_units (title) VALUES ('мл');
INSERT INTO amount_units (title) VALUES ('мкл');


INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Анальгин 500 мг', 20, 1, 1);
INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Лоперамид 2мг', 10, 2, 1);
INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Кетонал 50 мг/мл', 5, 3, 1);
INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Гидрокортизон 1%', 10, 4, 2);
INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Вольтарен 2%', 100, 5, 2);
INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Рингера', 400, 6, 6);
INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Отривин 0.1%', 10, 7, 6);
INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Бинт стерильный 10 см', 1, 8, 1);
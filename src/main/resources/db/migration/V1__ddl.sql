create table amount_units
(
    id bigserial constraint amount_units_pk primary key,
    title text
);

create table types
(
    id bigserial constraint type_form_pk primary key,
    title text not null
);

create table medicines
(
    id bigserial constraint medicines_pk primary key,
    title text not null,
    amount integer,
    type_id integer constraint type_fk references types,
    amount_unit_id integer constraint amount_unit_fk references amount_units
);

INSERT INTO types (title) VALUES ('Таблетки'),
                                 ('Капсулы'),
                                 ('Раствор для инъекций'),
                                 ('Мазь'),
                                 ('Гель'),
                                 ('Раствор'),
                                 ('Капли'),
                                 ('Прочее');

INSERT INTO amount_units (title) VALUES ('шт'),
                                        ('г'),
                                        ('мг'),
                                        ('мкг'),
                                        ('л'),
                                        ('мл'),
                                        ('мкл');

INSERT INTO medicines (title, amount, type_id, amount_unit_id) VALUES ('Анальгин 500 мг', 20, 1, 1),
                                                                      ('Лоперамид 2мг', 10, 2, 1),
                                                                      ('Кетонал 50 мг/мл', 5, 3, 1),
                                                                      ('Гидрокортизон 1%', 10, 4, 2),
                                                                      ('Вольтарен 2%', 100, 5, 2),
                                                                      ('Рингера', 400, 6, 6),
                                                                      ('Отривин 0.1%', 10, 7, 6),
                                                                      ('Бинт стерильный 10 см', 1, 8, 1);
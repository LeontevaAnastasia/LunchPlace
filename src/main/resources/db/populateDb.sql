DELETE
FROM user_role;
DELETE
FROM users;
DELETE
FROM restaurant;
DELETE
FROM dish;
DELETE
FROM vote;

ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

INSERT INTO USERS (name, email, password)
VALUES ('User1', 'user1@mail.ru', '123'),
       ('User2', 'user2@mail.ru', '345'),
       ('Admin', 'user3@mail.ru', '567');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('USER', 100001),
       ('ADMIN', 100002);

INSERT INTO RESTAURANT(name)
VALUES ('Shabby'),
       ('KillFish'),
       ('Tokyo'),
       ('Teremok');

INSERT INTO MENU(rest_id)
VALUES (100003),
       (100004),
       (100005),
       (100006);

INSERT INTO DISH (name, price, menu_id)
VALUES ('Салат с морепроуктами', 350.00, 100007),
       ('Сырный суп', 150.00, 100007),
       ('Стейк New-York', 670.00, 100008),
       ('Чизбургер', 250.00, 100008),
       ('Матча-Латте', 240.00, 100008),
       ('Боул с угрем', 400.00, 100009),
       ('Свинные ребрышки', 550.00, 100010),
       ('Том-Ям', 480.00, 100010),
       ('Латте', 200.00, 100010),
       ('Овощи гриль', 210.00, 100009);

INSERT INTO VOTE (rest_id, user_id)
VALUES (100003, 100000),
       (100006, 100001),
       (100006, 100002);
INSERT INTO user (document_id, email, enable, name, last_name, user, password) VALUES ('123456', 'mathias.lopez@gmail.com', true, 'Mathias', 'Lopez', 'mathias.lopez', '$2a$10$BIZvhMCP4rpCyrSorUe2u.c846GQaPTXiGzCR7a4FzgkRG/OqY.o.');
INSERT INTO user (document_id, email, enable, name, last_name, user, password) VALUES ('987654', 'bernardo.lopez@gmail.com', true, 'Bernardo', 'Lopez', 'bernardo.lopez', '$2a$10$.aBOjDt7VAZ9d/r3zWu8Ne8jyjA3yPIWLHrPccjzNmutDFHA.HdxG');
INSERT INTO user (document_id, email, enable, name, last_name, user, password) VALUES ('147258', 'leidy.quintero@gmail.com', 1, 'Leidy', 'Quintero', 'leidy.quintero', '$2a$10$RQXGAeWTJYVd9PEY6SZvM.pnIGScIYubjd.6x/CZNahmCG3asSnLy');
INSERT INTO user (document_id, email, enable, name, last_name, user, password) VALUES ('369258', 'nicolas.lopez@gmail.com', 1, 'Nicolas', 'Lopez', 'nicolas.lopez', '$2a$10$5gQuI7nQ9czFrTFn0UmJMeatsMzh4Lo5qLX5tW4MO7av/MAwiQvz.');

INSERT INTO role (description) VALUES ('ROLE_ADMIN');
INSERT INTO role (description) VALUES ('ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 2);
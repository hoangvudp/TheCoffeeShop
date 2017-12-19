INSERT INTO coffeeshop.role (role) VALUES ('ROLE_ADMIN');
INSERT INTO coffeeshop.role (role) VALUES ('ROLE_USER');

INSERT INTO coffeeshop.address (city, country, state, zipcode) VALUES ('Fairfield', 'USA', 'Iowa', '52556');
INSERT INTO coffeeshop.address (city, country, state, zipcode) VALUES ('Ottumwa', 'USA', 'Iowa', '64353');

INSERT INTO coffeeshop.person (email, enable, encryptedPassword, firstName, lastName, phone, username, address_id) VALUES ('admin@mail.com', true, '$2a$12$uFqAqR91PKlpCWU/Mfj5kektQiyhHicUt..M4e2JbJLczlZvI46BW', 'admin', null, '123456789', 'admin', 1);
INSERT INTO coffeeshop.person (email, enable, encryptedPassword, firstName, lastName, phone, username, address_id) VALUES ('user@mail.com', true, '$2a$12$RguLmBX5yGc6Z4RycD2QMej.9bWAItwC3MhhJQuqzmLPZRBX14sny', 'user', null, '987654321', 'user', 2);

INSERT INTO coffeeshop.person_role (person_id, role_id) VALUES (1, 1);
INSERT INTO coffeeshop.person_role (person_id, role_id) VALUES (2, 2);

INSERT INTO coffeeshop.productcategory (name) VALUES ("Breakfast");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Lunch");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Dinner");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Drink");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Dessert");

INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 2.3, 'Pancakes', 1);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 1.5, 'Crumb Topped Banana', 1);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 3.4, 'Easy Breakfast Casserole', 1);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 4, 'The Bestest Belgian Waffles', 1);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 5.8, 'Spiced Butternut Squash Soup', 2);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 4.8, 'Tomato Bacon Grilled Cheese', 2);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 5.3, 'Philly Cheesteak Sandwich with Garlic Mayo', 2);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 8.1, 'Pork Marsala', 3);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 7.3, 'Pasta Pomodoro', 3);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('', 7.5, 'Fresh Tomato Shrimp Pasta', 3);
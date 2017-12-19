                                                                   
INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
  
INSERT INTO authority (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authority (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authority (id,username, authority) VALUES (3,'admin', 'ROLE_USER');

INSERT INTO coffeeshop.address VALUES ('1', 'Fairfield', 'USA', 'Iowa', '52556');
INSERT INTO coffeeshop.address VALUES ('2', 'Ottumwa', 'USA', 'Iowa', '64353');

INSERT INTO coffeeshop.person (email, firstName, lastName, phone, address_id, member_id) VALUES ('admin@mail.com', 'admin', null, '123456789', 1, 'admin');
INSERT INTO coffeeshop.person (email, firstName, lastName, phone, address_id, member_id) VALUES ('user@mail.com', 'user', null, '987654321', 2, 'guest');

INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 2.3, 'Pancakes', 'BREAKFAST');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 1.5, 'Crumb Topped Banana', 'BREAKFAST');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 3.4, 'Easy Breakfast Casserole', 'BREAKFAST');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 4, 'The Bestest Belgian Waffles', 'BREAKFAST');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 5.8, 'Spiced Butternut Squash Soup', 'LUNCH');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 4.8, 'Tomato Bacon Grilled Cheese', 'LUNCH');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 5.3, 'Philly Cheesteak Sandwich with Garlic Mayo', 'LUNCH');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 8.1, 'Pork Marsala', 'DINNER');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 7.3, 'Pasta Pomodoro', 'DINNER');
INSERT INTO coffeeshop.product (description, price, productName, productType) VALUES ('', 7.5, 'Fresh Tomato Shrimp Pasta', 'DINNER');
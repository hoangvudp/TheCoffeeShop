
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);                                                                   
INSERT INTO credentials(username,password,enabled) VALUES ('pham.dong','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('samson.weldigebriel','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('vinh.hoang','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
  
INSERT INTO authority (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authority (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authority (id,username, authority) VALUES (3,'admin', 'ROLE_USER');

INSERT INTO coffeeshop.address VALUES ('1', 'Fairfield', 'USA', 'Iowa', '52556');
INSERT INTO coffeeshop.address VALUES ('2', 'Ottumwa', 'USA', 'Iowa', '64353');
INSERT INTO coffeeshop.address VALUES ('3', 'Burlington', 'USA', 'Iowa', '64353');
INSERT INTO coffeeshop.address VALUES ('4', 'Mount Pleasant', 'USA', 'Iowa', '64353');



INSERT INTO `orders` VALUES ('1', '2017-12-20', '1');


INSERT INTO coffeeshop.member (email, firstName, lastName, phone, address_id, member_id) VALUES ('admin@mail.com', 'John', 'Doe', '987654321', 1, 'admin');
INSERT INTO coffeeshop.member (email, firstName, lastName, phone, address_id, member_id) VALUES ('pham.dong@mail.com', 'Pham', 'Dong', '123456789', 2, 'pham.dong');
INSERT INTO coffeeshop.member (email, firstName, lastName, phone, address_id, member_id) VALUES ('samson.weldigebriel@mail.com', 'Samson', 'Weldigebriel', '222222222', 3, 'samson.weldigebriel');
INSERT INTO coffeeshop.member (email, firstName, lastName, phone, address_id, member_id) VALUES ('vinh.hoang@mail.com', 'Vinh', 'Hoang', '333333333', 4, 'vinh.hoang');

INSERT INTO coffeeshop.productcategory (name) VALUES ("Breakfast");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Lunch");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Dinner");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Drink");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Soup");
INSERT INTO coffeeshop.productcategory (name) VALUES ("Salad");

INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('While your go-to pancake recipe might star buttermilk, Ina whisks sour cream into her banana-spiked batter to add contrasting tang without watering it down.', 2.3, 'Banana Sour Cream Pancakes', 1);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('For an elegant breakfast in a flash, Rachael folds smoked salmon into her 6-minute scrambled eggs. Crisp, fresh chives add bright color and a subtle onion flavor.', 1.5, 'Rachael Scrambled Eggs', 1);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('It does not have to be summer to make these gorgeous Summer Rolls, made by shaving colorful, nutrient-packed beets, carrots, peppers and cucumbers and wrapping them up inside translucent rice papers.', 4, 'Colorful Summer Rolls', 2);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('Turn leftover steak into a bright and healthy, low-carb lunch with this sweet potato toast topped with sweet red peppers and spicy arugula.', 5.8, 'Sweet Potato Toast with Steak', 2);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('Antioxidant-rich kale is even better for you when eaten raw. Thin strips are softened in a light lemon dressing, then tossed with the savory-sweet blend of apple, dates, almonds and cheese.', 4.8, 'Kale and Apple Salad', 6);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('This is not your everyday salad. Mix shrimp, radishes and snow peas with crunchy sesame seeds and a rice vinaigrette.', 5.3, 'Shrimp and Snow Pea Salad', 6);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('Tyler Florence allows the beef to rest on a carving board for 20 minutes to let the juices settle. The internal temperature of the meat will continue to rise about 10 degrees to achieve perfectly cooked results.', 8.1, 'Standing Rib Roast', 3);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('A simple homemade tomato sauce (that can be prepared in advance) coats mini turkey meatballs that are perfect for serving with toothpicks.', 7.3, 'Mini Turkey Meatballs', 3);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('Put chicken to good use by shredding the leftovers and stirring into a flavorful broth. Prepare your favorite pasta — orzo works nicely — and add to the soup right before serving.', 5.3, 'Chicken and Pasta Soup', 5);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('Add ditalini, the tiny tube-shaped pasta, to a chunky broth made using chopped whole tomatoes, white beans and chicken stock. You will be amazed by how many of the ingredients are already stocked in your pantry.', 8.1, 'Pasta e Fagioli', 5);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('Sandra mimics the flavors of a candy cane in a cocktail by using equal parts vanilla rum, white chocolate liqueur and peppermint schnapps.', 7.3, 'Candy Cane Cocktail', 4);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('Ginger, cinnamon and allspice bring a gingerbread flavor to this hot chocolate. Intense Dutch-process cocoa powder balances the spices, and chopped milk chocolate is mixed in at the end for a creamy, rich texture.', 7.5, 'Gingerbread Hot Chocolate', 4);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('These gooey pastries rival Grandma (or a certain airport cinnamon-roll tycoon) any day. The comforting aroma of spicy cinnamon and nutmeg sprinkled between layers.', 3.4, 'Almost-Famous Cinnamon Buns', 1);
INSERT INTO coffeeshop.product (description, price, productName, category_id) VALUES ('After you are done devouring this light and crispy fried shrimp (with blue cheese and hot sauce dips!), bookmark this recipe permanently', 7.5, 'Buffalo Shrimp Tempura', 3);

INSERT INTO `orders` VALUES ('2', '2017-12-20', '1');
INSERT INTO `orders` VALUES ('3', '2017-12-20', '1');
INSERT INTO `orders` VALUES ('4', '2017-12-20', '1');

INSERT INTO `orderline` VALUES ('1', '3', '1', '1');
INSERT INTO `orderline` VALUES ('2', '3', '2', '1');
INSERT INTO `orderline` VALUES ('3', '7', '3', '2');
INSERT INTO `orderline` VALUES ('4', '2', '4', '6');
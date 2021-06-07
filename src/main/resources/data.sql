insert into item(item_uid, name, description, market,stock, price_tag, state) values (1, 'Pão', 'Integral e delicioso', 'PT',20,3.0,'AVAILABLE');
insert into item(item_uid, name, description, market,stock, price_tag, state) values (2, 'Leite', 'Sem lactose', 'PT',20,1.0,'AVAILABLE');
insert into item(item_uid, name, description, market,stock, price_tag, state) values (3, 'Queijo', 'Light', 'PT',20,5.0,'AVAILABLE');
insert into item(item_uid, name, description, market,stock, price_tag, state) values (4, 'Banana', 'Uma duzia', 'PT',20,1.2,'AVAILABLE');
insert into item(item_uid, name, description, market,stock, price_tag, state) values (5, 'Água', 'Pedras', 'PT',20,0.5,'AVAILABLE');
insert into item(item_uid, name, description, market,stock, price_tag, state) values (6, 'Cerveja', 'Sem alcool', 'PT',20,2.5,'AVAILABLE');


insert into user(user_uid, name, email, password, credit) values (1, 'John Smith', 'johnsmith12@amail.com', '$2y$12$.jIRi83bEpvtj5.Q2JgoTOJ/HyVTh1eeJt5A0KbxenlBxcRJCTeOy', 250.0);
insert into user(user_uid, name, email, password, credit) values (2, 'Ana Duarte', 'anaduarteba@amail.com', '$2y$12$0zPjL0Q4dgGo9QP3hXeROeTvhKjL.wtWW4AFIMt6ZY2BMI9mbM.Bm', 800.50);
insert into user(user_uid, name, email, password, credit) values (3, 'Eli Magrath', 'eli20new@amail.com', '$2y$12$8VgR/kqv7rz2XywYZJrPV.VxqvBFH86ztYqYOK93linc4fbWsnygS', 376.82);

-- insert into transaction(transaction_uid, item_uid, user_uid, quantity, total) values (1, 2, 2, 2, 10);

-- password: smithjohn
-- password: anaduarte
-- password: elimagrath
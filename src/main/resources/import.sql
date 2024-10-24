INSERT INTO master (description, created_at, updated_at, status) VALUES ('Document Type Person', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('DNI', null, true, 1)
INSERT INTO master_details (description, value, status, master_id) VALUES ('RUC', null, true, 1)
INSERT INTO master (description, created_at, updated_at, status) VALUES ('Currency', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('Soles', 'S/.', true, 2)
INSERT INTO master_details (description, value, status, master_id) VALUES ('Dolares', '$', true, 2)
INSERT INTO master (description, created_at, updated_at, status) VALUES ('Type Suppliers', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('General', null, true, 3)
INSERT INTO master (description, created_at, updated_at, status) VALUES ('Gender', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('Male', null, true, 4)
INSERT INTO master_details (description, value, status, master_id) VALUES ('Female', null, true, 4)
INSERT INTO master (description, created_at, updated_at, status) VALUES ('Unit of Measure', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('Unidad', null, true, 5)
INSERT INTO master (description, created_at, updated_at, status) VALUES ('Category', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('High end', null, true, 6)
INSERT INTO master (description, created_at, updated_at, status) VALUES ('Model', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('iPhone 15 Pro Max', null, true, 7)
INSERT INTO master (description, created_at, updated_at, status) VALUES ('Brand', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO master_details (description, value, status, master_id) VALUES ('Apple', null, true, 8)

INSERT INTO stores (currency_id, name, address, phone, logo, created_at, updated_at, status) VALUES (3, 'Sercoplus', 'Av. Garcilaso de la Vega 1248–1250', '959283589', null, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)

INSERT INTO roles (description, created_at, updated_at, status) VALUES ('ADMINISTRATOR', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true);
INSERT INTO roles (description, created_at, updated_at, status) VALUES ('EMPLOYEE', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true);

INSERT INTO users (role_id, username, password) VALUES (1, 'alexis@gmail.com', 'clave123');
INSERT INTO employees (type_person_id, identity_number, user_id, first_name, last_name, address, phone, created_at, updated_at, status) VALUES (1, '73070360', 1, 'Xavier Alexis', 'Arias Huapaya', null, null, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true);

INSERT INTO suppliers (type_supplier_id, companie_name, identity_number, address, phone, web, created_at, updated_at, status) VALUES (5, 'FERMIN LENT CENTER E.I.R.L.', '20607981923', 'JR. JR. MARTINEZ DE COMPAGÑON NRO. 318 OTR. TARAPO', '', '', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)

INSERT INTO clients (type_person_id, identity_number, gender_id, first_name, last_name, birth_or_anniversary, address, email, occupation, observation, created_at, updated_at, status) VALUES (1, '15415724', 6, 'Rosa Elva', 'Huapaya Manco', null, null, 'rosa-huapaya@hotmail.com', null, null, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)


INSERT INTO documents (name, abbreviation, created_at, updated_at, status) VALUES ('TICKET', 'TC', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO documents_correlatives (store_id, serie, issued, report_name, created_at, updated_at, status) VALUES (1, 'TC001', 0, null, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)

INSERT INTO products (unit_of_measure_id, category_id, model_id, brand_id, name, description, unit_price, purchase_price, minimum_stock, image, created_at, updated_at, status) VALUES (8, 9, 10, 11, 'iPhone 15 Pro Max', null, 500.00 , 250.00, 5, null, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
INSERT INTO products_stores (store_id, stock, sale_price, purchase_price, created_at, updated_at, status) VALUES (1, 50, 500.00, 250.00, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)

INSERT INTO bank_boxes (store_id, name, created_at, updated_at, status) VALUES(1, 'Box dolares', '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)

INSERT INTO type_operations (name, income, created_at, updated_at, status) VALUES ('Income from sales', true, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)

INSERT INTO petty_cash (bank_box_id, opening_observation, closing_observation, opening_date, closing_date, opening_amount, cash_closing, other_closing, open_petty_cash, exchange_rate, created_at, updated_at, status) VALUES (1, 'Open', null, '2024-09-25', null, 100.00, 0.00, 0.00, true, 3.75, '2024-09-23 22:21:24.229', '2024-09-23 22:21:24.229', true)
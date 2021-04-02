use sc_crm;

CREATE TABLE client_employees (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL
                  );

CREATE TABLE service_requests (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    vehicle_number VARCHAR(50) NOT NULL,
    date_of_create DATE NOT NULL,
    request_type VARCHAR(50) NOT NULL,
    problem VARCHAR(255) NOT NULL,
    client_employee_id BIGINT NOT NULL,
    FOREIGN KEY (client_employee_id) REFERENCES client_employees(id)
                  );

CREATE TABLE equipment_orders (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    equipment_type VARCHAR(50) NOT NULL,
    equipment_name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    service_request_id BIGINT NOT NULL,
    FOREIGN KEY (service_request_id) REFERENCES service_requests(id)
                  );
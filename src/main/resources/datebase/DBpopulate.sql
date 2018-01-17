INSERT INTO post (post, hourly_rate) VALUE ('java developer', '100.00');
INSERT INTO post (post, hourly_rate) VALUE ('php developer', '110.00');
INSERT INTO department (name) VALUE ('administration');
INSERT INTO workers VALUES (unhex(replace(uuid(), '-', '')),'admin','admin',1,1,
                            'pass','email@email.com','ADMIN','work');
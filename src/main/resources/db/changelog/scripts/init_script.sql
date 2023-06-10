CREATE TABLE personal_cabinet
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    email        VARCHAR(255)          NULL,
    password     VARCHAR(255)          NULL,
    unp          VARCHAR(255)          NULL,
    address      VARCHAR(255)          NULL,
    phone_number VARCHAR(255)          NULL,
    bik          VARCHAR(255)          NULL,
    balance      DOUBLE                NULL,
    is_login     BIT(1)                NULL,
    CONSTRAINT pk_personalcabinet PRIMARY KEY (id)
);

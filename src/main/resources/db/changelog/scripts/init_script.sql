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

CREATE TABLE ad_account
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    service_type INT                   NULL,
    name         VARCHAR(255)          NULL,
    theme        VARCHAR(255)          NULL,
    site         VARCHAR(255)          NULL,
    balance      DOUBLE                NULL,
    cabinet_id   BIGINT                NULL,
    CONSTRAINT pk_adaccount PRIMARY KEY (id)
);

ALTER TABLE ad_account
    ADD CONSTRAINT FK_ADACCOUNT_ON_CABINET FOREIGN KEY (cabinet_id) REFERENCES personal_cabinet (id);

    CREATE TABLE history
    (
        id         BIGINT AUTO_INCREMENT NOT NULL,
        date       datetime              NULL,
        type       INT                   NULL,
        sum        DOUBLE                NULL,
        cabinet_id BIGINT                NULL,
        account_id BIGINT                NULL,
        CONSTRAINT pk_history PRIMARY KEY (id)
    );

    ALTER TABLE history
        ADD CONSTRAINT FK_HISTORY_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES ad_account (id);

    ALTER TABLE history
        ADD CONSTRAINT FK_HISTORY_ON_CABINET FOREIGN KEY (cabinet_id) REFERENCES personal_cabinet (id);

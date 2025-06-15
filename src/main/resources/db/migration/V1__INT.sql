CREATE TABLE MEMBER(

    email BIGINT AUTO_INCREMENT,
    password VARCHAR(65) NOT NULL UNIQUE,
    name VARCHAR(65) NOT NULL ,
    mobile VARCHAR(15) NOT NULL,
    authority ENUM('MEMBER' , 'ADMIN') DEFAULT 'MEMBER',
    termsAgree TINYINT(11) DEFAULT 0,
    locked TINYINT(1) DEFAULT 0,
    expired DATETIME,
    credentialChangedAt DEFAULT CURRENT_TIMESTAMP,
    modifiedAt DATETIME,
    deleteAt DATETIME,
    PRIMARY KEY(email)
)
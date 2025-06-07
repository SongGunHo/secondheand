CREATE TABLE TREND (
    seq BIGINT AUTO_INCREMENT,
    cateagory VARCHAR(40),
    wordCloud VARCHAR(60),
    keywords TEXT NOT NULL,
    createdAt DATEIME DEFAULT CURRENT_TIMESTAMP,
    modifedAt DATEIME,
    deleteAt DATEIME
    PRIMARY KEY(seq)
)
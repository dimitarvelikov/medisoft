CREATE TABLE ADDRESS
(
    ID          SERIAL PRIMARY KEY,
    CITY        VARCHAR(30),
    COUNTRY     VARCHAR(30),
    COUNTY      VARCHAR(30),
    LINE        VARCHAR(30),
    POSTAL_CODE VARCHAR(30)
);

CREATE TABLE CONTACT_PERSON
(
    ID           SERIAL PRIMARY KEY,
    RELATIONSHIP VARCHAR(50),
    F_NAME       VARCHAR(25),
    M_NAME       VARCHAR(30),
    L_NAME       VARCHAR(30),
    EMAIL        VARCHAR(40),
    GENDER       CHAR(1),
    NATIONALITY  VARCHAR(30),
    PHONE        VARCHAR(30),
    ADDRESS_ID   INT,

    FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID)
);

CREATE TABLE PATIENT
(
    ID                   SERIAL PRIMARY KEY,
    EGN                  VARCHAR(20),
    F_NAME               VARCHAR(30),
    M_NAME               VARCHAR(30),
    L_NAME               VARCHAR(30),
    BIRTHDATE            DATE,
    EMAIL                VARCHAR(40),
    GENDER               CHAR(1),
    NATIONALITY          VARCHAR(30),
    PHONE                VARCHAR(30),
    ACTIVE               BOOLEAN,
    SOCIAL_GROUP         VARCHAR(30),
    MARITAL_STATUS       VARCHAR(30),
    ADDRESS_ID           INT,
    CONTACT_PERSON_ID    INT,
    GENERAL_PRACTITIONER VARCHAR(40),

    FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID),
    FOREIGN KEY (CONTACT_PERSON_ID) REFERENCES CONTACT_PERSON (ID)
);

CREATE TABLE USERS
(
    ID       SERIAL PRIMARY KEY,
    USERNAME VARCHAR(30)  NOT NULL,
    PASSWORD VARCHAR(100) NOT NULL,
    F_NAME   VARCHAR(30)  NOT NULL,
    L_NAME   VARCHAR(30)  NOT NULL
);

CREATE TABLE USER_ROLE
(
    USER_ID INT         NOT NULL,
    NAME    VARCHAR(30) NOT NULL,

    PRIMARY KEY (USER_ID, NAME),
    FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);

CREATE TABLE MEDICAL_CASE
(
    ID         SERIAL PRIMARY KEY,
    USER_ID    INT         NOT NULL,
    TYPE       VARCHAR(30) NOT NULL,
    STATUS     VARCHAR(30) NOT NULL,
    CREATED_AT TIMESTAMP   NOT NULL,

    FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);

CREATE TABLE LAB_TEST_REGISTRY
(
    ID        SERIAL PRIMARY KEY,
    NAME      VARCHAR(100) NOT NULL,
    UNIT      VARCHAR(50)  NOT NULL,
    TEST_TYPE VARCHAR(50)  NOT NULL
);

CREATE TABLE MEDICAL_CASE_NOTE
(
    ID              SERIAL PRIMARY KEY,
    NOTE            TEXT NOT NULL,
    USER_ID         INT  NOT NULL,
    MEDICAL_CASE_ID INT  NOT NULL,

    FOREIGN KEY (USER_ID) REFERENCES USERS (ID),
    FOREIGN KEY (MEDICAL_CASE_ID) REFERENCES MEDICAL_CASE (ID)
);

CREATE TABLE USER_NOTE
(
    ID      SERIAL PRIMARY KEY,
    NOTE    TEXT NOT NULL,
    USER_ID INT  NOT NULL,

    FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);

-- todo May have to add patient_id
CREATE TABLE ALERT
(
    ID         SERIAL PRIMARY KEY,
    TEXT       VARCHAR(200) NOT NULL,
    SEVERITY   VARCHAR(30)  NOT NULL,
    ACTIVE     BIT          NOT NULL,
    CREATED_AT TIMESTAMP    NOT NULL
);

CREATE TABLE HOSPITAL
(
    ID   SERIAL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL
);

CREATE TABLE HOSPITAL_DEPARTMENT
(
    ID       SERIAL PRIMARY KEY,
    NAME     VARCHAR(100) NOT NULL,
    CAPACITY INT          NOT NULL
);
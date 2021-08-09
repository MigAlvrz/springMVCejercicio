CREATE TABLE TUSERS(
id BIGINT IDENTITY PRIMARY KEY,
email VARCHAR(50),
login VARCHAR(50),
password varchar(50),
isAdmin BOOLEAN,
status VARCHAR(50)
);


CREATE TABLE tcategories(
id BIGINT IDENTITY PRIMARY KEY,
name VARCHAR(255),
user_id INT,
FOREIGN KEY(user_id) REFERENCES tusers(id) ON DELETE SET NULL
);

CREATE TABLE ttasks(
id BIGINT IDENTITY PRIMARY KEY,
title VARCHAR(50),
comments VARCHAR(255),
category_id BIGINT,
user_id BIGINT,
created DATE,
finished DATE,
planned DATE,
FOREIGN KEY(category_id) REFERENCES tcategories(id) ON DELETE SET NULL,
FOREIGN KEY(user_id) REFERENCES tusers(id) ON DELETE SET NULL
);


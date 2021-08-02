
CREATE TABLE IF NOT EXISTS tusers(
id BIGINT IDENTITY ,
email VARCHAR(255),
isadmin BOOLEAN,
login VARCHAR(255),
password VARCHAR(255),
status VARCHAR(255),
PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS tcategories(
id BIGINT IDENTITY ,
name VARCHAR(255),
user_id INT,
FOREIGN KEY(user_id) REFERENCES tusers(id) ON DELETE SET NULL,
PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS ttasks(
id BIGINT IDENTITY ,
comments VARCHAR(255),
created DATE,
finished DATE,
planned DATE,
title VARCHAR(255),
category_id INT,
FOREIGN KEY(category_id) REFERENCES tcategories(id) ON DELETE SET NULL,
user_id INT,
FOREIGN KEY(user_id) REFERENCES tusers(id) ON DELETE SET NULL,
PRIMARY KEY (id)
);

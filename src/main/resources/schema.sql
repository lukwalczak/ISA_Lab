CREATE TABLE character (
                           id VARCHAR(255) PRIMARY KEY,
                           name VARCHAR(100),
                           level INT,
                           profession_id VARCHAR(255)
);

CREATE TABLE profession (
                            id VARCHAR(255) PRIMARY KEY,
                            name VARCHAR(100),
                            base_armor INT
);

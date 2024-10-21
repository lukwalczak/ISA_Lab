CREATE TABLE professions (
                             id UUID PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             baseArmor INT NOT NULL
);

CREATE TABLE characters (
                            id UUID PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            level INT NOT NULL,
                            profession_id UUID,
                            FOREIGN KEY (profession_id) REFERENCES professions(id)
);

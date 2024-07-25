CREATE TABLE IF NOT EXISTS Run(
    id INT NOT NULL,
    title varchar(250) NOT NULL,
    started_on TIMESTAMP NOT NULL,
    completed_on TIMESTAMP NOT NULL,
    miles Int NOT NULL,
    location varchar(10) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE Client(
    clientId IDENTITY PRIMARY KEY,
    firstName VARCHAR,
    lastName VARCHAR
);

CREATE TABLE Client_Task(
    taskId IDENTITY PRIMARY KEY,
    taskDescription VARCHAR,
    clientId INT,
    FOREIGN KEY (userId) REFERENCES Client(clientId);
);
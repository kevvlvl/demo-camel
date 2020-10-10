CREATE TABLE Client (
    clientId IDENTITY NOT NULL PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL
);

CREATE TABLE Client_Task (
    taskId IDENTITY NOT NULL PRIMARY KEY,
    taskDescription VARCHAR(255) NOT NULL,
    clientId INT,
    CONSTRAINT FK_ClientId FOREIGN KEY (clientId) REFERENCES Client(clientId)
);
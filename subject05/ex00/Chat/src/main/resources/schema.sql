CREATE TABLE User (
    ID int NOT NULL PRIMARY KEY,
    Login varchar(255) UNIQUE NOT NULL,
    Password varchar(255) NOT NULL,
    Created_rooms Chatroom[]
);

CREATE TABLE Chatroom (
    ID int NOT NULL PRIMARY KEY,
    Name varchar(255) UNIQUE NOT NULL,

)
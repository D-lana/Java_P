create schema if not exists chat;

CREATE TABLE IF NOT EXISTS chat.users (
    userId SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS chat.chatroom (
    chatroomId SERIAL PRIMARY KEY,
    chatroomName VARCHAR(50) NOT NULL UNIQUE,
    chatroomOwner INT REFERENCES chat.users(userId)
    );

CREATE TABLE IF NOT EXISTS chat.message (
    messageId SERIAL PRIMARY KEY,
    messageAuthor INT REFERENCES chat.users(userId),
    messageRoom INT REFERENCES chat.chatroom(chatroomId),
    messageText TEXT NOT NULL,
    messageDateTime timestamp
    );

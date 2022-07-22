
INSERT INTO chat.users (userid, login, password) VALUES (1, 'Sova', '12345');
INSERT INTO chat.users (userid, login, password) VALUES (2, 'Krolik', '54321');
INSERT INTO chat.users (userid, login, password) VALUES (3, 'Pooh', '88888');
INSERT INTO chat.users (userid, login, password) VALUES (4, 'Tigrynia', 'tiger55');
INSERT INTO chat.users (userid, login, password) VALUES (5, 'Piglet', 'pig77');

INSERT INTO chat.chatroom (chatroomid, chatroomName, chatroomOwner) VALUES (1, 'Y sovy', 1);
INSERT INTO chat.chatroom (chatroomid, chatroomName, chatroomOwner) VALUES (2, 'Nora', 2);
INSERT INTO chat.chatroom (chatroomid, chatroomName, chatroomOwner) VALUES (3, 'All about Honey', 3);
INSERT INTO chat.chatroom (chatroomid, chatroomName, chatroomOwner) VALUES (4, 'Top Secret', 3);
INSERT INTO chat.chatroom (chatroomid, chatroomName, chatroomOwner) VALUES (5, 'Piglet joke', 5);

INSERT INTO chat.message (messageid, messageAuthor, messageRoom, messageText, messageDateTime) VALUES (1, 3, 3, 'Hello everybody!', to_timestamp('2022     May','YYYY MON'));
INSERT INTO chat.message (messageid, messageAuthor, messageRoom, messageText, messageDateTime) VALUES (2, 3, 3, 'I like honey', to_timestamp('2022     May','YYYY MON'));
INSERT INTO chat.message (messageid, messageAuthor, messageRoom, messageText, messageDateTime) VALUES (3, 3, 3, 'What do you think about honey, piglet?', to_timestamp('2022     May','YYYY MON'));
INSERT INTO chat.message (messageid, messageAuthor, messageRoom, messageText, messageDateTime) VALUES (4, 5, 3, 'Hello, Pooh! I like honey too, it is so sweet!', to_timestamp('2022     May','YYYY MON'));
INSERT INTO chat.message (messageid, messageAuthor, messageRoom, messageText, messageDateTime) VALUES (5, 5, 5, 'Xru Xru Xru', to_timestamp('2022     May','YYYY MON'));







USE adlister_db;


INSERT INTO users (id, username, email, password)
VALUES(1,'pete','pete@gmail.com','password'),
      (2,'patrick','patrick@gmail.com','password1'),
      (3,'andy', 'andy@gmail.com', 'password2'),
      (4,'joe', 'joe@gmail.com', 'password3');



INSERT INTO ads ( user_id, title, description)
VALUES (1,'big kitty','A big old fluffy cat'),
       (2,'small dog','a tiny puppy, chihuahua I think.'),
       (3,'Not sure the breed', 'an animal of some sort.'),
       (3,'Little lion', 'This cat is huge!!!!'),
       (4,'Little fish', 'This fish is huge!!!!'),
       (4,'Little dog', 'This dog is huge!!!!'),
       (1,'Little tiger', 'This tiger is huge!!!!'),
       (2,'Little wolf', 'This wolf is huge!!!!'),
       (3,'bark bark', 'I believe its a dog!!!!');

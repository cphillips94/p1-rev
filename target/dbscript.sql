CREATE DATABASE project0;
//CREATE TABLE
t0=# CREATE TABLE user_accounts(
project0(# account_number SERIAL PRIMARY KEY,
project0(# account_name VARCHAR(30),
project0(# account_password VARCHAR(30),
project0(# balance DOUBLE PRECISION
project0(# );


//insert user_accounts
t0=# INSERT INTO user_accounts(account_name,account_password,balance) VALUES ('chris','test',45.6);
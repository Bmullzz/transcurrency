#Run Docker container
#docker run --name mysqldbv1 -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

#Create database
CREATE DATABASE transcurrencymysql_dev;
CREATE DATABASE transcurrencymysql_prod;

#Create database service accounts(use wildcard, '%' instead of 'localhost' for Docker mysql container
CREATE USER 'transcurrencymysql_dev_user'@'%' IDENTIFIED BY 'yoo';
CREATE USER 'transcurrencymysql_prod_user'@'%' IDENTIFIED BY 'yoo';

#Database grant
GRANT SELECT ON transcurrencymysql_dev.* to 'transcurrencymysql_dev_user'@'%';
GRANT INSERT ON transcurrencymysql_dev.* to 'transcurrencymysql_dev_user'@'%';
GRANT DELETE ON transcurrencymysql_dev.* to 'transcurrencymysql_dev_user'@'%';
GRANT UPDATE ON transcurrencymysql_dev.* to 'transcurrencymysql_dev_user'@'%';
GRANT SELECT ON transcurrencymysql_prod.* to 'transcurrencymysql_prod_user'@'%';
GRANT INSERT ON transcurrencymysql_prod.* to 'transcurrencymysql_prod_user'@'%';
GRANT DELETE ON transcurrencymysql_prod.* to 'transcurrencymysql_prod_user'@'%';
GRANT UPDATE ON transcurrencymysql_prod.* to 'transcurrencymysql_prod_user'@'%';

#SCHEMA
create table bank_account (BANK_ACCOUNT_ID bigint not null auto_increment, ACCOUNT_NUMBER int, routing_number int, bank_name varchar(255), primary key (BANK_ACCOUNT_ID)) engine=InnoDB;
create table credit_card (CREDIT_CARD_ID bigint not null auto_increment, CARD_NAME varchar(255), card_number int, exp_date varchar(255), user_id bigint, cvv int, primary key (CREDIT_CARD_ID)) engine=InnoDB;
create table user (id bigint not null auto_increment, name varchar(255), username varchar(255), balance decimal, primary key (id)) engine=InnoDB;
create table user_bank_account_list (bank_account_list_bank_account_id bigint, user_id bigint not null, BANK_ACCOUNT_ID bigint not null, primary key (user_id, BANK_ACCOUNT_ID)) engine=InnoDB;
create table user_credit_card_list (credit_card_list_credit_card_id bigint, user_id bigint not null, CREDIT_CARD_ID bigint not null, primary key (user_id, CREDIT_CARD_ID)) engine=InnoDB;

#Run Docker container ()
#docker run --name mysqldbv1 -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

##Persistency of data even after container is stoped and rerun
#for mac
#run docker container mysql while connected to a local directory (should be made prior,
#/Users/yoobc/Desktop/projects/dockerdata/mysqldata) for persistency
#docker run -p 27017:27017 -v /Users/yoobc/Desktop/projects/dockerdata/mysqldata:/var/lib/mysql -d mysql

#for window10
#create the volume first in docker folder instead of directory, which does not work in window
#docker volume create --name=mysqldata
#followed by
#docker run -p 3306:3306 -v mysqldata:/var/lib/mysql -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

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
create table bank_account (bank_account_id bigint not null auto_increment, account_number integer not null, bank_name varchar(255), routing_number integer not null, user_id bigint, primary key (bank_account_id)) ENGINE=InnoDB;
create table credit_card (credit_card_id bigint not null auto_increment, card_name varchar(255), card_number integer not null, cvv integer not null, exp_date varchar(255), user_id bigint, primary key (credit_card_id)) ENGINE=InnoDB;
create table user (id bigint not null auto_increment, balance decimal(19,2), name varchar(255), username varchar(255), primary key (id)) ENGINE=InnoDB;
create table user_bank_account_list (user_id bigint not null, bank_account_list_bank_account_id bigint not null, primary key (user_id, bank_account_list_bank_account_id)) ENGINE=InnoDB;
create table user_credit_card_list (user_id bigint not null, credit_card_list_credit_card_id bigint not null, primary key (user_id, credit_card_list_credit_card_id)) ENGINE=InnoDB;
create table transaction (id bigint not null auto_increment, source_user_id bigint, destination_user_id bigint, amount bigint, source_user_account_id bigint, destination_user_account_id bigint, primary key (id)) ENGINE=InnoDB;
alter table user_bank_account_list add constraint UK_soo8ob3oq2fmn2q5e89xpmp96 unique (bank_account_list_bank_account_id);
alter table user_credit_card_list add constraint UK_ret4a5rl9ci94wm2lhqm4omtf unique (credit_card_list_credit_card_id);
alter table bank_account add constraint FK92iik4jwhk7q385jubl2bc2mm foreign key (user_id) references user (id);
alter table credit_card add constraint FKh4wi9724muee2kp2c4ku1yia2 foreign key (user_id) references user (id);
alter table user_bank_account_list add constraint FK1dcbktpe0soh094kx7vrqcxqe foreign key (bank_account_list_bank_account_id) references bank_account (bank_account_id);
alter table user_bank_account_list add constraint FKf37ni4f85kb9ybg50mclh9k7t foreign key (user_id) references user (id);
alter table user_credit_card_list add constraint FK9040d6n6fyjd3asded0ajjlc foreign key (credit_card_list_credit_card_id) references credit_card (credit_card_id);
alter table user_credit_card_list add constraint FKoed41d1womcccstampgpwh1av foreign key (user_id) references user (id);
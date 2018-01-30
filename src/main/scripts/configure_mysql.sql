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
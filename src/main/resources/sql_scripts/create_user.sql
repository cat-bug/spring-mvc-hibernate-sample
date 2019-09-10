CREATE USER 'springzoomanager'@'localhost' IDENTIFIED BY 'springzoomanager';

GRANT ALL PRIVILEGES ON * . * TO 'springzoomanager'@'localhost';
ALTER USER 'springzoomanager'@'localhost' IDENTIFIED WITH mysql_native_password BY 'springzoomanager';
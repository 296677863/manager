CREATE TABLE oauth_access_token
(
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  token_id VARCHAR(255),
  token_expired_seconds INT(11) DEFAULT '-1',
  authentication_id VARCHAR(255),
  username VARCHAR(255),
  client_id VARCHAR(255),
  token_type VARCHAR(255),
  refresh_token_expired_seconds INT(11) DEFAULT '-1',
  refresh_token VARCHAR(255)
);
CREATE UNIQUE INDEX refresh_token ON oauth_access_token (refresh_token);
CREATE UNIQUE INDEX token_id ON oauth_access_token (token_id);
CREATE TABLE oauth_client_details
(
  client_id VARCHAR(255) PRIMARY KEY NOT NULL,
  client_secret VARCHAR(255),
  client_name VARCHAR(255),
  client_uri VARCHAR(255),
  client_icon_uri VARCHAR(255),
  resource_ids VARCHAR(255),
  scope VARCHAR(255),
  grant_types VARCHAR(255),
  redirect_uri VARCHAR(255),
  roles VARCHAR(255),
  access_token_validity INT(11) DEFAULT '-1',
  refresh_token_validity INT(11) DEFAULT '-1',
  description VARCHAR(4096),
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  archived TINYINT(1) DEFAULT '0',
  trusted TINYINT(1) DEFAULT '0'
);
CREATE TABLE oauth_code
(
  create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  code VARCHAR(255),
  username VARCHAR(255),
  client_id VARCHAR(255)
);
CREATE UNIQUE INDEX code ON oauth_code (code);
CREATE TABLE roles
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  guid VARCHAR(255) NOT NULL,
  create_time DATETIME,
  archived TINYINT(1) DEFAULT '0',
  version INT(11) DEFAULT '0',
  role_name VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX guid ON roles (guid);
CREATE TABLE user_roles
(
  users_id INT(11) NOT NULL,
  roles_id INT(11) NOT NULL
);
CREATE INDEX roles_id_index ON user_roles (roles_id);
CREATE INDEX users_id_index ON user_roles (users_id);
CREATE TABLE users
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  guid VARCHAR(255) NOT NULL,
  create_time DATETIME,
  archived TINYINT(1) DEFAULT '0',
  version INT(11) DEFAULT '0',
  password VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  default_user TINYINT(1) DEFAULT '0',
  last_login_time DATETIME
);
CREATE UNIQUE INDEX guid ON users (guid);
CREATE UNIQUE INDEX username ON users (username);
CREATE INDEX username_index ON users (username);
CREATE TABLE roles_permissions
(
  roles_id INT(11) NOT NULL,
  permission_id INT(11) NOT NULL
);
CREATE INDEX permission_id_index ON roles_permissions (permission_id);
CREATE INDEX roles_id_index ON roles_permissions (roles_id);
CREATE TABLE permission
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  guid VARCHAR(255) NOT NULL,
  create_time DATETIME,
  code VARCHAR(255) NOT NULL,
  menuName VARCHAR(255),
  menuUrl VARCHAR(255),
  parentId VARCHAR(255),
  type VARCHAR(1),
  iconUrl VARCHAR(255),
  isUse VARCHAR(1),
  sort INT(11) DEFAULT '0'
);
CREATE UNIQUE INDEX guid ON permission (guid);
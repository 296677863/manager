INSERT INTO `manager-web`.permission (guid, create_time, code, menuName, menuUrl, parentId, type, iconUrl, isUse, sort) VALUES ('1', null, 'system:manager', '系统管理', null, null, 'F', 'fa-home', 'Y', 1);
INSERT INTO `manager-web`.permission (guid, create_time, code, menuName, menuUrl, parentId, type, iconUrl, isUse, sort) VALUES ('2', null, 'user:manager', '用户管理', null, '1', 'F', null, 'Y', 1);
INSERT INTO `manager-web`.permission (guid, create_time, code, menuName, menuUrl, parentId, type, iconUrl, isUse, sort) VALUES ('3', null, 'role:manager', '角色管理', null, '1', 'F', null, 'Y', 2);
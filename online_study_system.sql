# Host: localhost  (Version 5.7.22)
# Date: 2019-10-29 17:46:06
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Data for table "batch"
#


#
# Data for table "course"
#


#
# Data for table "chapter"
#


#
# Data for table "batch_course"
#


#
# Data for table "courseware"
#


#
# Data for table "permission"
#

INSERT INTO `permission` (`per_id`,`per_name`) VALUES (1,'角色管理'),(2,'用户管理'),(3,'批次管理'),(4,'课程管理');

#
# Data for table "role"
#

INSERT INTO `role` (`role_id`,`role_name`) VALUES (1,'管理员'),(2,'普通管理员');

#
# Data for table "role_permission"
#

INSERT INTO `role_permission` (`Id`,`role_id`,`per_id`) VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,2,3),(6,2,4);

#
# Data for table "user"
#

INSERT INTO `user` (`user_id`,`username`,`password`,`role_id`) VALUES (1,'admin','123456',1),(2,'张三','123456',2);

#
# Data for table "batch_user"
#


#
# Data for table "user_course_info"
#


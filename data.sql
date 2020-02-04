create table user
(
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(250),
  surname varchar(250)
);

create table project
(
	id int auto_increment primary key,
	name varchar(250) not null,
	creation_date datetime not null
);

create table task
(
	id int auto_increment,
	name varchar(250) not null,
	due_date datetime,
	responsible_id int,
	project_id int,
	constraint task_pk
		primary key (id),
	constraint TASK_USER_ID_fk
		foreign key (responsible_id) references USER
			on update cascade on delete set null,
	constraint TASK_PROJECT_ID_fk
		foreign key (project_id) references PROJECT
			on update cascade on delete set null
);





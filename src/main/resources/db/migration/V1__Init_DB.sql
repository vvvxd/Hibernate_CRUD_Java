create table developer (id_developer int8 generated by default as identity, firstName varchar(255), id_team int8, lastName varchar(255), primary key (id_developer));
create table skill (id_skill int8 generated by default as identity, id_developer int8, name varchar(255), primary key (id_skill));
create table team (id_team int8 generated by default as identity, name varchar(255), team_status varchar(255), primary key (id_team));

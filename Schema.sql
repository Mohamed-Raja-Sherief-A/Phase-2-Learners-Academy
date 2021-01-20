-- Create Database 
create database if not exists learners;

-- Use Db

use learners;

-- Create subject table --

create table  if not exists  subjects(
sid int not null auto_increment,
subject varchar(255) not null unique, 
primary key(sid)
);

-- Create teachers table--

create table  if not exists  teachers(
tid int not null auto_increment,
teacher varchar(255) not null,
primary key(tid)
);

-- Create Classes table --

create table  if not exists  classes(
cid int not null auto_increment,
class varchar(255) not null unique,
primary key(cid)
);

-- Create Assign table --

create table  if not exists  assign(
cid int,
tid int,
sid int,
primary key(cid,tid,sid),
foreign key(cid) references classes(cid),
foreign key(tid) references teachers(tid),
foreign key(sid) references subjects(sid)
);

-- Create Students table --

create table if not exists students(
id int not null auto_increment,
student varchar(255) not null,
age int not null,
cid int,
primary key(id),
foreign key(cid) references classes(cid)
);

-- Create User table --

create table if not exists users(
username varchar(255) not null,
password varchar(255) not null,
primary key(username)
);
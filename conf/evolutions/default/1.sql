# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table column_name (
  id                        bigserial not null,
  name                      varchar(255),
  constraint pk_column_name primary key (id))
;

create table person (
  id                        serial not null,
  name                      varchar(255),
  constraint pk_person primary key (id))
;




# --- !Downs

drop table if exists column_name cascade;

drop table if exists person cascade;


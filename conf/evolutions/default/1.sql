# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table person (
  id                        serial not null,
  name                      varchar(255),
  max_health                integer,
  current_health            integer,
  max_mana                  integer,
  current_mana              integer,
  physical_attack           integer,
  physical_defence          integer,
  magical_attack            integer,
  magical_defence           integer,
  constraint pk_person primary key (id))
;




# --- !Downs

drop table if exists person cascade;


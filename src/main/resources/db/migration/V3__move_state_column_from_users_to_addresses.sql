alter table addresses
    add state varchar(255) null;

alter table users
drop column state;
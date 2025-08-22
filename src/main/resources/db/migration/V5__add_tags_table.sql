create table tags
(
    id   int not null auto_increment primary key,
    name varchar(255) not null
);

create table user_tags
(
    user_id bigint not null,
    tag_id  int    not null,
    primary key (user_id, tag_id),
    constraint users_user_tags_fk
        foreign key (user_id) references users (id) on delete cascade,
    constraint tags_user_tags_fk
        foreign key (tag_id) references tags (id) on delete cascade
);
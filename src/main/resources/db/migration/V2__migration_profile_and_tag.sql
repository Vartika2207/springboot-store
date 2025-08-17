-- creating profile table
create table profiles
(
    id             bigint auto_increment
        primary key,
    bio            varchar(255) null,
    phone_number   varchar(10),
    date_of_birth  date,
    loyalty_points int unsigned default(0),
    constraint profiles_users_id_fk
        foreign key (id) references users (id)
);



-- creating tags table
create table tags (
                      id bigint auto_increment not null primary key,
                      name varchar(255) not null
);

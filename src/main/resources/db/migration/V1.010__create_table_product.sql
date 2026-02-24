create table products (
    id uuid primary key,
    name varchar(250) not null unique,
    type varchar(50) not null ,
    state varchar(50) not null,
    description varchar(4000),
    created_at timestamp not null,
    updated_at timestamp,
    completed_at timestamp
)
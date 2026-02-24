create table orders (
    id uuid primary key,
    type varchar(50) not null,
    state varchar(50) not null,
    product_id uuid,
    description varchar(4000),
    created_at timestamp not null,
    updated_at timestamp,
    completed_at timestamp,
    constraint fk_orders_product foreign key (product_id) references products(id)
);
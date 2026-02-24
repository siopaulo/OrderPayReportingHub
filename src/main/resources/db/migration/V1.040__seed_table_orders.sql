insert into orders (
    id,
    type,
    state,
    product_id,
    description,
    created_at,
    updated_at,
    completed_at
) values (
    gen_random_uuid(),
    'STANDARD',
    'CREATED',
    null,
    'Test order for product import',
    now(),
    null,
    null
);
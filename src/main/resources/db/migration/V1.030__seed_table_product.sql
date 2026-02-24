insert into products (
    id,
    name,
    type,
    state,
    description,
    created_at,
    updated_at,
    completed_at
) values (
    gen_random_uuid(),
    'Premium product',
    'PREMIUM',
    'Enabled',
    'Test product',
    now(),
    null,
    null
)
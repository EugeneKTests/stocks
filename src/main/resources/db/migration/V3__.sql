create table stocks.position
(
    id         uuid primary key,
    company_id uuid references stocks.company,
    quantity   integer
)
drop table if exists customer cascade;
create table customer
(
    customer_id uuid primary key,
    email       varchar(50)  not null,
    name        varchar(20)  not null,
    banned      boolean      not null,
    created_at  timestamp(9) not null
);

drop table if exists voucher cascade;
create table voucher
(
    voucher_id   uuid primary key,
    customer_id  uuid,
    voucher_type varchar(20)  not null,
    amount       bigint       not null,
    created_at   timestamp(9) not null,
    foreign key (customer_id) references customer (customer_id)
);

create table users (
user_id serial primary key,
first_name varchar(30) not null,
last_name varchar(30) not null,
balance INTEGER check (length(balance)>=0),
user_name varchar(30) unique check (length(user_name)>5),
user_pass varchar(30) check(length(user_pass)>5) ),
status varchar(10) not null
);


create table transactions(
trans_id serial primary key,
amount numeric(30) not null,
user_id INTEGER references users(user_id) on delete cascade
);

create or replace function deposit(deposit bank.users.balance%type, user_id_input bank.users.user_id%type)
returns void
language plpgsql
as $$
begin 
	update bank.users 
	set balance = balance + deposit
	where user_id = user_id_input;
end
$$

create or replace function withdraw(withdraw bank.users.balance%type, user_id_input bank.users.user_id%type)
returns void
language plpgsql
as $$
begin 
	update bank.users 
	set balance = balance - withdraw
	where user_id = user_id_input;
end
$$
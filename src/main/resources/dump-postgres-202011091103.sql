PGDMP     6            	    
    x            postgres    10.14    10.14     *           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            +           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ,           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    16426    bank    SCHEMA        CREATE SCHEMA bank;
    DROP SCHEMA bank;
             postgres    false            �            1255    16643    deposit(integer, integer)    FUNCTION     �   CREATE FUNCTION bank.deposit(deposit integer, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance + deposit
	where user_id = user_id_input;
end
$$;
 D   DROP FUNCTION bank.deposit(deposit integer, user_id_input integer);
       bank       postgres    false    5            �            1255    16638    deposit(numeric, integer)    FUNCTION     �   CREATE FUNCTION bank.deposit(deposit numeric, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance + deposit
	where user_id = user_id_input;
end
$$;
 D   DROP FUNCTION bank.deposit(deposit numeric, user_id_input integer);
       bank       postgres    false    5            �            1255    16644    withdraw(integer, integer)    FUNCTION     �   CREATE FUNCTION bank.withdraw(withdraw integer, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance - withdraw
	where user_id = user_id_input;
end
$$;
 F   DROP FUNCTION bank.withdraw(withdraw integer, user_id_input integer);
       bank       postgres    false    5            �            1255    16641    withdraw(numeric, integer)    FUNCTION     �   CREATE FUNCTION bank.withdraw(withdraw numeric, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance - withdraw
	where user_id = user_id_input;
end
$$;
 F   DROP FUNCTION bank.withdraw(withdraw numeric, user_id_input integer);
       bank       postgres    false    5            �            1259    16621    transactions    TABLE     t   CREATE TABLE bank.transactions (
    trans_id integer NOT NULL,
    amount numeric NOT NULL,
    user_id integer
);
    DROP TABLE bank.transactions;
       bank         postgres    false    5            �            1259    16619    transactions_trans_id_seq    SEQUENCE     �   CREATE SEQUENCE bank.transactions_trans_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE bank.transactions_trans_id_seq;
       bank       postgres    false    214    5            -           0    0    transactions_trans_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE bank.transactions_trans_id_seq OWNED BY bank.transactions.trans_id;
            bank       postgres    false    213            �            1259    16548    users    TABLE     �  CREATE TABLE bank.users (
    user_id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    balance numeric,
    user_name character varying(30),
    user_pass character varying(30),
    CONSTRAINT users_balance_check CHECK ((balance >= (0)::numeric)),
    CONSTRAINT users_user_name_check CHECK ((length((user_name)::text) > 5)),
    CONSTRAINT users_user_pass_check CHECK ((length((user_pass)::text) > 5))
);
    DROP TABLE bank.users;
       bank         postgres    false    5            �            1259    16546    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE bank.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE bank.users_user_id_seq;
       bank       postgres    false    212    5            .           0    0    users_user_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE bank.users_user_id_seq OWNED BY bank.users.user_id;
            bank       postgres    false    211            �
           2604    16624    transactions trans_id    DEFAULT     z   ALTER TABLE ONLY bank.transactions ALTER COLUMN trans_id SET DEFAULT nextval('bank.transactions_trans_id_seq'::regclass);
 B   ALTER TABLE bank.transactions ALTER COLUMN trans_id DROP DEFAULT;
       bank       postgres    false    214    213    214            �
           2604    16551    users user_id    DEFAULT     j   ALTER TABLE ONLY bank.users ALTER COLUMN user_id SET DEFAULT nextval('bank.users_user_id_seq'::regclass);
 :   ALTER TABLE bank.users ALTER COLUMN user_id DROP DEFAULT;
       bank       postgres    false    212    211    212            '          0    16621    transactions 
   TABLE DATA               ?   COPY bank.transactions (trans_id, amount, user_id) FROM stdin;
    bank       postgres    false    214            %          0    16548    users 
   TABLE DATA               \   COPY bank.users (user_id, first_name, last_name, balance, user_name, user_pass) FROM stdin;
    bank       postgres    false    212            /           0    0    transactions_trans_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('bank.transactions_trans_id_seq', 50, true);
            bank       postgres    false    213            0           0    0    users_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('bank.users_user_id_seq', 28, true);
            bank       postgres    false    211            �
           2606    16626    transactions transactions_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY bank.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (trans_id);
 F   ALTER TABLE ONLY bank.transactions DROP CONSTRAINT transactions_pkey;
       bank         postgres    false    214            �
           2606    16556    users users_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY bank.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 8   ALTER TABLE ONLY bank.users DROP CONSTRAINT users_pkey;
       bank         postgres    false    212            �
           2606    16646    users users_user_name_key 
   CONSTRAINT     W   ALTER TABLE ONLY bank.users
    ADD CONSTRAINT users_user_name_key UNIQUE (user_name);
 A   ALTER TABLE ONLY bank.users DROP CONSTRAINT users_user_name_key;
       bank         postgres    false    212            �
           2606    16627 &   transactions transactions_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bank.transactions
    ADD CONSTRAINT transactions_user_id_fkey FOREIGN KEY (user_id) REFERENCES bank.users(user_id) ON DELETE CASCADE;
 N   ALTER TABLE ONLY bank.transactions DROP CONSTRAINT transactions_user_id_fkey;
       bank       postgres    false    2725    214    212            '   `   x�M��1�7�b�۽��:�C9)�+��	\ͥ���M|]2��dxc_�'�_$m��iV(�}��Z�
lGv�ȸ��4����g���MF      %   a   x�}�;�0�99L�$(wa��L|�r�D*$<?�,P��`���5��=/d��X�v���z���Ӿ���Rk�I�W�k�y��A��3�C@��>l          *           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            +           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ,           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                        2615    16426    bank    SCHEMA        CREATE SCHEMA bank;
    DROP SCHEMA bank;
             postgres    false            �            1255    16643    deposit(integer, integer)    FUNCTION     �   CREATE FUNCTION bank.deposit(deposit integer, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance + deposit
	where user_id = user_id_input;
end
$$;
 D   DROP FUNCTION bank.deposit(deposit integer, user_id_input integer);
       bank       postgres    false    5            �            1255    16638    deposit(numeric, integer)    FUNCTION     �   CREATE FUNCTION bank.deposit(deposit numeric, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance + deposit
	where user_id = user_id_input;
end
$$;
 D   DROP FUNCTION bank.deposit(deposit numeric, user_id_input integer);
       bank       postgres    false    5            �            1255    16644    withdraw(integer, integer)    FUNCTION     �   CREATE FUNCTION bank.withdraw(withdraw integer, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance - withdraw
	where user_id = user_id_input;
end
$$;
 F   DROP FUNCTION bank.withdraw(withdraw integer, user_id_input integer);
       bank       postgres    false    5            �            1255    16641    withdraw(numeric, integer)    FUNCTION     �   CREATE FUNCTION bank.withdraw(withdraw numeric, user_id_input integer) RETURNS void
    LANGUAGE plpgsql
    AS $$
begin 
	update bank.users 
	set balance = balance - withdraw
	where user_id = user_id_input;
end
$$;
 F   DROP FUNCTION bank.withdraw(withdraw numeric, user_id_input integer);
       bank       postgres    false    5            �            1259    16621    transactions    TABLE     t   CREATE TABLE bank.transactions (
    trans_id integer NOT NULL,
    amount numeric NOT NULL,
    user_id integer
);
    DROP TABLE bank.transactions;
       bank         postgres    false    5            �            1259    16619    transactions_trans_id_seq    SEQUENCE     �   CREATE SEQUENCE bank.transactions_trans_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE bank.transactions_trans_id_seq;
       bank       postgres    false    214    5            -           0    0    transactions_trans_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE bank.transactions_trans_id_seq OWNED BY bank.transactions.trans_id;
            bank       postgres    false    213            �            1259    16548    users    TABLE     �  CREATE TABLE bank.users (
    user_id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    balance numeric,
    user_name character varying(30),
    user_pass character varying(30),
    CONSTRAINT users_balance_check CHECK ((balance >= (0)::numeric)),
    CONSTRAINT users_user_name_check CHECK ((length((user_name)::text) > 5)),
    CONSTRAINT users_user_pass_check CHECK ((length((user_pass)::text) > 5))
);
    DROP TABLE bank.users;
       bank         postgres    false    5            �            1259    16546    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE bank.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE bank.users_user_id_seq;
       bank       postgres    false    212    5            .           0    0    users_user_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE bank.users_user_id_seq OWNED BY bank.users.user_id;
            bank       postgres    false    211            �
           2604    16624    transactions trans_id    DEFAULT     z   ALTER TABLE ONLY bank.transactions ALTER COLUMN trans_id SET DEFAULT nextval('bank.transactions_trans_id_seq'::regclass);
 B   ALTER TABLE bank.transactions ALTER COLUMN trans_id DROP DEFAULT;
       bank       postgres    false    214    213    214            �
           2604    16551    users user_id    DEFAULT     j   ALTER TABLE ONLY bank.users ALTER COLUMN user_id SET DEFAULT nextval('bank.users_user_id_seq'::regclass);
 :   ALTER TABLE bank.users ALTER COLUMN user_id DROP DEFAULT;
       bank       postgres    false    212    211    212            '          0    16621    transactions 
   TABLE DATA               ?   COPY bank.transactions (trans_id, amount, user_id) FROM stdin;
    bank       postgres    false    214   �       %          0    16548    users 
   TABLE DATA               \   COPY bank.users (user_id, first_name, last_name, balance, user_name, user_pass) FROM stdin;
    bank       postgres    false    212   �       /           0    0    transactions_trans_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('bank.transactions_trans_id_seq', 50, true);
            bank       postgres    false    213            0           0    0    users_user_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('bank.users_user_id_seq', 28, true);
            bank       postgres    false    211            �
           2606    16626    transactions transactions_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY bank.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (trans_id);
 F   ALTER TABLE ONLY bank.transactions DROP CONSTRAINT transactions_pkey;
       bank         postgres    false    214            �
           2606    16556    users users_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY bank.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 8   ALTER TABLE ONLY bank.users DROP CONSTRAINT users_pkey;
       bank         postgres    false    212            �
           2606    16646    users users_user_name_key 
   CONSTRAINT     W   ALTER TABLE ONLY bank.users
    ADD CONSTRAINT users_user_name_key UNIQUE (user_name);
 A   ALTER TABLE ONLY bank.users DROP CONSTRAINT users_user_name_key;
       bank         postgres    false    212            �
           2606    16627 &   transactions transactions_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY bank.transactions
    ADD CONSTRAINT transactions_user_id_fkey FOREIGN KEY (user_id) REFERENCES bank.users(user_id) ON DELETE CASCADE;
 N   ALTER TABLE ONLY bank.transactions DROP CONSTRAINT transactions_user_id_fkey;
       bank       postgres    false    2725    214    212           
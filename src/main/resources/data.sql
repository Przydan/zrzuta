insert into `user` (username, first_name, last_name)
values ('nowi', 'Jakub', 'Nowak');

insert into `user` (username, first_name, last_name)
values ('kowali', 'Patryk', 'Kowalski');

INSERT INTO whip_round (id, title, description, start_date, end_date, amount, user_username)
VALUES (nextval('whipround_seq'), 'Na auto', 'szybkie', '2020-02-15', '2020-02-27', 5000000 , 'nowi');

INSERT INTO whip_round (id, title, description, start_date, end_date, amount, user_username)
VALUES (nextval('whipround_seq'), 'Na dom', 'duży', '2020-02-15', '2020-02-27', 80000000 , 'nowi');

insert into donation (id, amount, donation_date, whip_round_id, user_username)
values (nextval('donation_seq'), 100000, '2020-02-15', 1, 'kowali');

insert into donation (id, amount, donation_date, whip_round_id, user_username)
values (nextval('donation_seq'), 100000, '2020-02-15', 2, 'kowali');

insert into donation (id, amount, donation_date, whip_round_id, user_username)
values (nextval('donation_seq'), 200000, '2020-02-15', 2, 'nowi');


commit;
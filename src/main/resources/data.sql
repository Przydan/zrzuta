INSERT INTO whip_round (id, title, description, start_date, end_date, amount)
VALUES (nextval('whipround_seq'), 'Na auto', 'szybkie', '2020-02-15', '2020-02-27', 5000000 );

insert into donation (id, amount, donation_date, whip_round_id)
values (nextval('donation_seq'), 100000, '2020-02-15', 1);

commit;
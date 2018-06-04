insert into taskmgmt.user (email_id, password, created_at, updated_at) value('nithyancse@gmail.com', '123', '2018-06-02', '2018-06-02');
insert into taskmgmt.user (email_id, password, created_at, updated_at) value('nithyanmobile@gmail.com', '123', '2018-06-02', '2018-06-02');

insert into taskmgmt.company (name, created_at, updated_at ) value('Apple', '2018-06-02', '2018-06-02');
insert into taskmgmt.company (name, created_at, updated_at ) value('Facebook', '2018-06-02', '2018-06-02');

update taskmgmt.user set company_id = 1, name="Nithyanandam T" where id=1;
update taskmgmt.user set company_id = 1, name="Anand"  where id=2;


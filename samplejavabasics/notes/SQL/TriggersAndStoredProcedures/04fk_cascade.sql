SHOW CREATE TABLE diamond_users;

# cant directly add the on delete cascade, so need to delete the fk key first
# Use the appropriate name for the foreign key 
ALTER TABLE diamond_users     
DROP FOREIGN KEY diamond_users_ibfk_1;
    
alter table diamond_users 
add constraint diamond_fk_uid
foreign key (uid) references gold_users(uid)
on delete cascade;
                    
SHOW CREATE TABLE diamond_users;

select * from diamond_users;

insert into diamond_users values(19, 40);

select * from diamond_users;

delete from gold_users where uid = 19;                 

select * from gold_users;

select * from diamond_users;

## Updates to the parent table are not possible if there are dependent rows
## in the child table
update gold_users
set uid = 19
where uid = 31;
  
####
## ON UPDATE CASCADE
####

ALTER TABLE diamond_users     
DROP FOREIGN KEY diamond_fk_uid;
    
alter table diamond_users 
add constraint diamond_fk_uid
foreign key (uid) references gold_users(uid)
on delete cascade
on update cascade;

select * from diamond_users;

update gold_users
set uid = 19
where uid = 31;

select * from gold_users;

select * from diamond_users;

-- Cascade in SQL refers to a feature used in foreign key constraints to 
-- automatically propagate changes from a parent table to a related child table. 
-- This ensures referential integrity by allowing changes in the parent table 
-- to be reflected in the child table.
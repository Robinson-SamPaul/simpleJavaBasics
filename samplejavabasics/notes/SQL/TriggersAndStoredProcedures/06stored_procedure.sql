DROP PROCEDURE IF EXISTS get_gold_user;
DROP PROCEDURE IF EXISTS create_new_user;

use online_shopping;

select * from gold_users;

## In MySQL, the semi-colon is the default delimiter. In this example, MySQL assumes that
## the statement ends at the semi-colon, hence you get a syntax error
CREATE PROCEDURE get_gold_user()
BEGIN
select uid from gold_users;
END

## The solution is to explicitly define a delimiter for the procedure. Here we use "//"
DELIMITER //
CREATE PROCEDURE get_gold_user()
BEGIN
select uid from gold_users;
END
//
DELIMITER ;

SHOW PROCEDURE STATUS where db = 'online_shopping';

## Refresh the schemas menu on the left and navigate to the stored procedures view
## RIght-click on the get_gold_user procedure and select "Copy to Clipboard" --> "Create Procedure"
CALL `online_shopping`.`get_gold_user`();

## If you already have an active database, you can reference the procedure directly
CALL get_gold_user();

## Redefine the procedure to retrieve a single gold user (we'll modify it soon to accept an argument)
## It's good practice to use the "DROP PROCEDURE IF EXISTS" to ensure you're replacing the current 
## version of the stored proc
DELIMITER //
DROP PROCEDURE IF EXISTS get_gold_user;
CREATE PROCEDURE get_gold_user()
BEGIN
DECLARE userid int;
SET userid = 10;
select * from gold_users
where uid = userid;
END
//
DELIMITER ;

CALL get_gold_user();

## Accept an input argument. The user ID is the parameter for this proc
DELIMITER //
DROP PROCEDURE IF EXISTS get_gold_user;
CREATE PROCEDURE get_gold_user(IN userid int)
BEGIN
select * from gold_users
where uid = userid;
END
//
DELIMITER ;

CALL get_gold_user(10);

CALL get_gold_user(33);

## We create a new stored procedure to create a new user
DROP PROCEDURE IF EXISTS create_new_user;

## The first version is effectively an alias for an "insert into users" statement
DELIMITER //
CREATE PROCEDURE create_new_user(IN arg_user_id int,
								 IN arg_first_name varchar(255),
							     IN arg_last_name varchar(255),
							     IN arg_email_id varchar(255),
							     IN arg_city varchar(255),
							     IN arg_phone varchar(255))
BEGIN
insert into users values(arg_user_id, arg_first_name, arg_last_name,
						 arg_email_id, arg_city, arg_phone);
END
//
DELIMITER ;

SHOW PROCEDURE STATUS where db = 'online_shopping';


CALL create_new_user(100, 'Rick', 'Tallon',
					 'Rick_Tallon65@hotmail.com', 'Trenton', 
                     '+1 555 222 2501');
                     
select * from users;

## The benefit of stored procedures is that we can add a lot of logic to them
## This version of the proc throws an error when a duplicate row is inserted
CALL create_new_user(100, 'Renee', 'Bauer',
					 'renee_bauer70@hotmail.com', 'Pullman', 
                     '+1 555 110 4321');
                    
                    
DELIMITER //
DROP PROCEDURE IF EXISTS create_new_user;
CREATE PROCEDURE create_new_user(IN arg_user_id int,
								 IN arg_first_name varchar(255),
							     IN arg_last_name varchar(255),
							     IN arg_email_id varchar(255),
							     IN arg_city varchar(255),
							     IN arg_phone varchar(255))
BEGIN
IF NOT EXISTS (select user_id from users where user_id = arg_user_id) THEN
	insert into users values(arg_user_id, arg_first_name, arg_last_name,
							 arg_email_id, arg_city, arg_phone);
ELSE
	select 'User ID already in use. Please select another one.';
END IF;
END
//
DELIMITER ;

CALL create_new_user(100, 'Renee', 'Bauer',
					 'renee_bauer70@hotmail.com', 'Pullman', 
                     '+1 555 110 4321');
                     
CALL create_new_user(101, 'Renee', 'Bauer',
					 'renee_bauer70@hotmail.com', 'Pullman', 
                     '+1 555 110 4321');
                     
select * from users;


## A single procedure to add users. Includes boolean arguments to convey whether they
## should be enrolled as gold or diamond users. For gold users, we enroll them into the 
## gold program for one year. For diamond users, they get 100 units added to their wallet

## The procedure only allows users to be enrolled as diamond users if they're also marked
## for gold membership

DELIMITER //
DROP PROCEDURE IF EXISTS create_new_user;
CREATE PROCEDURE create_new_user(IN arg_user_id int,
								 IN arg_first_name varchar(255),
								 IN arg_last_name varchar(255),
                                 IN arg_email_id varchar(255),
                                 IN arg_city varchar(255),
                                 IN arg_phone varchar(255),
                                 IN arg_is_gold_users bool,
                                 IN arg_is_diamond_users bool
                                 )
BEGIN
IF not EXISTS (select user_id from users where user_id = arg_user_id) THEN
	insert into users(user_id, first_name, last_name, email_id, city, phone)
				values(arg_user_id, arg_first_name, arg_last_name, 
					   arg_email_id, arg_city, arg_phone);
END IF;  
IF(arg_is_gold_users) THEN
	insert into gold_users(uid, end_date, points)
				values(arg_user_id, DATE_ADD(CURDATE(), INTERVAL 1 YEAR), 0);
	IF (arg_is_diamond_users) THEN          
		insert into diamond_users(uid, wallet_balance)
					values(arg_user_id, 100); 
	END IF;
END IF;
IF (arg_is_diamond_users) THEN
	IF not EXISTS (select uid from gold_users where uid = arg_user_id) THEN
		select 'All Diamond users need to be Gold users.';
	END IF;
END IF;
END
//
DELIMITER ;

## The below call will display our custom error messgae
CALL create_new_user(666, 'Nikki', 'Flores',
					 'Nikki_Flores77@hotmail.com', 'Savannah', 
                     '+1 555 990 9321', FALSE, TRUE);
                   
CALL create_new_user(777, 'Rob', 'Lawrence',
					 'rob_lawrence80@hotmail.com', 'Charleston', 
                     '+1 555 990 9322', FALSE, FALSE); 
                     
CALL create_new_user(888, 'Zachary', 'MacKenzie',  
					 'zacharymackenzie9@gmail.com', 'Santa Fe', 
                     '+1 555 990 9323', TRUE, TRUE);
                     
CALL create_new_user(999, 'Zack', 'Harken',   
					 'Zack_Harken@hotmail.com', 'Huntsville', 
                     '+1 555 990 9324', TRUE, FALSE);        
                     
select * from users; 

select *  from gold_users;

select * from diamond_users;

                                          
                     


 
 



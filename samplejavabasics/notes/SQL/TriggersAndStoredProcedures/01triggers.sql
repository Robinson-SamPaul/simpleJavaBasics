use online_shopping;

## Confirm the contents of the users and gold_users tables
select * from users;

select * from gold_users;

## No triggers in place yet
show triggers from online_shopping;

## Assume there is a special offer. All new users being added to the system are 
## automatically accorded gold_user status
## For each user added to users, this trigger will add a corresponding entry into gold_users
## The end_date is set to one year from the current date and they have zero points
CREATE TRIGGER autoEnrollGold
AFTER INSERT
ON users
FOR EACH ROW 
INSERT INTO gold_users(uid, end_date, points) 
			VALUES(new.user_id, 
				   DATE_ADD(CURDATE(), INTERVAL 1 YEAR),
				   0);
                   
show triggers from online_shopping;   

insert into users values(40, 'Alen' , 'Alford', 
						 'Alan_Alford63@hotmail.com', 'Wisconsin', '+1 555 211 2562');

## The new user is added to both the users and gold_users tables
select * from users;

select * from gold_users;

drop trigger autoEnrollGold;

show triggers from online_shopping;  



#########################################################             
#########################################################
#########################################################

## To demostrate a before insert trigger we introduce a new table with a foreign key
## The diamond users are special types of gold users and are given
## a wallet balance which they can spend

create table diamond_users(uid int primary key,
						   wallet_balance int, 
                           foreign key(uid) references gold_users(uid));

describe diamond_users;                           
         

## Using IF statements in a trigger
## Assume we want to enroll an already existing user into the gold and diamond programme
## Rather than insert a row into gold_users and then diamond_users, we assume that adding them
## as a diamond user means that they should also be gold_users
## But the foreign key constraint on diamond users prevents new diamond users from being added
## unless they're already gold users. So we add an entry into gold_users as well

DELIMITER //       
CREATE TRIGGER enrollDiamondUsersToGold
BEFORE INSERT
ON diamond_users
FOR EACH ROW
IF EXISTS (SELECT user_id FROM users WHERE user_id = new.uid) THEN
	IF NOT EXISTS (SELECT uid FROM gold_users WHERE uid = new.uid) THEN
		INSERT INTO gold_users 
					VALUES(new.uid, 
						   DATE_ADD(CURDATE(), INTERVAL 1 YEAR),
						   0);
	END IF;
END IF;
//
DELIMITER ;

show triggers from online_shopping;

select * from users;

select * from gold_users;

select * from diamond_users;

insert into diamond_users(uid, wallet_balance) values(31, 10);

select * from diamond_users;

select *  from gold_users;


## Ensure that we can still add diamond users who are already gold users
insert into diamond_users(uid, wallet_balance) values(11, 72);

select * from diamond_users;

## Confirm that we cannot add as diamond users those who aren't users
insert into diamond_users(uid, wallet_balance) values(30, 72);




	
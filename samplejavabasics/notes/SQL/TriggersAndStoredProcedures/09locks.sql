use bank;

SELECT CONNECTION_ID();

SHOW PROCESSLIST;

select * from checking_account;

#acquire a lock using the LOCK TABLE statement.
LOCK TABLE checking_account READ;

## You can still read from the table
select * from checking_account;
 
#But insert is not possible with a READ lock
insert into checking_account  values (1117, "Omar", 20000);  

SHOW PROCESSLIST;


# create another session and login to USERA session 

###################################################
####### This is from the SECOND session ###########
###################################################
SELECT CONNECTION_ID();

SHOW PROCESSLIST;

use bank;

select * from checking_account;

# This insert is in blocking, waiting for the lock to be released
insert into checking_account  values (1117, "Omar", 20000);  


###################################################
####### This is from the FIRST session ###########
###################################################

# This will show that a process is waiting
SHOW PROCESSLIST;
 
# we can unlock the table 
unlock tables;

###################################################
####### This is from the SECOND session ###########
###################################################

## The insert has finished running

## Confirm the insert
select * from checking_account;

###################################################
####### This is from the FIRST session ###########
###################################################

## Confirm the insert - the same data is visible here
select * from checking_account;

## Using a WRITE lock
LOCK TABLE checking_account WRITE;

## Read operations are still possible
select * from checking_account;

## As are write operations
insert into checking_account values(1118, "Alex", 6000);


###################################################
####### This is from the SECOND session ###########
###################################################

# Even a read operation will block until the first session releases its lock
select * from checking_account;

###################################################
####### This is from the FIRST session ###########
###################################################

SHOW PROCESSLIST;

unlock tables;

###################################################
####### This is from the SECOND session ###########
###################################################

## The query has now completed


###################################################
####### This is from the FIRST session ###########
###################################################

LOCK TABLE checking_account READ;

###################################################
####### This is from the SECOND session ###########
###################################################

# This will block due to the read lock on the table
insert into checking_account values(1119, "Amber", 68000);


###################################################
####### This is from the FIRST session ###########
###################################################

# You can see that the other session is waiting for the lock to be released
SHOW PROCESSLIST;

# Acquire a lock on the savings_account table
# This will cause the lock on checking_account to be released
LOCK TABLE savings_account READ;

# This suggests that the second session is no longer waiting
SHOW PROCESSLIST;

## This confirms that the insert from the second session has taken place
select * from checking_account;

###################################################
####### This is from the SECOND session ###########
###################################################

## Confirm that the query has completed


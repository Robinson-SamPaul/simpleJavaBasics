SHOW DATABASES; -- to show all DBs 
SHOW GLOBAL VARIABLES; --  some configs

CREATE DATABASE database_name;
SHOW TABLES;

USE database_name;
SHOW TABLES;

CREATE TABLE users (
    id INT,
    username VARCHAR(50),
    email VARCHAR(100)
);

INSERT INTO users (id, username, email) 
VALUES (1, 'john_doe', 'john.doe@example.com');
INSERT INTO users (id, username) 
VALUES (1, 'john_doe');
INSERT INTO users 
VALUES (2, 'jane_smith', 'jane.smith@example.com');

SELECT * FROM users; -- * is wildcard for ALL, use attributes to find specific fields
SELECT id, username, email FROM users;

-- DESCRIBE to get information about a table's structure 
-- SHOW CREATE TABLE to get create statement used to create the table
-- The output includes columns such as:
-- 		Field: Column name.
-- 		Type: Data type of the column.
-- 		Null: Whether the column can contain NULL values.
-- 		Key: Indicates if the column is part of a primary or foreign key.
-- 		Default: Default value for the column.
-- 		Extra: Additional information (e.g., auto_increment).
DESCRIBE users;
SHOW CREATE TABLE users;

-- This provides information about how MySQL would execute a query on the table.
-- The output focuses on execution plans for queries, including:
-- 		id: The query's unique identifier.
-- 		select_type: The type of query (e.g., SIMPLE, PRIMARY, SUBQUERY).
-- 		table: The table being queried.
-- 		type: The join type or access method (e.g., ALL, INDEX).
-- 		key: The index used (if any).
-- 		rows: Estimated rows to be scanned.
-- 		Extra: Additional information about the execution.
DESCRIBE TABLE users;
EXPLAIN SELECT * FROM users;
EXPLAIN TABLE users;

-- deleting/removing
TRUNCATE TABLE users;
DROP TABLE users;

-- primary key is unique and only 1 key for 1 table
-- composite key is When the primary key consists of two or more columns, it is referred to as a composite primary key.
-- candidate key is unique and many keys for 1 table(eID, phone, mail)
-- super key is unique and combination of(primary + other column<extra column for more particular>) for 1 table

CREATE TABLE users (
    id INT UNIQUE NOT NULL, -- as this table contains only one unique, that too not null attribute, MySQL converts it into primary key implicitly
    username VARCHAR(50),
    email VARCHAR(100)
);

SELECT * FROM users where email = "jane.smith@example.com"; -- this might take some time, if million records
CREATE INDEX email_index ON users(email);
SELECT * FROM users where email = "jane.smith@example.com"; -- it's better in searching, after setting index, insertion/modification/deletion is slow

SHOW INDEX FROM users; -- Indexes are used to find values within a specific column more quickly

CREATE TABLE new_table AS SELECT * FROM users where email = "jane.smith@example.com";
SELECT * FROM new_table;
DESCRIBE users; -- index and primary key constraints are present
DESCRIBE new_table; -- new table don't, only copy values

ALTER TABLE users ADD phone VARCHAR(255);
UPDATE users SET username = 'sam' where id = 0;
DESCRIBE users;

drop TABLE users;
CREATE TABLE users (
    id INT,
    username VARCHAR(50),
    email VARCHAR(100),
    PRIMARY KEY (id)
);
drop TABLE users;
CREATE TABLE users (
    id INT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100)
);

INSERT INTO users VALUES (2, 'jane_smith', 'jane.smith@example.com');
INSERT INTO users VALUES (null, 'jane_smith', 'jane.smith@example.com'); --  error

-- The <> operator is part of the ANSI SQL standard and is widely supported across different database systems.
-- The != operator is also commonly supported by many SQL database systems, but it is not part of the official SQL standard.

SELECT * FROM users
WHERE username IN ('Sam', 'Rob', 'Paul');
SELECT * FROM users
WHERE username NOT IN ('Sam', 'Rob', 'Paul');
SELECT * FROM users
WHERE username LIKE "%sam%";
SELECT * FROM users
WHERE username NOT LIKE "%sam%";
SELECT * FROM users
WHERE username IN (SELECT * FROM users WHERE id = 1); -- subquery(IN will accept colum of v alues)
DROP TABLE users;

CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100)
);
INSERT INTO customers (id, name, email) VALUES
(1, 'John Doe', 'john.doe@example.com'),
(2, 'Jane Smith', 'jane.smith@example.com'),
(3, 'Michael Johnson', 'michael.johnson@example.com');
CREATE TABLE orders (
    id INT PRIMARY KEY,
    order_number VARCHAR(20),
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);
INSERT INTO orders (id, order_number, customer_id) VALUES
(101, 'ORD001', 1),  -- John Doe's order
(102, 'ORD002', 2),  -- Jane Smith's order
(103, 'ORD003', 1),  -- John Doe's another order
(104, 'ORD004', 3);  -- Michael Johnson's order

INSERT INTO orders (id, order_number, customer_id) VALUES
(101, 'ORD001', 5);  -- 5 is not present in orders table

ALTER TABLE orders
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id) REFERENCES customers(id);
ALTER TABLE orders
DROP CONSTRAINT fk_customer_id;

SELECT id, username, email FROM users
WHERE id BETWEEN 10 AND 20;

SELECT curdate();
SELECT curtime();
ALTER TABLE users ADD dates DATE;
INSERT INTO users VALUES (20, 'jane_smith', 'jane.smith@example.com', '2024-06-26');
SELECT * FROM users where dates = '2024-06-26';

SELECT * FROM users
ORDER BY username DESC, id -- username is descending, if equal username, it'll be ordered by ID in ascending
LIMIT 5; -- only 5 users will come

CREATE TABLE students (
    StudentID INT AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(100)
);
CREATE TABLE courses (
    CourseID INT AUTO_INCREMENT PRIMARY KEY,
    CourseName VARCHAR(100)
);
INSERT INTO students (StudentName)
VALUES ('Alice'), ('Bob'), ('Charlie');
INSERT INTO courses (CourseName)
VALUES ('Math'), ('Science'), ('History');

-- CROSS JOIN
SELECT * FROM students; -- has 3 rows and 2 columns
SELECT * FROM courses; -- has 3 rows and 2 columns
SELECT * FROM students -- has 9 rows and 4 columns
CROSS JOIN courses; -- cross(cartesian) join will combine tables with (column1 + column2) and (row1 * row2)
DROP TABLE students;
DROP TABLE courses;

-- INNER JOIN
CREATE TABLE students (
    StudentID INT AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(100)
);
CREATE TABLE enrollments (
    EnrollmentID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID INT,
    CourseName VARCHAR(100)
);
INSERT INTO students (StudentName)
VALUES ('Alice'), ('Bob'), ('Charlie'), ('Sam');
INSERT INTO enrollments (StudentID, CourseName)
VALUES (1, 'Math'), (1, 'Science'), (2, 'Math'), (3, 'History'), (10, 'Psycho');
SELECT * FROM students; -- has 4 rows and 2 columns
SELECT * FROM enrollments; -- has 5 rows and 3 columns

SELECT * FROM students s --  s is for alias, same for e below, can use full table name or like this
INNER JOIN enrollments e -- it's smiliar to cross join. INNER JOIN = CROSS JOIN + FILTER CONDITION
ON s.StudentID = e.StudentID; -- fiter condition makes sure row is <= row1*row2, column is always column1 + column2
-- Sam is not visible in INNER JOIN

-- just like <> and != are same, LEFT JOIN and LEFT OUTER JOIN are same
SELECT * FROM students s
LEFT JOIN enrollments e
ON s.StudentID = e.StudentID;
-- Sam is null in LEFT JOIN

SELECT * FROM students s
RIGHT JOIN enrollments e
ON s.StudentID = e.StudentID;
-- Psycho is null in RIGHT JOIN

SELECT * FROM students s
LEFT JOIN enrollments e
ON s.StudentID = e.StudentID
UNION
SELECT * FROM students s
RIGHT JOIN enrollments e
ON s.StudentID = e.StudentID;
-- LEFT + RIGHT = FULL JOIN

SELECT * FROM students; -- has 4 rows and 2 columns
SELECT * FROM enrollments; -- has 5 rows and 3 columns
SELECT * FROM students s
NATURAL JOIN enrollments e; -- So, natural join basically combines the same column name of 2 tables

SELECT s1.StudentID AS StudentID1, s1.StudentName AS StudentName1,
       s2.StudentID AS StudentID2, s2.StudentName AS StudentName2
FROM students s1
JOIN students s2 ON s1.StudentID = s2.StudentID; --  joining same table with it based on student ID

DROP DATABASE database_name;
DROP TABLE users;
CREATE TABLE users(user_id INT,
                   first_name VARCHAR(255)NOT NULL,
                   last_name VARCHAR(255),
                   email_id VARCHAR(255),
                   city VARCHAR(255),
                   phone VARCHAR(255) NOT NULL, 
                   PRIMARY KEY(user_id));
DESCribe users;
INSERT INTO users VALUES(10, 'Claudia', 'Sand', 'Claudia.Sand@hotmail.com', 'Hanover', '+1 555 234 5678');
INSERT INTO users VALUES (20, 'Julio', 'Chavez', 'chavezj317@gmail.com', 'Savannah', '+1 555 890 9898' );
INSERT INTO users VALUES(15, 'Neil', 'Parks', 'neil_parks82@hotmail.com', 'Pleasanton', '+1 555 567 3456');
INSERT INTO users VALUES(19, 'Gina' , 'Ortiz', 'Gina_Ortiz68@hotmail.com', 'Hempstead', '+1 555 963 8521');
INSERT INTO users VALUES(11, 'Raj' , 'Chawanda', 'raj_chawanda@hotmail.com', 'Springfield', '+1 555 211 2563');
INSERT INTO users VALUES(31, 'Marcia', 'Lin', 'Marcia_Lin89@hotmail.com', 'Springfield', '+1 555 234 8765');
INSERT INTO users VALUES(33, 'Chen', 'Lin', 'Marcia_Lin89@hotmail.com', 'Moab', '+1 555 111 0357');
INSERT INTO users VALUES(34, 'Charles', 'Lin', 'chlin@qenel.com', 'Moab', '+1 555 111 0357');
INSERT INTO users VALUES(24, 'Martha', 'Horowitz', 'horowitzmartha@gmail.com', 'Moab', '+1 555 034 9032');
INSERT INTO users VALUES(35, 'Chantal', NULL, 'Chantal_Sands62@hotmail.com', 'Pittsburgh', '+1 555 432 1098');

CREATE TABLE products(prod_id INT,
                      prod_name VARCHAR(255),
                      brand VARCHAR(255),
                      price float,
                      prod_category VARCHAR(255),
                      PRIMARY KEY (prod_Id));
INSERT INTO products VALUES( 101, 'Sonical M120', 'Sonical', 200, 'mobiles');
INSERT INTO products VALUES( 151, 'Sonical L34', 'Sonical', 799, 'laptops');
INSERT INTO products VALUES( 105, 'Sonical P03', 'Sonical', 199, 'printers');
INSERT INTO products VALUES( 107, 'Fambic M43', 'Fambic', 500, 'mobiles');
INSERT INTO products VALUES( 121, 'Fambic M23', 'Fambic', 400, 'mobiles');
INSERT INTO products VALUES( 122, 'Fambic T342', 'Fambic', 310, 'televisions');
INSERT INTO products VALUES( 123, 'Diallonic M901', 'Diallonic', 810, 'laptops');
INSERT INTO products VALUES( 125, 'Diallonic T03', 'Diallonic', 290, 'televisions');
INSERT INTO products VALUES( 126, 'Diallonic T04', 'Diallonic', 450, 'televisions');
SELECT count(*) FROM products; -- 9
SELECT count(*) FROM users; -- 10

# The DISTINCT keyword
SELECT DISTINCT brand FROM products;

## GROUP BY
SELECT city, count(*) FROM users GROUP BY city;
SELECT last_name, count(*) FROM users GROUP BY last_name ORDER BY count(*) DESC;

## A column in the SELECT clause must fulfil one of these criteria:
## Grouping Columns: All columns listed in the SELECT clause that are not used within an aggregate function must be included in the GROUP BY clause.
## Aggregate Functions: Columns that are used in aggregate functions (e.g., COUNT, SUM, AVG, MIN, MAX) do not need to be included in the GROUP BY clause.
SELECT last_name, first_name, count(first_name) FROM users GROUP BY last_name; -- error
SELECT last_name, first_name, count(first_name) FROM users GROUP BY last_name, first_name order by first_name;

## The AVG function
select prod_category, avg(price) from products group by prod_category;

## The ROUND function
select round(avg(price), 2) as my_own_attribute_name_for_aggregate_function from products; -- no extra select clause, and group by also not needed
select brand, round(avg(price), 2) from products group by brand;

## The MAX function
select brand, max(price) from products group by brand;

## The MIN function
select brand, min(price) from products group by brand;

select brand, sum(price) from products group by brand;

select prod_category, avg(price) from products group by prod_category;

## The WHERE clause cannot be used with aggregate operations
select prod_category, avg(price) from products 
where avg(price) > 250 group by prod_category;
## The HAVING clause is meant to be used with aggregators
select prod_category, avg(price) from products group by prod_category having avg(price) > 250;

## Multiple conditions in the HAVING clause
select brand, sum(price), avg(price)
from products group by brand
having sum(price) < 1300 and avg(price) >400;

## The some and all functions
select * from products;

select price from products where prod_category = 'televisions';

select * from products where prod_category = 'mobiles'
and price > some (310, 290, 450); -- won't accept hardcoded values, some will accept only subquery, try below
select * from products where prod_category = 'mobiles';
select price from products where prod_category = 'televisions';
select * from products where prod_category = 'mobiles'
and price > some (select price from products where prod_category = 'televisions'); --  some/any is like a OR operator, if 1 matches means also it'll work
select * from products where prod_category = 'mobiles'
and price > all (select price from products where prod_category = 'televisions'); -- it's like AND operator, all conditon should satisfy

## Creating a descending order index
## An ordered index can perform a sort in memory
# An index in MySQL is a data structure that improves the speed of data retrieval operations on a database table at the cost of additional storage space and increased time for insert, update, and delete operations
select prod_category, prod_name, price from products order by price desc;
create index prod_price_desc_index on products (price desc);
show index from products;
describe users;
show index from users;

-- A view in MySQL is a virtual table based on the result-set of a SQL query. It contains rows and columns just like a real table, and the fields in a view are fields from one or more real tables in the database.
-- Benefits of Using Views
-- 		Simplification: Simplifies complex queries.
-- 		Security: Restricts access to specific rows and columns.
-- 		Consistency: Ensures that users see a consistent set of data.

select prod_name, brand, prod_category, price
from products where price > 400;

create view expensive_products as -- it's like creating a function for a query, and calling that function whenever we want, instead of calling query each time
select prod_name, brand, prod_category, price 
from products where price > 400;

select * from expensive_products;

insert into products values( 129, 'Fambic T393', 'Fambic', 510, 'televisions');

select * from expensive_products;

CREATE OR REPLACE VIEW expensive_products as -- updating/modifying/creating the function
select prod_name, brand, prod_category, price 
from products where price > 400;

DROP VIEW expensive_products;

-- SHOW TABLES: Lists all the tables in the selected database without distinguishing between table types.
-- Usage: SHOW TABLES;
-- Output: Simple list of table names.
-- SHOW FULL TABLES: Lists all the tables in the selected database and provides additional information about the table type (BASE TABLE or VIEW).
-- Usage: SHOW FULL TABLES;
-- Output: List of table names along with their types.
show tables;
show full tables;

-- Start a new transaction
START TRANSACTION; -- without starting, can't rollback, v can but nothing will happen
-- Insert a new row into the 'accounts' table
INSERT INTO accounts (account_id, balance) VALUES (1, 100); --  DDL won't be rollbacked, create, alter, etc, are default committed stuff, so can't rollback
-- Set a savepoint
SAVEPOINT sp1;
-- Update the balance of the account
UPDATE accounts SET balance = balance + 50 WHERE account_id = 1;
-- Set another savepoint
SAVEPOINT sp2;
-- Attempt an operation that fails (e.g., inserting a duplicate key)
INSERT INTO accounts (account_id, balance) VALUES (1, 200); -- This will cause an error
-- Rollback to the last savepoint
ROLLBACK TO SAVEPOINT sp2; --  only rollback will rest everything untill start transaction
-- Release the first savepoint
RELEASE SAVEPOINT sp1;
-- Commit the transaction
COMMIT;

-- VIEW
--     A view in SQL is a virtual table that provides a way to look at data from one or more tables. 
--     It does not store data physically but is a stored query that can be treated as a table.
-- Trigger
--     A trigger is a set of instructions that automatically executes (or "fires") in response to 
--     a specific event on a particular table or view, such as INSERT, UPDATE, or DELETE.
-- Stored Procedure
--     A stored procedure is a precompiled collection of one or more SQL statements 
--     that can be executed on demand. It can accept input parameters, return output parameters, 
--     and provide status messages to the client.

-- View: Creating a view to simplify the reporting on sales data.
-- Trigger: Using a trigger to automatically update inventory counts when an order is placed.
-- Stored Procedure: Writing a stored procedure to handle complex business logic for processing payroll.

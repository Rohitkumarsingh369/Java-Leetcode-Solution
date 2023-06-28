# Write your MySQL query statement below
SELECT MAX(salary) AS  secondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(salary) FROM Employee);
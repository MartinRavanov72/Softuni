SELECT SUM(l.amount) AS total_loan_amount, MAX(l.interest) AS max_interest, MIN(e.salary) AS min_salary
FROM employees AS e
JOIN employees_loans AS  el
ON  e.employee_id  =  el.employee_id
JOIN loans AS l
ON l.loan_id = el.loan_id;
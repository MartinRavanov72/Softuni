CREATE PROCEDURE usp_customers_with_unexpired_loans(customer_id INT)
BEGIN
   SELECT c.customer_id, c.first_name, l.loan_id
   FROM customers AS c
   JOIN loans AS l
   ON c.customer_id = l.customer_id
   WHERE c.customer_id = customer_id
   AND l.expiration_date IS NULL;
END
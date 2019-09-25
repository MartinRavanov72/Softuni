CREATE PROCEDURE usp_take_loan(customer_id INT, loan_amount DECIMAL(10,2), interest DECIMAL(10,2), start_date DATE)
BEGIN
   START TRANSACTION;
   IF (loan_amount NOT BETWEEN 0.01 AND 100000)
   THEN ROLLBACK; SIGNAL SQLSTATE '45000' SET Message_Text = 'Invalid Loan Amount.';
	ELSE INSERT INTO loans(start_date, amount, interest, customer_id)
   VALUES (start_date, loan_amount, interest, customer_id);
   END IF;
END
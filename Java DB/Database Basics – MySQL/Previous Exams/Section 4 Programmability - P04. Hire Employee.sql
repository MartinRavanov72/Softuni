CREATE TRIGGER tr_hire_employee
AFTER INSERT
ON employees
FOR EACH ROW
BEGIN
   UPDATE employees_loans AS el
   SET el.employee_id = NEW.employee_id
   WHERE el.employee_id + 1 = NEW.employee_id;
END
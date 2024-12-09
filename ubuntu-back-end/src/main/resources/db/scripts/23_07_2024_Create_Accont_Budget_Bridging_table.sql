CREATE TABLE budgetbuddy.account_budget(
  id INT NOT NULL PRIMARY KEY,
  account_id INT REFERENCES budgetbuddy.account(id),
  budget_id INT REFERENCES budgetbuddy.budget(id)
  );
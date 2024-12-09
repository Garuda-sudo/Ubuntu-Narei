CREATE TABLE budgetbuddy.room_budget(
  id INT NOT NULL PRIMARY KEY,
  room_id INT REFERENCES budgetbuddy.account(id),
  budget_id INT REFERENCES budgetbuddy.budget(id)
  );
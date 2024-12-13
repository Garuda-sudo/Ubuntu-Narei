CREATE TABLE budgetbuddy.budget_category(
  id INT NOT NULL PRIMARY KEY,
  budget_id INT REFERENCES budgetbuddy.budget(id),
  category_id INT REFERENCES budgetbuddy.category(id)
  );
CREATE TABLE budgetbuddy.budget_income_split (
    id SERIAL PRIMARY KEY,
    budget_id INT NOT NULL,
    account_id INT NOT NULL,
    income_amount DECIMAL(10, 2) NOT NULL,
    split_type VARCHAR(20) DEFAULT 'fixed',
    allocation_percentage DECIMAL(5, 2),
    FOREIGN KEY (budget_id) REFERENCES budgetbuddy.budget(id),
    FOREIGN KEY (account_id) REFERENCES budgetbuddy.account(id)
);
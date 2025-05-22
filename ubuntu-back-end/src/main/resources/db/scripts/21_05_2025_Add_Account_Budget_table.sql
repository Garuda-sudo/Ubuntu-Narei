CREATE TABLE budgetbuddy.account_budget (
    id SERIAL PRIMARY KEY,
    budget_id INTEGER NOT NULL,
    account_id INTEGER NOT NULL,
    planned_amount NUMERIC(19, 2),
    actual_spent_amount NUMERIC(19, 2),
    linked_date TIMESTAMP,
    is_default BOOLEAN,
    priority INTEGER,
    notes VARCHAR(500),

    CONSTRAINT fk_account_budget_budget
        FOREIGN KEY (budget_id)
        REFERENCES budgetbuddy.budget(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_account_budget_account
        FOREIGN KEY (account_id)
        REFERENCES budgetbuddy.account(id)
        ON DELETE CASCADE
);
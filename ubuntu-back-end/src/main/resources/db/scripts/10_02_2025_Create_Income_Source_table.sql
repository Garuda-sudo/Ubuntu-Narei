CREATE TABLE budgetbuddy.income_source (
    id SERIAL PRIMARY KEY,
    account_id INT NOT NULL,
    income_name VARCHAR(255) NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    frequency VARCHAR(20) CHECK (frequency IN ('DAILY', 'WEEKLY', 'BIWEEKLY', 'MONTHLY', 'QUARTERLY', 'YEARLY', 'IRREGULAR')) NOT NULL,
    next_expected_date DATE,
    average_amount NUMERIC(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES budgetbuddy.account(id)
);
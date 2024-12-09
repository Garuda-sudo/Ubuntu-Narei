acc-- Create schema if not exists

CREATE SCHEMA IF NOT EXISTS budgetbuddy;

-- Create tables
-- User
CREATE TABLE IF NOT EXISTS budgetbuddy.User
(
    id       serial PRIMARY KEY,
    username varchar(50) NOT NULL,
    email    varchar(50) NOT NULL,
    name     varchar(50),
    surname  varchar(50)
);

-- Account
CREATE TABLE IF NOT EXISTS budgetbuddy.Account
(
    id           serial PRIMARY KEY,
    name         varchar(50)    NOT NULL,
    balance      numeric(10, 2) NOT NULL,
    institution  varchar(50)    NOT NULL,
    date_created timestamp      NOT NULL,
    date_updated timestamp      NOT NULL,
    user_id      int            NOT NULL,
    CONSTRAINT FK_User_Account FOREIGN KEY (user_id) REFERENCES budgetbuddy.User (id)
);


CREATE INDEX FK_User_Account ON budgetbuddy.Account
    (
     user_id
        );

-- Budget
CREATE TABLE IF NOT EXISTS budgetbuddy.Budget
(
    id           serial PRIMARY KEY,
    budget_name  varchar(50)   NOT NULL,
    amount_limit numeric(9, 2) NOT NULL,
    start_date   date          NOT NULL,
    end_date     date          NOT NULL,
    period_type  varchar(10)   NOT NULL,
    date_created timestamp     NOT NULL,
    date_updated timestamp     NOT NULL,
    user_id      int           NOT NULL,
    CONSTRAINT FK_User_Budget FOREIGN KEY (user_id) REFERENCES budgetbuddy.User (id)
);


CREATE INDEX FK_User_Budget ON budgetbuddy.Budget
    (
     user_id
        );

-- Category
CREATE TABLE IF NOT EXISTS budgetbuddy.Category
(
    id           serial PRIMARY KEY,
    name         varchar(50) NOT NULL,
    user_id      int         NOT NULL,
    date_created timestamp   NOT NULL,
    date_updated timestamp   NOT NULL,
    CONSTRAINT FK_User_Category FOREIGN KEY (user_id) REFERENCES budgetbuddy.User (id)
);

CREATE INDEX FK_User_Category ON budgetbuddy.Category
    (
     user_id
        );

-- Transaction
CREATE TABLE IF NOT EXISTS budgetbuddy.Transaction
(
    id           serial PRIMARY KEY,
    amount       numeric(10, 2) NOT NULL,
    currency     varchar(50)    NOT NULL,
    identifier   varchar(50)    NOT NULL,
    date         timestamp      NOT NULL,
    date_created timestamp      NOT NULL,
    date_updated timestamp      NOT NULL,
    category_id  int            NOT NULL,
    user_id      int            NOT NULL,
    account_id   int            NOT NULL,
    CONSTRAINT FK_Category_Transaction FOREIGN KEY (category_id) REFERENCES budgetbuddy.Category (id),
    CONSTRAINT FK_User_Transaction FOREIGN KEY (user_id) REFERENCES budgetbuddy.User (id),
    CONSTRAINT FK_Account_Transaction FOREIGN KEY (account_id) REFERENCES budgetbuddy.Account (id)
);

CREATE INDEX FK_Category_Transaction ON budgetbuddy.Transaction
    (
     category_id
        );

CREATE INDEX FK_User_Transaction ON budgetbuddy.Transaction
    (
     user_id
        );

CREATE INDEX FK_Account_Transaction ON budgetbuddy.Transaction
    (
     account_id
        );

-- Transaction & Budget many to many relationship
CREATE TABLE IF NOT EXISTS budgetbuddy.TransactionBudget
(
    id             serial PRIMARY KEY,
    budget_id      int NOT NULL,
    transaction_id int NOT NULL,
    CONSTRAINT FK_Transaction_TransactionBudget FOREIGN KEY (transaction_id) REFERENCES budgetbuddy.Transaction (id),
    CONSTRAINT FK_Budget_TransactionBudget FOREIGN KEY (budget_id) REFERENCES budgetbuddy.Budget (id)
);

CREATE INDEX FK_Transaction_TransactionBudget ON budgetbuddy.TransactionBudget
    (
     transaction_id
        );

CREATE INDEX FK_Budget_TransactionBudget ON budgetbuddy.TransactionBudget
    (
     budget_id
        );

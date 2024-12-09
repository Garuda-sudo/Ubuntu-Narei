CREATE TABLE AccountBudget (
    PRIMARY KEY (AccountID, BudgetID),
    FOREIGN KEY (AccountID) REFERENCES Account(EventKey),
    FOREIGN KEY (BudgetID) REFERENCES Budget(BudgetID)
);
package co.za.ubuntu.ubuntubackend.domain.enums;

public enum RolloverType {
    SAME_CATEGORY,   // Leftover stays in the same category
    TO_INCOME,       // Leftover is returned to the total income
    TO_SAVINGS,      // Leftover moves to savings
    TO_DEBT_PAYMENT  // Leftover moves to debt repayment
}

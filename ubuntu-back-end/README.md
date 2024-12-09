This is the end to end flow on how the Ubuntu flow works

1. The Create Budget Flow
    - The authenticated user passes in a Budget object to the createBudget endpoint.
    - The budget service gets the user & account linked to the budget
2. How the entire budget flow works
   - A user creates accounts. These accounts are basically buckets for an income or source of income
     that the budget needs to be put up against. This is in order to let the user swap their budgets against different
   - funds collectively or individually. Why do we want this? Because this gives the user creative freedom to put their budget against various
   - sources of income to give them the flexibility. If there was a single income line on the budget then any changes
   - to it would need a new budget for that month which doesnt make sense.*

   - When an user creates a budget, they first choose their income line. This is linked to which accounts they have
   - linked. If they want a percentage of a certain/each income to count then the total income amount takes this
   - into consideration. 
   - The user then chooses the amount they want to spend for that month/period for each category. This can be
   - chosen at the time of creating the budget or categorised at a later stage when consolidating. The balance that
   - remains is then set against an intial value of the projected savings. If it is a zero based budget then this
   - amount will respectively be 0.
   - This budget is then saved away.
   - Through daily tracking, the budget is then updated against each CATEGORY. There is, therefore, a check of the
   - CURRENT ACTUAL SPEND vs the PROJECTED BUDGET initially captured. I.e. If I budgeted R20 for travel, then
   - when actually travelling spend R5, the remaining balance is R15, which is calculated and displayed on the front end.
   - This budget update is done on the updateBudget endpoint, with any other changes data changes.
   - NB: At the moment of tracking, the budget transaction must be linked to a single account that the money was
   - transferred from. You cannot have the money coming from different accounts because it doesn't make sense
3. This is important to consider. A single transaction CANNOT be linked to multiple budgets. A transaction is
   linked to a single budget but can be moved around to another budget. Multiple transactions can also be grouped
   together across multiple budgets for the users consolidation purposes.
   
   -Finally, when consolidating, a budget needs to give the user the ability to see the projected budget vs actual
    spend and get a sense of spending habits. They are then given the ability to project these savings to their
    expected savings goal.
4. There will be a feature that allows users to register their debit orders and these spending line items should carry
   over monthly from budget to budget unless de-activated. These debit orders should also reflect in all of the other
   features*(on an adhoc basis)
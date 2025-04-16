package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.*;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetIncomeSplitDTO;
import co.za.ubuntu.ubuntubackend.dto.DiscountDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for managing budgets related to users.
 * <p>
 * This service provides methods to interact with user budgets, including retrieving, creating,
 * updating, and deleting budgets.
 *
 * @since 0.0.1
 */

public interface DiscountService {

    /**
     * Retrieves a list of discounts that the user has qualified for linked to short term goals.
     * Each discount returned is linked to the category line item and how much they have spent.
     * A Goal must be set in order to get the discount(* Subject to change)
     *
     * @param accountId The unique identifier of the user.
     * @return A list of budgets associated with the user.
     */
    List<BudgetResponse> getUserBudgets(DiscountDTO discountDTO);

    List<DiscountDTO> getShortTermGoalDiscounts(DiscountDTO discountDTO);

    List<DiscountDTO> getLongTermGoalDiscounts(DiscountDTO discountDTO);

}

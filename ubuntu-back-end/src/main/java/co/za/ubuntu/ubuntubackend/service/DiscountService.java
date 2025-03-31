package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.*;
import co.za.ubuntu.ubuntubackend.dto.BudgetDTO;
import co.za.ubuntu.ubuntubackend.dto.BudgetIncomeSplitDTO;

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
     * Retrieves a list of budgets associated with a user.
     *
     * @param accountId The unique identifier of the user.
     * @return A list of budgets associated with the user.
     */
    List<BudgetResponse> getUserBudgets(Integer accountId);

}

package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.BudgetResponse;
import co.za.ubuntu.model.User;
import co.za.ubuntu.ubuntubackend.dto.DiscountDTO;
import co.za.ubuntu.ubuntubackend.dto.GoalProgressDTO;
import co.za.ubuntu.ubuntubackend.persistence.entity.DiscountEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.UserRepository;
import co.za.ubuntu.ubuntubackend.service.DiscountService;
import co.za.ubuntu.ubuntubackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("discountService")
public class DiscountServiceImpl implements DiscountService {

    UserRepository userRepository;


    @Override
    public List<BudgetResponse> getUserBudgets(DiscountDTO discountDTO) {

        /**
         * Need to get all the budgetCategory and jointBudgetCategory linked to this user. A user
         * will have multiple budgets. Each budget then
         */



        return null;
    }

    @Override
    public List<DiscountDTO> getShortTermGoalDiscounts(DiscountDTO discountDTO) {

        /**
         * A DiscountDTO will have the budgetId, userId, goalId and the budgetCategoryId passed from the front end
         * and the back-end will use this info to fetch all discounts they are eligible for relating to that
         * category line item. The budgetId is used to identify which budget the goal is linked to. The userId
         * is used to fetch any specific user related details that may be required and the goalId is used to
         * identify which goal the category line item is linked to.
         */

        Integer budgetId = discountDTO.getBudgetId();
        Integer userId = discountDTO.getUserId();
        Integer budgetCategoryId = discountDTO.getBudgetCategoryId();

        //If its just a single user discount

        return null;
    }

    @Override
    public List<DiscountDTO> getLongTermGoalDiscounts(DiscountDTO discountDTO) {

        /**
         * A DiscountDTO will have the userId and goalId passed from the front end and the back-end
         * will use this info to fetch all discounts they are eligible for relating to that goal.
         */

        return null;
    }

    @Override
    public GoalProgressDTO getGoalProgress(Integer goalId) {
        return null;
    }
}

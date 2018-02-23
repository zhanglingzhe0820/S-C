package cn.s_c.blservice.food;

import cn.s_c.vo.ResultMessage;
import org.springframework.stereotype.Service;

@Service
public interface FoodBlService {

    /**
     * publish the foods
     *
     * @param supplierFoodIds the ids of foods to be published
     * @param maximum         the maximum of the supplier
     * @return whether the operation is success or not
     */
    ResultMessage publishFoods(int[] supplierFoodIds, double maximum);

    /**
     * shelf off the foods
     *
     * @param supplierUsername the username of the supplier
     * @return whether the operation is success or not
     */
    ResultMessage shelfOffFoods(String supplierUsername);
}

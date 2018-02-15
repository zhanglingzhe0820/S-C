package cn.s_c.bl.food;

import cn.s_c.blservice.food.FoodBlService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.FoodPublishVo;
import org.springframework.stereotype.Service;

@Service
public class FoodBlServiceImpl implements FoodBlService {
    /**
     * publish the foods
     *
     * @param foodPublishVos the foods to be published
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage publishFoods(FoodPublishVo[] foodPublishVos) {
        return null;
    }

    /**
     * shelf off the foods
     *
     * @param restaurantId the id of the restaurant
     * @param positionName the name of the position
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage shelfOffFoods(int restaurantId, String positionName) {
        return null;
    }
}

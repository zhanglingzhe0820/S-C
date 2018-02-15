package cn.s_c.blservice.food;

import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.FoodPublishVo;
import org.springframework.stereotype.Service;

@Service
public interface FoodBlService {

    /**
     * publish the foods
     *
     * @param foodPublishVos the foods to be published
     * @return whether the operation is success or not
     */
    ResultMessage publishFoods(FoodPublishVo[] foodPublishVos);
}

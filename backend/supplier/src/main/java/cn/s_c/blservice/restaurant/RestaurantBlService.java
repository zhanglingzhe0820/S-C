package cn.s_c.blservice.restaurant;

import cn.s_c.vo.restaurant.RestaurantReturnVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantBlService {
    /**
     * get the restaurant name and id
     *
     * @return the list of restaurant with id and name
     */
    List<RestaurantReturnVo> getRestaurantNameAndIdList();
}

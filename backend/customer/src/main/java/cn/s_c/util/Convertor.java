package cn.s_c.util;

import cn.s_c.entity.order.Order;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.vo.order.OrderReturnVo;
import cn.s_c.vo.order.OrderSaveVo;
import cn.s_c.vo.restaurant.RestaurantReturnVo;

public class Convertor {

    public static Order orderSaveVoToOrder(OrderSaveVo orderSaveVo) {
        return new Order(orderSaveVo.getWechatId(), orderSaveVo.getFoodList(), orderSaveVo.getCommodityTotal(), orderSaveVo.getServiceTotal(), false);
    }

    public static OrderReturnVo orderToOrderReturnVo(Order order) {
        return new OrderReturnVo(order.getId(), order.getWechatId(), order.getFoodList(), order.getCommodityTotal(), order.getServiceTotal(), order.isConfirmed());
    }

    public static RestaurantReturnVo restaurantToRestaurantReturnVo(Restaurant restaurant) {
        return new RestaurantReturnVo(restaurant.getId(), restaurant.getName(), restaurant.getTime());
    }
}

package cn.s_c.util;

import cn.s_c.entity.food.SupplierFood;
import cn.s_c.entity.order.Order;
import cn.s_c.entity.restaurant.Restaurant;
import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.food.SupplierFoodEditableReturnVo;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import cn.s_c.vo.food.SupplierFoodUpdateVo;
import cn.s_c.vo.order.*;
import cn.s_c.vo.restaurant.RestaurantReturnVo;
import cn.s_c.vo.restaurant.RestaurantSaveVo;
import cn.s_c.vo.supplier.SupplierSignUpVo;

public class Convertor {

    public static Order orderSaveVoToOrder(OrderSaveVo orderSaveVo) {
        return new Order(orderSaveVo.getWechatId(), orderSaveVo.getFoodList(), orderSaveVo.getCommodityTotal(), orderSaveVo.getServiceTotal(), orderSaveVo.getPickHour(), orderSaveVo.getPickMinute(), orderSaveVo.getComment(), false);
    }

    public static OrderReturnVo orderToOrderReturnVo(Order order) {
        return new OrderReturnVo(order.getId(), order.getWechatId(), order.getFoodList(), order.getCommodityTotal(), order.getServiceTotal(), order.getPickHour(), order.getPickMinute(), order.getComment(), order.isConfirmed());
    }

    public static RestaurantReturnVo restaurantToRestaurantReturnVo(Restaurant restaurant) {
        return new RestaurantReturnVo(restaurant.getId(), restaurant.getName(), restaurant.getTime());
    }

    public static Supplier supplierSignUpVoToSupplier(SupplierSignUpVo supplierSignUpVo) {
        return new Supplier(supplierSignUpVo.getName(), supplierSignUpVo.getUsername(), supplierSignUpVo.getPassword(), supplierSignUpVo.getRestaurantId(), null);
    }

    public static SupplierFood supplierFoodSaveVoToSupplierFood(SupplierFoodSaveVo supplierFoodSaveVo) {
        return new SupplierFood(supplierFoodSaveVo.getName(), supplierFoodSaveVo.getPrice(), supplierFoodSaveVo.getUrl(), supplierFoodSaveVo.isHasChoice(), supplierFoodSaveVo.getChoice(), supplierFoodSaveVo.getSupplier());
    }

    public static SupplierFoodReturnVo supplierFoodToSupplierFoodReturnVo(SupplierFood supplierFood) {
        return new SupplierFoodReturnVo(supplierFood.getId(), supplierFood.getName(), supplierFood.getPrice(), supplierFood.getUrl());
    }

    public static Restaurant restaurantSaveVoToRestaurant(RestaurantSaveVo restaurantSaveVo) {
        return new Restaurant(restaurantSaveVo.getName(), restaurantSaveVo.getTime(), null);
    }

    public static SupplierFoodEditableReturnVo supplierFoodToSupplierFoodEditableReturnVo(SupplierFood supplierFood) {
        return new SupplierFoodEditableReturnVo(supplierFood.getId(), supplierFood.getName(), supplierFood.getPrice(), supplierFood.getUrl(), supplierFood.isHasChoice(), supplierFood.getChoice());
    }

    public static SupplierFood supplierFoodUpdateVoToSupplierFood(SupplierFoodUpdateVo supplierFoodUpdateVo) {
        SupplierFood supplierFood = new SupplierFood(supplierFoodUpdateVo.getName(), supplierFoodUpdateVo.getPrice(), supplierFoodUpdateVo.getUrl(), supplierFoodUpdateVo.isHasChoice(), supplierFoodUpdateVo.getChoice(), supplierFoodUpdateVo.getSupplier());
        supplierFood.setId(supplierFoodUpdateVo.getId());
        return supplierFood;
    }

    public static OrderListResponse[] orderListsToOrderListResponses(OrderList[] orderLists) {
        OrderListResponse[] orderListResponses = new OrderListResponse[orderLists.length];
        for (int i = 0; i < orderLists.length; i++) {
            OrderFood[] orderFoods = orderLists[i].getOrderFoodList().toArray(new OrderFood[orderLists[i].getOrderFoodList().size()]);
            orderListResponses[i] = new OrderListResponse(orderLists[i].getStartTime(), orderLists[i].getEndTime(), orderFoods);
        }
        return orderListResponses;
    }
}

package cn.s_c.util;

import cn.s_c.blservice.supplier.SupplierBlService;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import cn.s_c.vo.supplier.SupplierSignUpVo;
import org.springframework.beans.factory.annotation.Autowired;

public class Convertor {
    public static Supplier supplierSignUpVoToSupplier(SupplierSignUpVo supplierSignUpVo) {
        return new Supplier(supplierSignUpVo.getName(), supplierSignUpVo.getUsername(), supplierSignUpVo.getPassword(), supplierSignUpVo.getRestaurantId(), null);
    }

    public static SupplierFood supplierFoodSaveVoToSupplierFood(SupplierFoodSaveVo supplierFoodSaveVo) {
        return new SupplierFood(supplierFoodSaveVo.getName(), supplierFoodSaveVo.getPrice(), supplierFoodSaveVo.getUrl(), supplierFoodSaveVo.isHasChoice(), supplierFoodSaveVo.getChoice(), supplierFoodSaveVo.getSupplier());
    }

    public static SupplierFoodReturnVo supplierFoodToSupplierFoodReturnVo(SupplierFood supplierFood) {
        return new SupplierFoodReturnVo(supplierFood.getId(), supplierFood.getName(), supplierFood.getPrice(), supplierFood.getUrl());
    }
}

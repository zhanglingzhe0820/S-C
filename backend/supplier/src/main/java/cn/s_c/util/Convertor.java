package cn.s_c.util;

import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.supplier.SupplierSignUpVo;

public class Convertor {

    public static Supplier supplierSignUpVoToSupplier(SupplierSignUpVo supplierSignUpVo) {
        return new Supplier(supplierSignUpVo.getName(), supplierSignUpVo.getUsername(), supplierSignUpVo.getPassword(), supplierSignUpVo.getRestaurantId());
    }
}

package cn.s_c.blservice.food;

import cn.s_c.entity.food.SupplierFood;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.SupplierFoodSaveVo;

import java.util.Set;

public interface SupplierFoodBlService {

    /**
     * upload image to cloud
     *
     * @param bytes the image
     * @return the uri of the uploaded image
     */
    String uploadImage(byte[] bytes);

    /**
     * save the food
     *
     * @param supplierFoodSaveVo the supplierFoodSave object
     * @return whether the operation is success or not
     */
    ResultMessage saveFood(SupplierFoodSaveVo supplierFoodSaveVo);

    /**
     * get all the supplier food by the supplier
     *
     * @param supplierId the id of the supplier
     * @return the set of supplier food
     */
    Set<SupplierFood> getSupplierFoodBySupplierId(int supplierId);

    /**
     * delete the food
     *
     * @param foodId the id of the food to be deleted
     * @return whether the operation is success or not
     */
    ResultMessage deleteFood(int foodId);
}

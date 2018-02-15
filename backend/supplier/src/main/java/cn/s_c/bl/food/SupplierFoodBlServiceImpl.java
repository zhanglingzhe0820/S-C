package cn.s_c.bl.food;

import cn.s_c.blservice.food.SupplierFoodBlService;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SupplierFoodBlServiceImpl implements SupplierFoodBlService {
    /**
     * upload image to cloud
     *
     * @param bytes the image
     * @return the uri of the uploaded image
     */
    @Override
    public String uploadImage(byte[] bytes) {
        return null;
    }

    /**
     * save the food
     *
     * @param supplierFoodSaveVo the supplierFoodSave object
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveSupplierFood(SupplierFoodSaveVo supplierFoodSaveVo) {
        return null;
    }

    /**
     * get all the supplier food by the supplier
     *
     * @param supplierId the id of the supplier
     * @return the set of supplier food
     */
    @Override
    public List<SupplierFoodReturnVo> getSupplierFoodBySupplierId(int supplierId) {
        return null;
    }

    /**
     * delete the food
     *
     * @param foodId the id of the food to be deleted
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteSupplierFood(int foodId) {
        return null;
    }
}

package cn.s_c.blservice.food;

import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
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
    ResultMessage saveSupplierFood(SupplierFoodSaveVo supplierFoodSaveVo);

    /**
     * get all the supplier food by the supplier
     *
     * @param supplierUsername the username of the supplier
     * @return the set of supplier food
     */
    SupplierFoodReturnVo[] getSupplierFoodBySupplierUsername(String supplierUsername);

    /**
     * delete the food
     *
     * @param foodId the id of the food to be deleted
     * @return whether the operation is success or not
     */
    ResultMessage deleteSupplierFood(int foodId);
}

package cn.s_c.data.food;

import cn.s_c.dataservice.food.SupplierFoodDataService;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.vo.ResultMessage;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SupplierFoodDataServiceImpl implements SupplierFoodDataService{
    /**
     * upload the image to the cloud
     *
     * @param bytes the image data
     * @return the url of the uploaded image
     */
    @Override
    public String uploadImageToCloud(byte[] bytes) {
        return null;
    }

    /**
     * save the supplier food to the database
     *
     * @param supplierFood the supplier food
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveSupplierFood(SupplierFood supplierFood) {
        return null;
    }

    /**
     * get the supplier foods by supplier
     *
     * @param supplierId the id of the supplier
     * @return the supplier food set
     */
    @Override
    public Set<SupplierFood> getSupplierFoodBySupplierId(int supplierId) {
        return null;
    }

    /**
     * delete the supplier food by its id
     *
     * @param foodId the id of the supplier food
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteSupplierFood(int foodId) {
        return null;
    }
}

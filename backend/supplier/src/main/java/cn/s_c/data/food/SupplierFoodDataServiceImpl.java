package cn.s_c.data.food;

import cn.s_c.data.dao.food.SupplierFoodDao;
import cn.s_c.data.dao.supplier.SupplierDao;
import cn.s_c.dataservice.food.SupplierFoodDataService;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SupplierFoodDataServiceImpl implements SupplierFoodDataService {
    @Autowired
    private SupplierFoodDao supplierFoodDao;
    @Autowired
    private SupplierDao supplierDao;

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
        if (supplierFoodDao.save(supplierFood) != null) {
            return ResultMessage.Success;
        } else {
            return ResultMessage.SystemError;
        }
    }

    /**
     * get the supplier foods by supplier
     *
     * @param supplierId the id of the supplier
     * @return the supplier food set
     */
    @Override
    public Set<SupplierFood> getSupplierFoodBySupplierId(int supplierId) {
        return supplierDao.findOne(supplierId).getSupplierFoodSet();
    }

    /**
     * delete the supplier food by its id
     *
     * @param foodId the id of the supplier food
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteSupplierFood(int foodId) {
        try {
            supplierFoodDao.delete(foodId);
            return ResultMessage.Success;
        } catch (Exception e) {
            return ResultMessage.SystemError;
        }
    }
}

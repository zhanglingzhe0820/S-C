package cn.s_c.bl.food;

import cn.s_c.blservice.food.SupplierFoodBlService;
import cn.s_c.dataservice.food.SupplierFoodDataService;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.util.Convertor;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.food.SupplierFoodReturnVo;
import cn.s_c.vo.food.SupplierFoodSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SupplierFoodBlServiceImpl implements SupplierFoodBlService {
    @Autowired
    private SupplierFoodDataService supplierFoodDataService;

    /**
     * upload image to cloud
     *
     * @param bytes the image
     * @return the uri of the uploaded image
     */
    @Override
    public String uploadImage(byte[] bytes) {
        return supplierFoodDataService.uploadImageToCloud(bytes);
    }

    /**
     * save the food
     *
     * @param supplierFoodSaveVo the supplierFoodSave object
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveSupplierFood(SupplierFoodSaveVo supplierFoodSaveVo) {
        return supplierFoodDataService.saveSupplierFood(Convertor.supplierFoodSaveVoToSupplierFood(supplierFoodSaveVo));
    }

    /**
     * get all the supplier food by the supplier
     *
     * @param supplierId the id of the supplier
     * @return the set of supplier food
     */
    @Override
    public List<SupplierFoodReturnVo> getSupplierFoodBySupplierId(int supplierId) {
        Set<SupplierFood> supplierFoodSet = supplierFoodDataService.getSupplierFoodBySupplierId(supplierId);
        List<SupplierFoodReturnVo> supplierFoodReturnVoList = new ArrayList<>();
        for (SupplierFood supplierFood : supplierFoodSet) {
            supplierFoodReturnVoList.add(Convertor.supplierFoodToSupplierFoodReturnVo(supplierFood));
        }
        return supplierFoodReturnVoList;
    }

    /**
     * delete the food
     *
     * @param foodId the id of the food to be deleted
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage deleteSupplierFood(int foodId) {
        return supplierFoodDataService.deleteSupplierFood(foodId);
    }
}

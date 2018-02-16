package cn.s_c.data.food;

import cn.s_c.data.dao.food.SupplierFoodDao;
import cn.s_c.data.dao.supplier.SupplierDao;
import cn.s_c.dataservice.food.SupplierFoodDataService;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.vo.ResultMessage;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static javax.crypto.Cipher.SECRET_KEY;

@Service
public class SupplierFoodDataServiceImpl implements SupplierFoodDataService {
    private static String END_POINT = "http://oos-bj2.ctyunapi.cn";
    private static String BUCKET_NAME = "S&C";
    private static String ACCESS_KEY = "c4582dec5d0809103126";
    private static String SECRET_KEY = "47c783687d4c452c5d71b817b8c481915fb0094a";

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
        try {
            AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
            AmazonS3 oos = new AmazonS3Client(credentials);
            oos.setEndpoint(END_POINT);
            oos.putObject(BUCKET_NAME, file);
            return ResultMessage.Success;
        } catch (Exception e) {
            return "";
        }
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

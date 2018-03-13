package cn.s_c.data.food;

import cn.s_c.MainApplication;
import cn.s_c.data.dao.food.SupplierFoodDao;
import cn.s_c.data.dao.supplier.SupplierDao;
import cn.s_c.dataservice.food.SupplierFoodDataService;
import cn.s_c.entity.food.SupplierFood;
import cn.s_c.vo.ResultMessage;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Set;

@Service
public class SupplierFoodDataServiceImpl implements SupplierFoodDataService {
    private static final String END_POINT = "http://oos-bj2.ctyunapi.cn";
    private static final String BUCKET_NAME = "s-c";
    private static final String ACCESS_KEY = "c4582dec5d0809103126";
    private static final String SECRET_KEY = "47c783687d4c452c5d71b817b8c481915fb0094a";
    private static final long EXPIRATION =
            new Date().getTime() + 1000 * 60 * 60 * 24 * 100;
    private static final String FILE_PATH = (MainApplication.class.getResource("") + "/temp/temp.jpeg").substring(5);

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
            //保存到临时文件
            File file = new File(FILE_PATH);
            FileImageOutputStream fileWriter = new FileImageOutputStream(file);
            fileWriter.write(bytes);
            fileWriter.close();

            //MD5根据图片信息生成图片名称
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(bytes);
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            StringBuilder imageName = new StringBuilder(bigInt.toString(16));
            while (imageName.length() < 32) {
                imageName.insert(0, "0");
            }
            for (int i = 0; i < 10; i++) {
                imageName.append(Math.floor(Math.random() * 10));
            }

            //上传图片
            AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
            AmazonS3 oos = new AmazonS3Client(credentials);
            oos.setEndpoint(END_POINT);
            oos.putObject(BUCKET_NAME, imageName.toString(), file);

            //生成共享地址
            GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(BUCKET_NAME, imageName.toString());
            generatePresignedUrlRequest.setExpiration(new Date(EXPIRATION));
            URL url = oos.generatePresignedUrl(generatePresignedUrlRequest);
            return url.toURI().toString();
        } catch (Exception e) {
            e.printStackTrace();
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
     * @param supplierUsername the id of the supplier
     * @return the supplier food set
     */
    @Override
    public Set<SupplierFood> getSupplierFoodBySupplierUsername(String supplierUsername) {
        return supplierDao.findSupplierByUsername(supplierUsername).getSupplierFoodSet();
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
            SupplierFood supplierFood = supplierFoodDao.findOne(foodId);
            AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
            AmazonS3 oos = new AmazonS3Client(credentials);
            oos.setEndpoint(END_POINT);
            oos.deleteObject(BUCKET_NAME, supplierFood.getUrl().split("/")[0].split("/?")[0]);
            supplierFoodDao.delete(foodId);
            return ResultMessage.Success;
        } catch (Exception e) {
            return ResultMessage.SystemError;
        }
    }

    /**
     * get the supplier food by its id
     *
     * @param supplierFoodId the id of the supplier food
     * @return the supplier food object
     */
    @Override
    public SupplierFood getSupplierFoodById(int supplierFoodId) {
        return supplierFoodDao.findOne(supplierFoodId);
    }

    /**
     * update the supplier food
     *
     * @param supplierFood the to be updated supplier fodd
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage updateSupplierFood(SupplierFood supplierFood) {
        if (supplierFoodDao.save(supplierFood) != null) {
            return ResultMessage.Success;
        } else {
            return ResultMessage.SystemError;
        }
    }
}

package cn.s_c.dataservice.suppiler;

import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.ResultMessage;
import org.springframework.stereotype.Service;

@Service
public interface SupplierDataService {

    /**
     * save the supplier
     *
     * @param supplier the supplier entity
     * @return whether the operation is success or not
     */
    ResultMessage saveSupplierInfo(Supplier supplier);

    /**
     * is the username existed
     *
     * @param username username of the supplier
     * @return whether the operation is success or not
     */
    boolean isUsernameExisted(String username);

    /**
     * get the password by the username
     *
     * @param username username of the supplier
     * @return the password of the username(null when system wrong)
     */
    String getPasswordByUsername(String username);

    /**
     * get the supplier object by username
     *
     * @param supplierUsername the username of supplier
     * @return the return supplier object
     */
    Supplier getSupplierByUsername(String supplierUsername);
}

package cn.s_c.data.supplier;

import cn.s_c.data.dao.supplier.SupplierDao;
import cn.s_c.dataservice.suppiler.SupplierDataService;
import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierDataServiceImpl implements SupplierDataService {
    @Autowired
    private SupplierDao supplierDao;

    /**
     * save the supplier
     *
     * @param supplier the supplier entity
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage saveSupplierInfo(Supplier supplier) {
        if (supplierDao.save(supplier) != null) {
            return ResultMessage.Success;
        } else {
            return ResultMessage.SystemError;
        }
    }

    /**
     * is the username existed
     *
     * @param username username of the supplier
     * @return whether the operation is success or not
     */
    @Override
    public boolean isUsernameExisted(String username) {
        if (supplierDao.findSupplierByUsername(username) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * get the password by the username
     *
     * @param username username of the supplier
     * @return the password of the username(null when system wrong)
     */
    @Override
    public String getPasswordByUsername(String username) {
        Supplier supplier = supplierDao.findSupplierByUsername(username);
        if (supplier != null) {
            return supplier.getPassword();
        } else {
            return null;
        }
    }

    /**
     * get the supplier object by id
     *
     * @param supplierId the if of supplier
     * @return the return supplier object
     */
    @Override
    public Supplier getSupplierById(int supplierId) {
        return supplierDao.findOne(supplierId);
    }
}

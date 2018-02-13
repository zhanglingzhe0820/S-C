package cn.s_c.blservice.supplier;

import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.supplier.SupplierLoginVo;
import cn.s_c.vo.supplier.SupplierSignUpVo;
import org.springframework.stereotype.Service;

@Service
public interface SupplierBlService {

    /**
     * for supplier to log in
     *
     * @param supplierLoginVo the username and password of the supplier
     * @return whether the operation is success or not
     */
    ResultMessage login(SupplierLoginVo supplierLoginVo);

    /**
     * for supplier to sign up
     *
     * @param supplierSignUpVo the sign up information of the supplier
     * @return whether the operation is success or not
     */
    ResultMessage signUp(SupplierSignUpVo supplierSignUpVo);
}

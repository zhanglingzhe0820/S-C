package cn.s_c.blservice.supplier;

import cn.s_c.entity.supplier.Supplier;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.supplier.SupplierLoginVo;
import org.springframework.stereotype.Service;

@Service
public interface SupplierBlService {

    ResultMessage login(SupplierLoginVo supplierLoginVo);
}

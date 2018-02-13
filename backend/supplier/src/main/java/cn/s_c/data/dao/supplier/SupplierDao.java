package cn.s_c.data.dao.supplier;

import cn.s_c.entity.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierDao extends JpaRepository<Supplier, String> {

    List<Supplier> findUsersByNumber(String number);
}

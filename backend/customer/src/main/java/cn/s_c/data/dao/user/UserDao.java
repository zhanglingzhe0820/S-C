package cn.s_c.data.dao.user;

import cn.s_c.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {
}

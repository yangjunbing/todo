package projects.bing.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import projects.bing.entity.AdminUser;
import projects.bing.entity.AdminUser;

/**
 * Created by yang on 2017/2/19.
 */
public interface AdminUserDao extends BaseDao<AdminUser> {
    AdminUser validate(@Param("account")String account);
}

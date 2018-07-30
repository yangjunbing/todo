package projects.bing.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import projects.bing.entity.Admin;

/**
 * Created by yang on 2017/2/19.
 */
public interface AdminDao extends BaseDao<Admin> {
    Admin validate(@Param("account")String account);
}

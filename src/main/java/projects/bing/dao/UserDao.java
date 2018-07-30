package projects.bing.dao;

import org.apache.ibatis.annotations.Param;
import projects.bing.entity.User;

/**
 * Created by yang on 2017/3/28.
 */
public interface UserDao extends BaseDao<User> {
    public User getByWxid(String wxid);

    void updateTableNum(@Param("rightNow") String rightNow,@Param("tableNumber") String tableNumber);
}

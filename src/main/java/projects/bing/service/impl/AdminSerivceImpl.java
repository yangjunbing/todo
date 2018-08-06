package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.AdminUserDao;
import projects.bing.entity.AdminUser;
import projects.bing.service.AdminService;
import projects.bing.utils.MapUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yang on 2017/2/19.
 */
@Service
public class AdminSerivceImpl implements AdminService {
    @Autowired
    private AdminUserDao adminUserDao;

    //登录验证
    @Override
    public AdminUser validate(String account) {
        return adminUserDao.validate(account);
    }
    //添加用户
    @Override
    public int add(AdminUser admin) {
        admin.setId(UUID.randomUUID().toString());
        return adminUserDao.add(admin);
    }

    //删除用户
    @Override
    public int delete(String id) {
        return adminUserDao.delete(id);
    }

    //更新
    @Override
    public int update(AdminUser admin) {
        return adminUserDao.update(admin);
    }

    //查询一个
    @Override
    public AdminUser getOne(String id) {
        return adminUserDao.getOne(id);
    }

    //获得所有
    @Override
    public List<AdminUser> getAll() {
        List<AdminUser> adminList = adminUserDao.getAll();
        Map<String,String> map = MapUtils.getRoleMap();
        //循环将数字转变为角色名称
        for (AdminUser admin: adminList) {
            admin.setTemp1(map.get(admin.getRole()+"")); //加上引号查找String类型的key 而不是integer
        }
        return adminList;
    }
}

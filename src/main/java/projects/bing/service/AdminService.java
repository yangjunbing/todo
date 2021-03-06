package projects.bing.service;

import org.springframework.stereotype.Service;
import projects.bing.entity.AdminUser;
import projects.bing.entity.AdminUser;

/**
 * Created by yang on 2017/2/19.
 */
@Service
public interface AdminService extends BaseService<AdminUser> {
    AdminUser validate(String account);
}

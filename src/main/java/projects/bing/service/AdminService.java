package projects.bing.service;

import org.springframework.stereotype.Service;
import projects.bing.entity.Admin;

/**
 * Created by yang on 2017/2/19.
 */
@Service
public interface AdminService extends BaseService<Admin> {
    Admin validate(String account);
}

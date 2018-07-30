package projects.bing.service;

import org.springframework.stereotype.Service;
import projects.bing.entity.User;
import projects.bing.service.BaseService;

/**
 * Created by yang on 2017/3/28.
 */
@Service
public interface UserService extends BaseService<User> {

    String saveUserAndGetNum(String nickname, String queueid);
}

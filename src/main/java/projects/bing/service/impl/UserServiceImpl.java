package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.UserDao;
import projects.bing.entity.Queues;
import projects.bing.entity.User;
import projects.bing.service.QueuesService;
import projects.bing.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by yang on 2017/3/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private QueuesService queuesService;

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int delete(String id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User getOne(String id) {
        return userDao.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public String saveUserAndGetNum(String nickname, String queueid) {
        //查queue get tail  ， update tail++
        //查询用户是否存在  y 拿到User update set num  , n insert User 。
        Queues queue = queuesService.getOne(queueid);
        int  beforeNum = queue.getTail();
        int afterNum = ++beforeNum;
        queue.setTail(afterNum+"");
        User user = userDao.getByWxid(nickname);
        if(user == null){
            user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setWxid(nickname);
            user.setNickname(nickname);
            user.setMynumber(afterNum);
            user.setNumberTime(new Date());
            userDao.add(user);
        }else{
            user.setMynumber(afterNum);
            user.setNumberTime(new Date());
            userDao.update(user);
        }
        queuesService.update(queue);
        return queue.getTail()+"";
    }

}

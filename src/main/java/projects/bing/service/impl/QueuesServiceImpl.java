package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.QueuesDao;
import projects.bing.dao.UserDao;
import projects.bing.entity.Queues;
import projects.bing.service.QueuesService;

import java.util.List;
import java.util.UUID;

/**
 * Created by yang on 2017/2/25.
 */
@Service
public class QueuesServiceImpl implements QueuesService {
    @Autowired
    private QueuesDao queuesDao;
    @Autowired
    private UserDao userDao;
    @Override
    public int add(Queues queues) {
        queues.setId(UUID.randomUUID().toString());
        return queuesDao.add(queues);
    }

    @Override
    public int delete(String id) {
        return queuesDao.delete(id);
    }

    @Override
    public int update(Queues queues) {
        return queuesDao.update(queues);
    }

    @Override
    public Queues getOne(String id) {
        return queuesDao.getOne(id);
    }

    @Override
    public List<Queues> getAll() {
        return queuesDao.getAll();
    }

    @Override
    public int updateStatus(String id) {
        return queuesDao.updateStatus(id);
    }

    @Override
    public int setZero(String id) {
        return queuesDao.setZero(id);
    }

    @Override
    public List<Queues> getAllOpen() {
        return queuesDao.getAllOpen();
    }

    @Override
    public boolean callNum(String qid, String rightNow, String tableNum) {
        //根据当前号数把座位号给user temp1
        //r = r+1 根据idq
        queuesDao.callNumber(qid);
        userDao.updateTableNum(rightNow,tableNum);
        return true;
    }
}

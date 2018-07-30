package projects.bing.dao;


import projects.bing.entity.Queues;

import java.util.List;

/**
 * Created by yang on 2017/2/25.
 */
public interface QueuesDao extends  BaseDao<Queues> {
    int updateStatus(String id);

    int setZero(String id);

    List<Queues> getAllOpen();

    void callNumber(String qid);
}

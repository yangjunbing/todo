package projects.bing.service;

import org.springframework.stereotype.Service;
import projects.bing.entity.Queues;

import java.util.List;

/**
 * Created by yang on 2017/2/25.
 */
@Service
public interface QueuesService extends  BaseService<Queues>{

    int updateStatus(String id);

    int setZero(String id);

    List<Queues> getAllOpen();

    boolean callNum(String qid, String rightNow, String tableNum);
}

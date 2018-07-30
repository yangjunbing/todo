package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.OrderDao;
import projects.bing.entity.Orders;
import projects.bing.service.OrderService;

import java.util.List;

/**
 * Created by yang on 2017/4/22.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public int add(Orders order) {
        return orderDao.add(order);
    }

    @Override
    public int delete(String id) {
        return orderDao.delete(id);
    }

    @Override
    public int update(Orders order) {
        return orderDao.update(order);
    }

    @Override
    public Orders getOne(String id) {
        return orderDao.getOne(id);
    }

    @Override
    public List<Orders> getAll() {
        return orderDao.getAll();
    }
}

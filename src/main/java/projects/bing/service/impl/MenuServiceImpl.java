package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.MenuDao;
import projects.bing.entity.Foods;
import projects.bing.entity.ParamEntity;
import projects.bing.service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by yang on 2017/2/26.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public int add(Foods foods) {
        foods.setId(UUID.randomUUID().toString());
        return menuDao.add(foods);
    }

    @Override
    public int delete(String id) {
        return menuDao.delete(id);
    }

    @Override
    public int update(Foods foods) {
        return menuDao.update(foods);
    }

    @Override
    public Foods getOne(String id) {
        return menuDao.getOne(id);
    }

    @Override
    public List<Foods> getAll() {
        return menuDao.getAll();
    }

    @Override
    public List<Foods> getByIds(List<ParamEntity> list) {
        List<Foods> orderList = new ArrayList<Foods>();
        if(list==null || list.size()<1){
            return  orderList;
        }
        for (ParamEntity param : list){
            Foods foods= menuDao.getOne(param.getId());
            orderList.add(foods);
        }
        double price = 0;
        for(Foods food : orderList){
             price += food.getPrice();
        }
        orderList.get(0).setTemp1(price+"");
        return orderList;
    }
}

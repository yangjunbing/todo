package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.MenuDao;
import projects.bing.entity.Menu;
import projects.bing.service.MenuService;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public int add(Menu menu) {
        return menuDao.add(menu);
    }

    @Override
    public int delete(String id) {
        return menuDao.delete(id);
    }

    @Override
    public int update(Menu menu) {
        return menuDao.update(menu);
    }

    @Override
    public Menu getOne(String id) {
        return menuDao.getOne(id);
    }

    @Override
    public List<Menu> getAll() {
        return menuDao.getAll();
    }
}

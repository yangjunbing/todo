package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.dao.ThemeDao;
import projects.bing.entity.Theme;
import projects.bing.service.ThemeService;

import java.util.List;
@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeDao themeDao;

    @Override
    public int add(Theme theme) {
        return themeDao.add(theme);
    }

    @Override
    public int delete(String id) {
        return themeDao.delete(id);
    }

    @Override
    public int update(Theme theme) {
        return themeDao.update(theme);
    }

    @Override
    public Theme getOne(String id) {
        return themeDao.getOne(id);
    }

    @Override
    public List<Theme> getAll() {
        return themeDao.getAll();
    }
}

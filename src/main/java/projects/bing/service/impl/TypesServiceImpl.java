package projects.bing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.bing.entity.Types;
import projects.bing.service.TypesService;

import java.util.List;
import java.util.UUID;

import projects.bing.dao.TypesDao;
/**
 * Created by yang on 2017/2/25.
 */
@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesDao typesDao;
    @Override
    public int add(Types types) {
        types.setId(UUID.randomUUID().toString());
        return typesDao.add(types);
    }

    @Override
    public int delete(String id) {
        return typesDao.delete(id);
    }

    @Override
    public int update(Types types) {
        return typesDao.update(types);
    }

    @Override
    public Types getOne(String id) {
        return typesDao.getOne(id);
    }

    @Override
    public List<Types> getAll() {
        return typesDao.getAll();
    }
}

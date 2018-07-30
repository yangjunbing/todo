package projects.bing.service;

import org.springframework.stereotype.Service;
import projects.bing.entity.Foods;
import projects.bing.entity.ParamEntity;

import java.util.List;

/**
 * Created by yang on 2017/2/26.
 */
@Service
public interface MenuService extends BaseService<Foods>{
    List<Foods> getByIds(List<ParamEntity> list);
}

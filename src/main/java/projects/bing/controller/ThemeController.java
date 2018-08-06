
package projects.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.bing.dto.JsonResult;
import projects.bing.entity.Menu;
import projects.bing.entity.Theme;
import projects.bing.entity.Types;
import projects.bing.service.MenuService;
import projects.bing.service.ThemeService;
import projects.bing.service.TypesService;
import projects.bing.utils.IdGen;

import java.util.List;

/**
 * Created by yang on 2017/2/25.
 */

@Controller
@RequestMapping(value = "/theme" )
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private TypesService typesService;

    @RequestMapping(value = "manage")
    public String typesForm(Model model){
        List<Theme> themeList = themeService.getAll();
        model.addAttribute("themeList",themeList);
        List<Menu> menus = menuService.getAll();
        model.addAttribute("menus",menus);
        List<Types> typesList = typesService.getAll();
        model.addAttribute("typesList",typesList);
        return "themeForm";
    }

    //新增或保存
    @RequestMapping(value="saveOrEdit" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult saveOrEdit(Theme theme){
        JsonResult jr ;
        String message = null;
        boolean flag = false;
        if("".equals(theme.getId())){  //新增
            theme.setId(IdGen.getUUID32());
            flag = themeService.add(theme) > 0  ? true : false;
            message = "添加成功↖(^ω^)↗";
        }else{
            flag = themeService.update(theme) > 0 ? true : false;
            message = "修改成功↖(^ω^)↗";
        }
        if(flag == false){
            message = "系统异常，请稍后重试！";
        }
        jr = new JsonResult(flag,message);
        return jr;
    }

    //根据id查询
    @RequestMapping(value="getOne" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult getOne(String id){
        JsonResult jr ;
        boolean flag = true;
        Theme types = themeService.getOne(id);
        jr = new JsonResult(flag,types);
        return jr;
    }

    //删除
    @RequestMapping(value="delete" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult delete(String id){
        JsonResult jr ;
        boolean flag = false;
        flag = themeService.delete(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }
}


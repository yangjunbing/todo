package projects.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.bing.dto.JsonResult;
import projects.bing.entity.Foods;
import projects.bing.entity.Types;
import projects.bing.service.MenuService;
import projects.bing.service.TypesService;

import java.util.List;

/**
 * Created by yang on 2017/2/26.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private TypesService typesService;

    //跳转
    @RequestMapping(value = "menuForm")
    public String menuForm(Model model){
        List<Foods> menuList = menuService.getAll();
        List<Types> typesList = typesService.getAll();
        model.addAttribute("menuList",menuList);
        model.addAttribute("typesList",typesList);
        return "menuForm";
    }

    //新增或修改
    @RequestMapping(value="addOrEdit" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult saveOrEdit(Foods food){
        JsonResult jr ;
        String message = null;
        boolean flag = false;
        if("".equals(food.getId())){  //新增
            flag = menuService.add(food) > 0  ? true : false;
            message = "添加成功！";
        }else{
            flag = menuService.update(food) > 0 ? true : false;
            message = "修改成功！";
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
        Foods food = menuService.getOne(id);
        jr = new JsonResult(flag,food);
        return jr;
    }

    //删除
    @RequestMapping(value="delete" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult delete(String id){
        JsonResult jr ;
        boolean flag = false;
        flag = menuService.delete(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }
}

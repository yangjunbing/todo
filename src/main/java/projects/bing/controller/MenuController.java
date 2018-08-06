package projects.bing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.bing.dto.JsonResult;
import projects.bing.entity.AdminUser;
import projects.bing.entity.Menu;
import projects.bing.service.MenuService;
import projects.bing.utils.IdGen;

import java.util.List;

@Controller
@RequestMapping(value = "/menu")
public class MenuController  {

    @Autowired
    private MenuService menuService;


    @RequestMapping(value = "manage")
    public  String manage(Model model){
        List<Menu> list = menuService.getAll();
        model.addAttribute("list" , list);
        return  "menuForm";
    }

    //根据id查询
    @RequestMapping(value="getOne" , method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult getOne(String id){
        JsonResult jr ;
        boolean flag = true;
        Menu admin = menuService.getOne(id);
        jr = new JsonResult(flag,admin);
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


    @RequestMapping(value="saveOrUpdate" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult saveOrUpdate(Menu menu){
        JsonResult jr ;
        String message = null;
        boolean flag = false;
        if("".equals(menu.getId())){  //新增
            menu.setId(IdGen.getUUID32());
            flag = menuService.add(menu) > 0  ? true : false;
            message = "添加成功↖(^ω^)↗";
        }else{
            flag = menuService.update(menu) > 0 ? true : false;
            message = "修改成功↖(^ω^)↗";
        }
        if(flag == false){
            message = "系统异常，请稍后重试！";
        }
        jr = new JsonResult(flag,message);
        return jr;
    }
}

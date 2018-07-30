package projects.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.bing.dto.JsonResult;
import projects.bing.entity.Admin;
import projects.bing.service.TypesService;
import  projects.bing.entity.Types;
import java.util.List;
/**
 * Created by yang on 2017/2/25.
 */
@Controller
@RequestMapping(value = "/types" )
public class TypesController {
    @Autowired
    private TypesService typesService;

    @RequestMapping(value = "typesForm")
    public String typesForm(Model model){
        List<Types> typesList = typesService.getAll();
        model.addAttribute("typesList",typesList);
        return "typesForm";
    }

    //新增或保存
    @RequestMapping(value="addOrEdit" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult saveOrEdit(Types types){
        JsonResult jr ;
        String message = null;
        boolean flag = false;
        if("".equals(types.getId())){  //新增
            flag = typesService.add(types) > 0  ? true : false;
            message = "添加成功↖(^ω^)↗";
        }else{
            flag = typesService.update(types) > 0 ? true : false;
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
        Types types = typesService.getOne(id);
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
        flag = typesService.delete(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }
}

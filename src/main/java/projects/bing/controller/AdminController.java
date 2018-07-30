package projects.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import projects.bing.dto.JsonResult;
import projects.bing.entity.Admin;
import projects.bing.entity.Queues;
import projects.bing.service.AdminService;
import projects.bing.service.QueuesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yang on 2017/2/19.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private QueuesService  queuesService;
    //验证账号密码  根据角色跳转到对应页面
    @RequestMapping(value="index")
    public ModelAndView validate(Admin admin, HttpSession httpSession){
        String view;
        ModelAndView mv =new ModelAndView();
        mv.addObject("admin",admin);//用于回显
        Admin a = adminService.validate(admin.getAccount());
        if(a==null){
            mv.addObject("message","用户名不存在！");
             view = "adminLogin";
        }else{
            if(a.getPassword().equals(admin.getPassword())){
                httpSession.setAttribute("admin",a);
                view = "index";
                if(a.getRole()==1){
                    List<Queues>  queues =  queuesService.getAll();
                    mv.addObject("queuesList",queues);
                    view = "callNumber";
                }
            }else{
                mv.addObject("message","密码错误，请重试！");
                view = "adminLogin";
            }
        }
        mv.setViewName(view);
        return mv;
    }

    //新增或保存
    @RequestMapping(value="addOrEdit" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult saveOrEdit(Admin admin){
        JsonResult jr ;
        String message = null;
        boolean flag = false;
        if("".equals(admin.getId())){  //新增
             flag = adminService.add(admin) > 0  ? true : false;
             message = "添加成功↖(^ω^)↗";
        }else{
             flag = adminService.update(admin) > 0 ? true : false;
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
        Admin admin = adminService.getOne(id);
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
        flag = adminService.delete(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }


    //跳转到登录页面
    @RequestMapping(value = "login")
    public String toAdminLogin(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return "adminLogin";
    }

    //跳转到管理员用户管理页面
    @RequestMapping(value = "adminForm")
    public String toAdminForm(Model model){
        List<Admin>  adminList = adminService.getAll();
        model.addAttribute("adminList",adminList);
        return "adminForm";
    }

    //跳转到控制台页面
    @RequestMapping(value = "index1")
    public String toIndex(){
        return "index";
    }
}

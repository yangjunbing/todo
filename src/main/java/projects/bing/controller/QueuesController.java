package projects.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.bing.dto.JsonResult;
import projects.bing.entity.Queues;
import projects.bing.entity.Types;
import projects.bing.service.QueuesService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yang on 2017/2/25.
 */
@Controller
@RequestMapping(value = "/queues")
public class QueuesController {
    @Autowired
    private QueuesService queuesService;
    //跳转
    @RequestMapping(value = "queuesForm")
    public String getAll(Model model){
        List<Queues> queuesList = queuesService.getAll();
        model.addAttribute("queuesList",queuesList);
        return "queuesForm";
    }

    //新增或修改
    @RequestMapping(value="addOrEdit" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult saveOrEdit(Queues queues){
        JsonResult jr ;
        String message = null;
        boolean flag = false;
        if("".equals(queues.getId())){  //新增
            flag = queuesService.add(queues) > 0  ? true : false;
            message = "添加成功↖(^ω^)↗";
        }else{
            flag = queuesService.update(queues) > 0 ? true : false;
            message = "修改成功↖(^ω^)↗";
        }
        if(flag == false){
            message = "系统异常，请稍后重试！";
        }
        jr = new JsonResult(flag,message);
        return jr;
    }


    //叫号
    @RequestMapping(value="callNumber" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult callNumber(HttpServletRequest request){
        JsonResult jr ;
        String message = "";
        boolean flag = false;
        String qid = request.getParameter("queueid");
        String rightNow = request.getParameter("rightnow");
        String tableNum = request.getParameter("tableNum");
        queuesService.callNum(qid,rightNow,tableNum);
        if(flag == false){
            message = "系统异常，请稍后重试！";
        }
        jr = new JsonResult(flag,message);
        return jr;
    }
    //删除
    @RequestMapping(value="delete" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult delete(String id){
        JsonResult jr ;
        boolean flag = false;
        flag = queuesService.delete(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }

    //根据id查询
    @RequestMapping(value="getOne" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult getOne(String id){
        JsonResult jr ;
        boolean flag = true;
        Queues queues = queuesService.getOne(id);
        jr = new JsonResult(flag,queues);
        return jr;
    }

    //开关
    @RequestMapping(value="change" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult change(String id){
        JsonResult jr ;
        boolean flag = false;
        flag = queuesService.updateStatus(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }
    //清零
    @RequestMapping(value="reload" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult reload(String id){
        JsonResult jr ;
        boolean flag = false;
        flag = queuesService.setZero(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }
}

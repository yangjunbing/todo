package projects.bing.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projects.bing.dto.JsonResult;
import projects.bing.entity.Foods;
import projects.bing.entity.ParamEntity;
import projects.bing.entity.Queues;
import projects.bing.entity.Types;
import projects.bing.service.MenuService;
import projects.bing.service.QueuesService;
import projects.bing.service.TypesService;
import projects.bing.service.UserService;
import projects.bing.utils.EmojiUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2017/3/19.
 */
@Controller
@RequestMapping(value = "miniApp" )
public class MiniAppController {
    @Autowired
    private QueuesService queuesService;

    @Autowired
    private UserService userService;

    @Autowired
    private TypesService typesService;

    @Autowired
    private MenuService foodsService;
    //测试微信小程序请求响应
    @RequestMapping(value = "test" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult<String> testMiniApp(HttpServletRequest request){
        String param1 = request.getParameter("param1");
        JsonResult jr = new JsonResult(true,"接收到参数:"+param1+" 返回1521");
        return jr;
    }
    //获取队列列表
    @RequestMapping(value = "getQueues" ,method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object getQueues(HttpServletRequest request){
        Gson gson = new Gson();
        List<Queues> queueslist = queuesService.getAllOpen();
        return gson.toJson(queueslist);
    }

    //获取分类集合
    @RequestMapping(value = "getTypes" ,method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object getTypes(HttpServletRequest request){
        Gson gson = new Gson();
        List<Types> typeslist = typesService.getAll();
        return gson.toJson(typeslist);
    }

    //获取菜单集合
    @RequestMapping(value = "getFoods" ,method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object getFoods(HttpServletRequest request){
        Gson gson = new Gson();
        List<Foods> foodslist = foodsService.getAll();
        return gson.toJson(foodslist);
    }

    //获取单品详情
    @RequestMapping(value = "getDetail" ,method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object getDetail(HttpServletRequest request, @Param("id")String id){
        Gson gson = new Gson();
        Foods food = foodsService.getOne(id);
        return gson.toJson(food);
    }

    //取号
    @RequestMapping(value = "getNumber" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult<String> getNumber(HttpServletRequest request){
        String nickname = request.getParameter("nickname");
        String queueid = request.getParameter("queueid");
        nickname = EmojiUtils.emojiConvert(nickname);//emoji转码
        if("".equals(nickname)){
            return new JsonResult<String>(false,"获取用户信息失败。");
        }
        String num = userService.saveUserAndGetNum(nickname,queueid);
        Queues queue = queuesService.getOne(queueid);
        return new JsonResult<String>(true,queue.getTemp1()+num);
    }

    //获取订单集合
    @RequestMapping(value = "getByIds" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object getByIds(HttpServletRequest requests){ //, @RequestBody List<ParamEntity> id
        String ids = requests.getParameter("ids");
        List<ParamEntity> list = null;
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        try {
             list = objectMapper.readValue(ids, new TypeReference<List<ParamEntity>>() {  });
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Foods> orderList = foodsService.getByIds(list);
        Gson gson = new Gson();
        return gson.toJson(orderList);
    }
    /***
     * 确认订单
     */

    //获取订单集合
    @RequestMapping(value = "submitOrder" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object submitOrder(HttpServletRequest requests){ //, @RequestBody List<ParamEntity> id
        String ids = requests.getParameter("ids");
        List<ParamEntity> list = null;
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        try {
            list = objectMapper.readValue(ids, new TypeReference<List<ParamEntity>>() {  });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/*    @RequestMapping(value="getOne" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult getOne(String id){
        JsonResult jr ;
        boolean flag = true;
        Admin admin = adminService.getOne(id);
        jr = new JsonResult(flag,admin);
        return jr;
    }*/


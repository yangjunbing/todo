package projects.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.bing.entity.Foods;
import projects.bing.entity.Orders;
import projects.bing.service.impl.OrderServiceImpl;

import java.util.List;

/**
 * Created by yang on 2017/4/22.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    //跳转
    @RequestMapping(value = "orderForm")
    public String orderForm(Model model){
        List<Orders> orderList = orderService.getAll();
        model.addAttribute("orderList",orderList);
        return "menuForm";
    }

    //新增或修改
    @RequestMapping(value="addOrder" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object addOrder(Foods food){
        return true;
    }
}

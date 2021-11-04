package website.abyss.familyeducationserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.abyss.familyeducationserver.data.Result;
import website.abyss.familyeducationserver.entities.BookOrder;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.service.BookOrderService;

import java.util.List;

@Controller
@RequestMapping("/bookOrder")
public class BookOrderController {

    private BookOrderService bookOrderService;

    @Autowired
    public BookOrderController(BookOrderService bookOrderService) {
        this.bookOrderService = bookOrderService;
    }

    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/orderBook")
    @ResponseBody
    public Result orderBook(@RequestBody BookOrder bookOrder){
        if(bookOrder!=null){
            bookOrderService.orderBook(bookOrder);
            result.setSuccess("订购成功",null);
        }else {
            result.setInfo("订购失败",null);
        }
        return result;
    }

    @RequestMapping("/myOrderList")
    @ResponseBody
    public Result myOrderList(@RequestBody Parent parent){
        if(parent!=null){
            List<BookOrder> bookOrderList = bookOrderService.myOrderList(parent);
            result.setSuccess("查询订单成功",gson.toJson(bookOrderList));
        }else {
            result.setInfo("查询订单失败",null);
        }
        return result;
    }

    @RequestMapping("/cancelOrder")
    @ResponseBody
    public Result cancelOrder(@RequestBody BookOrder bookOrder){
        if(bookOrder!=null&&bookOrder.getStates()==0){
            bookOrderService.cancelOrder(bookOrder);
            result.setSuccess("订单取消成功",null);
        }else {
            result.setInfo("订单已发货，无法取消",null);
        }
        return result;
    }
}

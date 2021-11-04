package website.abyss.familyeducationserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.abyss.familyeducationserver.data.Result;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.entities.Reserve;
import website.abyss.familyeducationserver.entities.Teacher;
import website.abyss.familyeducationserver.service.ReserveService;

import java.util.List;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

    private ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/makeReserve")
    @ResponseBody
    public Result reserveTeacher(@RequestBody Reserve reserve){
        if(reserve!=null&&reserveService.verifyReserve(reserve)){
            reserveService.makeReserve(reserve);
            result.setSuccess("预约成功",null);
        }else result.setInfo("该时间段存在冲突",null);
        return result;
    }

    @RequestMapping("/reserveList")
    @ResponseBody
    public Result ReserveList(@RequestBody Teacher teacher){
        if(teacher!=null){
            List<Reserve> reserveList = reserveService.ReserveList(teacher);
            result.setSuccess("查询老师预约信息成功",gson.toJson(reserveList));
        }else {
            result.setInfo("查询老师预约信息失败",null);
        }
        return result;
    }

    @RequestMapping("/deleteReserve")
    @ResponseBody
    public  Result deleteReserve(@RequestBody Reserve reserve){
        if(reserve!=null){
            reserveService.deleteReserve(reserve);
            result.setSuccess("删除老师预约信息成功",null);
        }else {
            result.setInfo("删除老师预约信息失败",null);
        }
        return result;
    }

    @RequestMapping("/myReserveList")
    @ResponseBody
    public Result myReserveList(@RequestBody Parent parent){
        if(parent!=null){
            List<Reserve> reserveList = reserveService.myReserveList(parent);
            result.setSuccess("查询老师预约信息成功",gson.toJson(reserveList));
        }else {
            result.setInfo("查询老师预约信息失败",null);
        }
        return result;
    }
}

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
import website.abyss.familyeducationserver.entities.Plan;
import website.abyss.familyeducationserver.service.PlanService;

import java.util.Calendar;
import java.sql.Date;

@Controller
@RequestMapping("/plan")
public class PlanController {

    private PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/todayPlan")
    @ResponseBody
    public Result todayPlanList(@RequestBody Parent parent){
        if(parent!=null) {
            java.util.Date date = new java.util.Date();
            Date now = new Date(date.getTime());
            result.setSuccess("查询计划成功", gson.toJson(planService.todayPlanList(parent, now)));
        }else {
            result.setInfo("查询计划失败", null);
        }
        return result;
    }

    @RequestMapping("/myPlan")
    @ResponseBody
    public Result myPlanList(@RequestBody Parent parent){
        if(parent!=null) {
            result.setSuccess("查询计划成功", gson.toJson(planService.myPlanList(parent)));
        }else {
            result.setInfo("查询计划失败", null);
        }
        return result;
    }

    @RequestMapping("/makePlan")
    @ResponseBody
    public Result makePlan(@RequestBody Plan plan){
        if(planService.verifyPlan(plan)){
            planService.makePlan(plan);
            result.setSuccess("定制计划成功",gson.toJson(plan));
        }else result.setInfo("计划时间冲突",null);
        return result;
    }

    @RequestMapping("/cleanPlan")
    @ResponseBody
    public Result cleanPlan(@RequestBody Parent parent){
        if(parent!=null){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 7);
            java.util.Date date = calendar.getTime();
            Date theDay = new Date(date.getTime());
            planService.cleanPlan(parent,theDay);
            result.setSuccess("成功清除7天之前的计划",null);
        }else{
            result.setInfo("清除7天之前的计划失败",null);
        }
        return result;
    }

    @RequestMapping("/deletePlan")
    @ResponseBody
    public Result deletePlan(@RequestBody Plan plan){
        if (plan!=null){
            planService.deletePlan(plan);
            result.setSuccess("删除计划成功",null);
        }else {
            result.setInfo("删除计划失败",null);
        }
        return result;
    }
}

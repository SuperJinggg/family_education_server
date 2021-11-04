package website.abyss.familyeducationserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.abyss.familyeducationserver.data.Result;
import website.abyss.familyeducationserver.entities.ParMoney;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.service.ParMoneyService;

@Controller
@RequestMapping("/parMoney")
public class ParMoneyController {

    private ParMoneyService parMoneyService;

    @Autowired
    public ParMoneyController(ParMoneyService parMoneyService) {
        this.parMoneyService = parMoneyService;
    }

    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/myMoney")
    @ResponseBody
    public Result myMoney(@RequestBody  Parent parent){
        if(parent!=null){
            ParMoney myMoney = parMoneyService.myMoney(parent);
            result.setSuccess("查询我的钱包成功",gson.toJson(myMoney));
        } else{
            result.setInfo("查询我的钱包失败",null);
        }
        return result;
    }

    @RequestMapping("/recharge")
    @ResponseBody
    public Result recharge(@RequestBody  ParMoney parMoney){
        if(parMoney!=null){
            parMoneyService.recharge(parMoney);
            result.setSuccess("更新我的钱包成功",null);
        } else{
            result.setInfo("更新我的钱包失败",null);
        }
        return result;
    }
}

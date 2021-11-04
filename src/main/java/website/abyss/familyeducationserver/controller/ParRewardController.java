package website.abyss.familyeducationserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.abyss.familyeducationserver.data.Result;
import website.abyss.familyeducationserver.entities.ParReward;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.service.ParRewardService;

import java.util.List;

@Controller
@RequestMapping("/parReward")
public class ParRewardController {

    private ParRewardService parRewardService;

    @Autowired
    public ParRewardController(ParRewardService parRewardService) {
        this.parRewardService = parRewardService;
    }

    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/myReward")
    @ResponseBody
    public Result myReward(@RequestBody Parent parent){
        if(parent!=null){
            List<ParReward> parRewardList = parRewardService.myReward(parent);
            result.setSuccess("查询我的优惠券成功",gson.toJson(parRewardList));
        }else {
            result.setInfo("查询我的优惠券失败",null);
        }
        return result;
    }

    @RequestMapping("/giveReward")
    @ResponseBody
    public Result giveReward(@RequestBody ParReward parReward){
        if(parReward!=null){
            parRewardService.giveReward(parReward);
            result.setSuccess("赠送优惠券成功",null);
        }else {
            result.setInfo("赠送优惠券失败",null);
        }
        return result;
    }

    @RequestMapping("/useReward")
    @ResponseBody
    public Result useReward(@RequestBody ParReward parReward){
        if(parReward!=null){
            parRewardService.useReward(parReward);
            result.setSuccess("使用优惠券成功",null);
        }else {
            result.setInfo("使用优惠券失败",null);
        }
        return result;
    }
}

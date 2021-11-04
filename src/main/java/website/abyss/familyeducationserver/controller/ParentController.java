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
import website.abyss.familyeducationserver.service.ParentService;

@Controller
@RequestMapping("/parent")
public class ParentController {

    private ParentService parentService;

    private ParMoneyService parMoneyService;

    @Autowired
    public ParentController(ParentService parentService,ParMoneyService parMoneyService) {
        this.parentService = parentService;
        this.parMoneyService = parMoneyService;
    }


    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestBody Parent parent){
        if(parentService.getByParPhone(parent.getParPhone())!=null){//id重复！
            result.setInfo("该账号已注册！",null);
        }else{
            ParMoney myMoney = new ParMoney();
            myMoney.setParPhone(parent.getParPhone());
            myMoney.setBalance(0.0);
            myMoney.setPoint(0);
            parMoneyService.init(myMoney);
            parentService.save(parent);
            result.setSuccess("注册成功！",gson.toJson(parent));
        }
        return result;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody Parent user){
        Parent user1=null;
        user1=parentService.getByParPhone(user.getParPhone());
        if(user1!=null){//存在该账户
            if(user1.getPassword().equals(user.getPassword())){//密码正确
                result.setSuccess("登录成功！",gson.toJson(user1));
            }else{//密码错误
                result.setInfo("用户名或密码错误！",null);
            }
        }else{//不存在该账户
            result.setInfo("该账号不存在！",null);
        }
        return result;
    }

    @RequestMapping("/forgetPassword")
    @ResponseBody
    public Result forgetPassword(@RequestBody Parent parent){
        Parent parent1=parentService.getByParPhone(parent.getParPhone());
        if(parent1!=null){//id重复！
            parentService.update(parent);
            parent1.setPassword(parent.getPassword());
            result.setSuccess("修改密码成功！",gson.toJson(parent1));
        }else{
            result.setInfo("该账号不存在！",null);
        }
        return result;
    }
}

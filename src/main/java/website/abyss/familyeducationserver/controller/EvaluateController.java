package website.abyss.familyeducationserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.abyss.familyeducationserver.data.Result;
import website.abyss.familyeducationserver.entities.Evaluate;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.entities.Teacher;
import website.abyss.familyeducationserver.service.EvaluateService;

import java.util.List;

@Controller
@RequestMapping("/evaluate")
public class EvaluateController {

    private EvaluateService evaluateService;

    @Autowired
    public EvaluateController(EvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }

    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/makeEvaluate")
    @ResponseBody
    public Result makeEvaluate(@RequestBody Evaluate evaluate){
        if(evaluate!=null){
            evaluateService.makeEvaluate(evaluate);
            result.setSuccess("提建议成功",null);
        }else {
            result.setInfo("提建议失败" ,null);
        }
        return result;
    }

    @RequestMapping("/teacherEvaluateList")
    @ResponseBody
    public Result teacherEvaluateList(@RequestBody Teacher teacher){
        if(teacher!=null){
            List<Evaluate> evaluateList = evaluateService.teacherEvaluateList(teacher);
            result.setSuccess("查询老师的建议成功",gson.toJson(evaluateList));
        }else {
            result.setInfo("查询老师的建议失败" ,null);
        }
        return result;
    }

    @RequestMapping("/myEvaluateList")
    @ResponseBody
    public Result myEvaluateList(@RequestBody Parent parent){
        if(parent!=null){
            List<Evaluate> evaluateList = evaluateService.myEvaluateList(parent);
            result.setSuccess("查询我的建议成功",gson.toJson(evaluateList));
        }else {
            result.setInfo("查询我的建议失败" ,null);
        }
        return result;
    }

    @RequestMapping("/deleteEvaluate")
    @ResponseBody
    public Result deleteEvaluate(@RequestBody Evaluate evaluate){
        if(evaluate!=null){
            evaluateService.deleteEvaluate(evaluate);
            result.setSuccess("删除建议成功",null);
        }else {
            result.setInfo("删除建议失败" ,null);
        }
        return result;
    }
}

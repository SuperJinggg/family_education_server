package website.abyss.familyeducationserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.abyss.familyeducationserver.data.Result;
import website.abyss.familyeducationserver.entities.Teacher;
import website.abyss.familyeducationserver.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    Gson gson= new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();
    Result result=new Result();

    @RequestMapping("/teacherList")
    @ResponseBody
    public Result teacherList(){
        result.setSuccess("查询成功",gson.toJson(teacherService.teacherList()));
        return result;
    }

    @RequestMapping("/findTeacherByPhone")
    @ResponseBody
    public Result findTeacherByPhone(String teacherPhone){
        List<Teacher> teacherList = teacherService.findTeacherByPhone(teacherPhone);
        if(teacherList.size()>0){
            result.setSuccess("查询成功",gson.toJson(teacherList));
        }else {
            result.setInfo("该老师不存在",null);
        }
        return result;
    }


    @RequestMapping("/findTeacherByName")
    @ResponseBody
    public Result findTeacherByName(String teacherName){
        List<Teacher> teacherList = teacherService.findTeacherByName(teacherName);
        if(teacherList.size()>0){
            result.setSuccess("查询成功",gson.toJson(teacherList));
        }else {
            result.setInfo("该老师不存在",null);
        }
        return result;
    }

    @RequestMapping("/findTeacherByGrade")
    @ResponseBody
    public Result findTeacherByGrade(String grade){
        List<Teacher> teacherList = teacherService.findTeacherByGrade(grade);
        if(teacherList.size()>0){
            result.setSuccess("查询成功",gson.toJson(teacherList));
        }else {
            result.setInfo("该老师不存在",null);
        }
        return result;
    }

    @RequestMapping("/findTeacherBySubject")
    @ResponseBody
    public Result findTeacherBySubject(String subject){
        List<Teacher> teacherList = teacherService.findTeacherBySubject(subject);
        if(teacherList.size()>0){
            result.setSuccess("查询成功",gson.toJson(teacherList));
        }else {
            result.setInfo("该老师不存在",null);
        }
        return result;
    }

    @RequestMapping("/findTeacherBySubjectAndGrade")
    @ResponseBody
    public Result findTeacherBySubjectAndGrade(String subject,String grade){
        List<Teacher> teacherList = teacherService.findTeacherBySubjectAndGrade(subject,grade);
        if(teacherList.size()>0){
           result.setSuccess("查询成功",gson.toJson(teacherList));
        }else {
            result.setInfo("该老师不存在",null);
        }
        return result;
    }
}

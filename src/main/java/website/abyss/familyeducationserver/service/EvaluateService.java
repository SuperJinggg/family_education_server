package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.Evaluate;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.entities.Teacher;
import website.abyss.familyeducationserver.mapper.EvaluateMapper;

import java.util.List;

@Service
@Transactional
public class EvaluateService {

    private EvaluateMapper evaluateMapper;

    @Autowired
    public EvaluateService(EvaluateMapper evaluateMapper) {
        this.evaluateMapper = evaluateMapper;
    }

    public void makeEvaluate(Evaluate evaluate) {
        evaluateMapper.makeEvaluate(evaluate);
    }

    public List<Evaluate> teacherEvaluateList(Teacher teacher) {
        return evaluateMapper.teacherEvaluateList(teacher.getTeacherPhone());
    }

    public List<Evaluate> myEvaluateList(Parent parent) {
        return evaluateMapper.myEvaluateList(parent.getParPhone());
    }

    public void deleteEvaluate(Evaluate evaluate) {
        evaluateMapper.deleteEvaluate(evaluate.getId());
    }
}

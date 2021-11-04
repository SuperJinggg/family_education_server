package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.Evaluate;

import java.util.List;

@Mapper
public interface EvaluateMapper {

    void makeEvaluate(Evaluate evaluate);

    List<Evaluate> teacherEvaluateList(String teacherPhone);

    List<Evaluate> myEvaluateList(String parPhone);

    void deleteEvaluate(Integer id);
}
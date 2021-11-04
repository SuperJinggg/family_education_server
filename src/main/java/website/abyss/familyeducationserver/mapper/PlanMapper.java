package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.Plan;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PlanMapper {

    List<Plan> todayPlanList(HashMap<String,Object> map);

    void makePlan(Plan plan);

    Plan verifyPlan(Plan plan);

    void cleanPlan(HashMap<String,Object> map);

    List<Plan> myPlanList(String parPhone);

    void deletePlan(Integer id);
}
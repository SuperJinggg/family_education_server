package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.entities.Plan;
import website.abyss.familyeducationserver.mapper.PlanMapper;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class PlanService {

    private PlanMapper planMapper;

    @Autowired
    public PlanService(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }


    public List<Plan> todayPlanList(Parent parent, Date now) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("parPhone",parent.getParPhone());
        map.put("now",now);
        return planMapper.todayPlanList(map);
    }

    public void makePlan(Plan plan) {
        planMapper.makePlan(plan);
    }

    public boolean verifyPlan(Plan plan) {
        boolean flag=false;
        if(planMapper.verifyPlan(plan)==null){
            flag=true;
        }
        return flag;
    }

    public void cleanPlan(Parent parent, Date theDay) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("parPhone",parent.getParPhone());
        map.put("theDay",theDay);
        planMapper.cleanPlan(map);
    }

    public List<Plan> myPlanList(Parent parent) {
        return planMapper.myPlanList(parent.getParPhone());
    }

    public void deletePlan(Plan plan) {
        planMapper.deletePlan(plan.getId());
    }
}

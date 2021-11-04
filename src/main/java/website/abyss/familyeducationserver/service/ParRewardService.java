package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.ParReward;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.mapper.ParRewardMapper;

import java.util.List;

@Service
@Transactional
public class ParRewardService {

    private ParRewardMapper parRewardMapper;

    @Autowired
    public ParRewardService(ParRewardMapper parRewardMapper) {
        this.parRewardMapper = parRewardMapper;
    }

    public List<ParReward> myReward(Parent parent) {
        return parRewardMapper.myReward(parent.getParPhone());
    }

    public void giveReward(ParReward parReward) {
        parRewardMapper.giveReward(parReward);
    }

    public void useReward(ParReward parReward) {
        parRewardMapper.useReward(parReward.getId());
    }
}

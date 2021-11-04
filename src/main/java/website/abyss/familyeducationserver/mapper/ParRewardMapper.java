package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.ParReward;

import java.util.List;

@Mapper
public interface ParRewardMapper {

    List<ParReward> myReward(String parPhone);

    void giveReward(ParReward parReward);

    void useReward(Integer id);
}
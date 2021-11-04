package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.ParMoney;

@Mapper
public interface ParMoneyMapper {
    int insert(ParMoney record);

    ParMoney myMoney(String parPhone);

    void recharge(ParMoney parMoney);
}
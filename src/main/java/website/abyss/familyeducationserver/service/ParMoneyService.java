package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.ParMoney;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.mapper.ParMoneyMapper;

@Service
@Transactional
public class ParMoneyService {

    private ParMoneyMapper parMoneyMapper;

    @Autowired
    public ParMoneyService(ParMoneyMapper parMoneyMapper) {
        this.parMoneyMapper = parMoneyMapper;
    }

    public  void init(ParMoney myMoney) {
        parMoneyMapper.insert(myMoney);
    }

    public ParMoney myMoney(Parent parent) {
        return parMoneyMapper.myMoney(parent.getParPhone());
    }

    public void recharge(ParMoney parMoney) {
        parMoneyMapper.recharge(parMoney);
    }
}

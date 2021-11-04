package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.mapper.ParentMapper;

@Service
@Transactional
public class ParentService {

    private ParentMapper parentMapper;

    @Autowired
    public ParentService(ParentMapper parentMapper) {
        this.parentMapper = parentMapper;
    }

    public Parent getByParPhone(String parPhone) {
        return parentMapper.getByParPhone(parPhone);
    }

    public void save(Parent parent) {
        parentMapper.save(parent);
    }

    public void update(Parent parent) {
        parentMapper.update(parent);
    }
}

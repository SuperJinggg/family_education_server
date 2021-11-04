package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.Parent;

@Mapper
public interface ParentMapper {
    void save(Parent record);

    Parent getByParPhone(String parPhone);

    void update(Parent parent);
}
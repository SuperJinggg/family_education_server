package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.Reserve;

import java.util.List;

@Mapper
public interface ReserveMapper {
    void makeReserve(Reserve reserve);

    List<Reserve> verifyReserve(Reserve reserve);

    List<Reserve> ReserveList(String teacherPhone);

    void deleteReserve(Integer id);

    List<Reserve> myReserveList(String parPhone);
}
package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.entities.Reserve;
import website.abyss.familyeducationserver.entities.Teacher;
import website.abyss.familyeducationserver.mapper.ReserveMapper;

import java.util.List;

@Service
@Transactional
public class ReserveService {

    private ReserveMapper reserveMapper;

    @Autowired
    public ReserveService(ReserveMapper reserveMapper) {
        this.reserveMapper = reserveMapper;
    }


    public void makeReserve(Reserve reserve) {
        reserveMapper.makeReserve(reserve);
    }

    public boolean verifyReserve(Reserve reserve) {
        List<Reserve> reserveList = reserveMapper.verifyReserve(reserve);
        if(reserveList.size()<=0){
            return true;
        }
        return false;
    }

    public List<Reserve> ReserveList(Teacher teacher) {
        return reserveMapper.ReserveList(teacher.getTeacherPhone());
    }

    public void deleteReserve(Reserve reserve) {
        reserveMapper.deleteReserve(reserve.getId());
    }

    public List<Reserve> myReserveList(Parent parent) {
        return reserveMapper.myReserveList(parent.getParPhone());
    }
}

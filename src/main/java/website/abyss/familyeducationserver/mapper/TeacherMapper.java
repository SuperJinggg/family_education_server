package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {

    int insertSelective(Teacher record);

    List<Teacher> teacherList();

    List<Teacher> findTeacherByName(String teacherName);

    List<Teacher> findTeacherByGrade(String grade);

    List<Teacher> findTeacherBySubject(String subject);

    List<Teacher> findTeacherBySubjectAndGrade(String subject, String grade);

    List<Teacher> findTeacherByPhone(String teacherPhone);
}
package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.Teacher;
import website.abyss.familyeducationserver.mapper.TeacherMapper;

import java.util.List;

@Service
@Transactional
public class TeacherService {

    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public List<Teacher> teacherList() {
        return teacherMapper.teacherList();
    }

    public List<Teacher> findTeacherByName(String teacherName) {
        return teacherMapper.findTeacherByName(teacherName);
    }

    public List<Teacher> findTeacherByGrade(String grade) {
        return teacherMapper.findTeacherByGrade(grade);
    }

    public List<Teacher> findTeacherBySubject(String subject) {
        return teacherMapper.findTeacherBySubject(subject);
    }

    public List<Teacher> findTeacherBySubjectAndGrade(String subject, String grade) {
        return teacherMapper.findTeacherBySubjectAndGrade(subject,grade);
    }

    public List<Teacher> findTeacherByPhone(String teacherPhone) {
        return teacherMapper.findTeacherByPhone(teacherPhone);
    }
}

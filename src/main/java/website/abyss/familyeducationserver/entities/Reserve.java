package website.abyss.familyeducationserver.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Reserve {
    private Integer id;

    private String parPhone;

    private String teacherName;

    private String teacherPhone;

    private String subject;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date endDate;

    public Reserve() {
    }

    public Reserve(Integer id, String parPhone, String teacherName, String teacherPhone, String subject, Date startDate, Date endDate) {
        this.id = id;
        this.parPhone = parPhone;
        this.teacherName = teacherName;
        this.teacherPhone = teacherPhone;
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParPhone() {
        return parPhone;
    }

    public void setParPhone(String parPhone) {
        this.parPhone = parPhone;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", parPhone='" + parPhone + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhone='" + teacherPhone + '\'' +
                ", subject='" + subject + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
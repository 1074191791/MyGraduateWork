package cn.crms.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程对象
 * @author zhous
 * @create 2019-03-21 19:07
 */
public class Lesson implements Serializable {

    private Integer id;

    private String lessonName;

    private Date addDate;

    private Double lessonTime;

    private Double lessonScore;

    private String lessonRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName == null ? null : lessonName.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Double getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(Double lessonTime) {
        this.lessonTime = lessonTime;
    }

    public Double getLessonScore() {
        return lessonScore;
    }

    public void setLessonScore(Double lessonScore) {
        this.lessonScore = lessonScore;
    }

    public String getLessonRemark() {
        return lessonRemark;
    }

    public void setLessonRemark(String lessonRemark) {
        this.lessonRemark = lessonRemark == null ? null : lessonRemark.trim();
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", addDate=" + addDate +
                ", lessonTime=" + lessonTime +
                ", lessonScore=" + lessonScore +
                ", lessonRemark='" + lessonRemark + '\'' +
                '}';
    }
}

package org.forten.scss.dao;

import org.apache.ibatis.annotations.Param;
import org.forten.scss.dto.qo.CreditQoForCount;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.forten.scss.dto.vo.SelectInfoVoForWrite;

import java.util.List;

public interface SelectCourseDao {
    List<CourseVoForSelect> queryForSelect(@Param("studentId") long studentId);
    List<CourseVoForSelect> queryForCancel(@Param("studentId") long studentId);
    List<CourseVoForSelect> querySelectedCourse(@Param("studentId") long studentId);
    void selectCourse(SelectInfoVoForWrite vo);
    void addOneCurrentAmount(@Param("courseId") long courseId);
    void cancelCourse(@Param("studentId") long studentId, @Param("courseId") long courseId);
    void subOneCurrentAmount(@Param("courseId") long courseId);
    Long queryPD2XK(@Param("courseId") long courseId);
    Integer queryCreditForCount(CreditQoForCount qo);

    Integer queryCreditForNotBegin(long studentId);
    List<CourseVoForSelect> findWillTeached();

    List<String> findEmails(@Param("courseId") long courseId);
}

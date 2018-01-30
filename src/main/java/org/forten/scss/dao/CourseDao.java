package org.forten.scss.dao;

import org.forten.scss.dto.qo.CourseQoForTeacher;
import org.forten.scss.dto.vo.AttendanceVo;
import org.forten.scss.dto.vo.CourseForTeacher;
import org.forten.scss.dto.vo.NameListVo;
import org.forten.scss.dto.vo.ScInfoPie;

import java.util.List;
import java.util.Set;

public interface CourseDao {
    long queryCountForTeacher(CourseQoForTeacher qo);
    List<CourseForTeacher> queryForTeacher(CourseQoForTeacher qo);
    List<CourseForTeacher> queryForExport(CourseQoForTeacher qo);
    List<NameListVo> queryNameList(long courseId);
    List<CourseForTeacher> queryFinished();
    List<AttendanceVo> queryForAttendance(long courseId);
    void changeAttendance(AttendanceVo vo);
    Set<ScInfoPie> findForPie(long courseId);
}

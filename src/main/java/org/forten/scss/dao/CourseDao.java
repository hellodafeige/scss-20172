package org.forten.scss.dao;

import org.forten.scss.dto.qo.CourseQoForTeacher;
import org.forten.scss.dto.vo.CourseForTeacher;

import java.util.List;

public interface CourseDao {
    long queryCountForTeacher(CourseQoForTeacher qo);
    List<CourseForTeacher> queryForTeacher(CourseQoForTeacher qo);
    List<CourseForTeacher> queryForExport(CourseQoForTeacher qo);
}

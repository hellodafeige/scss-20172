package org.forten.scss.dao;

import org.forten.scss.dto.qo.StudentQoForTeacher;
import org.forten.scss.dto.vo.StudentForTeacher;

import java.util.List;

public interface StudentDao {
    long queryCountForTeacher(StudentQoForTeacher qo);
    List<StudentForTeacher> queryForTeacher(StudentQoForTeacher qo);
//    List<CourseForTeacher> queryForExport(StudentQoForTeacher qo);
}

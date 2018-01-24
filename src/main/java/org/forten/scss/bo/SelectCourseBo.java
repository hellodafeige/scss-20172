package org.forten.scss.bo;

import org.forten.dao.MybatisDao;
import org.forten.dto.Message;
import org.forten.scss.dao.SelectCourseDao;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.forten.scss.dto.vo.SelectInfoVoForWrite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SelectCourseBo {
    @Resource
    private MybatisDao mybatisDao;

    @Transactional(readOnly = true)
    public List<CourseVoForSelect> queryForSelect(long studentId){
        return getSelectCourseDao().queryForSelect(studentId);
    }

    @Transactional(readOnly = true)
    public List<CourseVoForSelect> queryForCancel(long studentId){
        return getSelectCourseDao().queryForCancel(studentId);
    }

    @Transactional(readOnly = true)
    public List<CourseVoForSelect> querySelectedCourse(long studentId){
        return getSelectCourseDao().querySelectedCourse(studentId);
    }

    @Transactional
    public Message doSelectCourse(SelectInfoVoForWrite vo) {
        try {
            getSelectCourseDao().selectCourse(vo);
            if (vo.getOptType().equals("XK")) {
                getSelectCourseDao().addOneCurrentAmount(vo.getCourseId());
                return Message.info("选课操作成功!");
            } else if (vo.getOptType().equals("PD")) {
                return Message.info("此课程已达到选课人数上限，您目前处理排队状态!");
            } else {
                return Message.warn("未知操作！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error("选课操作失败!");
        }
    }

    @Transactional
    public Message doCancelCourse(long studentId, long courseId) {
        SelectCourseDao selectCourseDao = getSelectCourseDao();
        try {
            selectCourseDao.cancelCourse(studentId, courseId);

            Long toXKStudentId = selectCourseDao.queryPD2XK(courseId);
            if(toXKStudentId==null){
                selectCourseDao.subOneCurrentAmount(courseId);
            }else{
                SelectInfoVoForWrite vo = new SelectInfoVoForWrite(toXKStudentId,courseId,"XK");
                selectCourseDao.selectCourse(vo);
            }
            return Message.info("退课操作成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error("退课操作失败!");
        }
    }

    private SelectCourseDao getSelectCourseDao(){
        return mybatisDao.openSession().getMapper(SelectCourseDao.class);
    }
}

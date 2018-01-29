package org.forten.scss.bo;

import org.apache.ibatis.session.SqlSession;
import org.forten.dao.HibernateDao;
import org.forten.dao.MybatisDao;
import org.forten.dto.Message;
import org.forten.dto.PageInfo;
import org.forten.dto.PagedRo;
import org.forten.scss.dao.CourseDao;
import org.forten.scss.dto.qo.CourseQoForTeacher;
import org.forten.scss.dto.ro.PagedRoForEasyUI;
import org.forten.scss.dto.vo.AttendanceVo;
import org.forten.scss.dto.vo.CourseForTeacher;
import org.forten.scss.dto.vo.CourseUpdateForTeacher;
import org.forten.scss.dto.vo.NameListVo;
import org.forten.scss.entity.Course;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("courseBo")
public class CourseBo {
    @Resource
    private HibernateDao dao;
    @Resource
    private MybatisDao mybatisDao;

    @Transactional
    public Message doSave(Course course){
        // TODO 可以使用AOP技术进行以下代码的分离
        ValidateUtil.validateThrow(course);
        try {
            dao.save(course);
            return Message.info("课程保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return Message.error("课程保存失败");
        }
    }

    @Transactional
    public Message doUpdate(CourseUpdateForTeacher vo){
        // TODO 可以使用AOP技术进行以下代码的分离
        ValidateUtil.validateThrow(vo);
        try {
            Course course = dao.loadById(Course.class,vo.getId());
            BeanPropertyUtil.copy(course,vo);

            return Message.info("课程修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error("课程修改失败！");
        }
    }

    @Transactional(readOnly = true)
    public PagedRoForEasyUI<CourseForTeacher> queryBy(CourseQoForTeacher qo) {
        CourseDao courseDao = getCourseDao();

        long count = courseDao.queryCountForTeacher(qo);
        if(count==0){
            return new PagedRoForEasyUI(new PagedRo<>());
        }

        PageInfo page = PageInfo.getInstance(qo.getPage(),qo.getRows(),(int)count);

        qo.setFirst(page.getFirst());

        List<CourseForTeacher> list = courseDao.queryForTeacher(qo);

        return new PagedRoForEasyUI<>(new PagedRo<>(list,page));
    }

    @Transactional(readOnly = true)
    public List<CourseForTeacher> queryForExport(CourseQoForTeacher qo) {
        System.out.println(qo);
        List<CourseForTeacher> list = getCourseDao().queryForExport(qo);
        return list;
    }

    private CourseDao getCourseDao() {
        SqlSession session = mybatisDao.openSession();
        return session.getMapper(CourseDao.class);
    }

    @Transactional
    public void doBatchSave(Course... courses){
        dao.save(courses);
    }

    @Transactional(readOnly = true)
    public List<NameListVo> queryNameList(long courseId){
        return getCourseDao().queryNameList(courseId);
    }

    @Transactional(readOnly = true)
    public List<CourseForTeacher> queryFinised(){
        return getCourseDao().queryFinished();
    }

    @Transactional(readOnly = true)
    public List<AttendanceVo> queryForAttendance(long coruseId){
        return getCourseDao().queryForAttendance(coruseId);
    }

    @Transactional
    public void doChangeAttendance(AttendanceVo vo){
        getCourseDao().changeAttendance(vo);
    }

}

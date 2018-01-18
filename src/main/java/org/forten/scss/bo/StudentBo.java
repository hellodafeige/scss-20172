package org.forten.scss.bo;

import org.apache.ibatis.session.SqlSession;
import org.forten.dao.HibernateDao;
import org.forten.dao.MybatisDao;
import org.forten.dto.Message;
import org.forten.dto.PageInfo;
import org.forten.dto.PagedRo;
import org.forten.scss.dao.StudentDao;
import org.forten.scss.dto.qo.StudentQoForTeacher;
import org.forten.scss.dto.ro.PagedRoForEasyUI;
import org.forten.scss.dto.vo.StudentForTeacher;
import org.forten.scss.entity.Course;
import org.forten.scss.entity.Student;
import org.forten.utils.system.BeanPropertyUtil;
import org.forten.utils.system.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("studentBo")
public class StudentBo {
    @Resource
    private HibernateDao dao;
    @Resource
    private MybatisDao mybatisDao;

    @Transactional(readOnly = true)
    public PagedRoForEasyUI<StudentForTeacher> queryBy(StudentQoForTeacher qo){
        StudentDao studentDao = getStudentDao();




        long count = studentDao.queryCountForTeacher(qo);
        if(count == 0){
            return new PagedRoForEasyUI<>(new PagedRo<>());
        }
        PageInfo page = PageInfo.getInstance(qo.getPage(),qo.getRows(),(int)count);
        qo.setFirst(page.getFirst());
        List<StudentForTeacher> list = studentDao.queryForTeacher(qo);
        return new PagedRoForEasyUI<>(new PagedRo<>(list,page));
    }



    private StudentDao getStudentDao() {
        SqlSession session = mybatisDao.openSession();
        return session.getMapper(StudentDao.class);
    }

    @Transactional
    public Message doSave(Student student){
        // TODO 可以使用AOP技术进行以下代码的分离
        ValidateUtil.validateThrow(student);
        try {
            dao.save(student);
            System.out.println(student);
            return Message.info("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return Message.error("保存失败");
        }
    }

    @Transactional
    public Message doUpdate(StudentForTeacher vo){
        // TODO 可以使用AOP技术进行以下代码的分离
        ValidateUtil.validateThrow(vo);
        try {
            Student student = dao.loadById(Student.class,vo.getId());

            BeanPropertyUtil.copy(student,vo);

            return Message.info("学员信息修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Message.error("学员信息修改失败！");
        }
    }

    @Transactional(readOnly = true)
    public List<StudentForTeacher> queryForExport(StudentQoForTeacher qo){
        System.out.println(qo);
        List<StudentForTeacher> list = getStudentDao().queryForExport(qo);
        return list;
    }

    @Transactional
    public void doBatchSave(Student... students){
        dao.save(students);
    }

}

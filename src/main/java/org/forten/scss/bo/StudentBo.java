package org.forten.scss.bo;

import org.apache.ibatis.session.SqlSession;
import org.forten.dao.HibernateDao;
import org.forten.dao.MybatisDao;
import org.forten.dto.PageInfo;
import org.forten.dto.PagedRo;
import org.forten.scss.dao.StudentDao;
import org.forten.scss.dto.qo.StudentQoForTeacher;
import org.forten.scss.dto.ro.PagedRoForEasyUI;
import org.forten.scss.dto.vo.StudentForTeacher;
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
}

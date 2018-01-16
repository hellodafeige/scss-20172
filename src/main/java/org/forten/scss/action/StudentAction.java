package org.forten.scss.action;

import org.forten.scss.bo.StudentBo;
import org.forten.scss.dto.qo.StudentQoForTeacher;
import org.forten.scss.dto.ro.PagedRoForEasyUI;
import org.forten.scss.dto.vo.StudentForTeacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentAction {
    @Resource
    private StudentBo bo;


    @PostMapping("/student/query")
    public @ResponseBody
    PagedRoForEasyUI<StudentForTeacher> listpage(@RequestParam(defaultValue = "") String name ,@RequestParam(defaultValue = "") String gender,
                                                 @RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int rows){
        StudentQoForTeacher qo = new StudentQoForTeacher();
        qo.setName(name);
        qo.setGender(gender);
        qo.setPage(page);
        qo.setRows(rows);
        PagedRoForEasyUI<StudentForTeacher> ro = bo.queryBy(qo);
        return ro;
    }
}

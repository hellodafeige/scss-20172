package org.forten.scss.action;

import org.forten.dto.Message;
import org.forten.scss.bo.StudentBo;
import org.forten.scss.dto.qo.StudentQoForTeacher;
import org.forten.scss.dto.ro.PagedRoForEasyUI;
import org.forten.scss.dto.vo.CourseUpdateForTeacher;
import org.forten.scss.dto.vo.StudentForTeacher;
import org.forten.scss.entity.Student;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.ValidateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        StudentQoForTeacher qo = new StudentQoForTeacher(name,gender,0,page,rows);
        System.out.println(qo);
        PagedRoForEasyUI<StudentForTeacher> ro = bo.queryBy(qo);
        return ro;
    }

    @PostMapping("/student")
    public @ResponseBody
    Message save(@RequestBody Student student){
        System.out.println(student);
        try {

            return bo.doSave(student);
        }catch (ValidateException e){
            return Message.error(StringUtil.join(e.getMessages(), "<br>"));
        }
    }

    @PutMapping("/student")
    public @ResponseBody
    Message update(@RequestBody StudentForTeacher vo) {
        try {

            return bo.doUpdate(vo);
        } catch (ValidateException e) {
            return Message.error(StringUtil.join(e.getMessages(), "<br>"));
        }
    }
}

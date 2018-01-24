package org.forten.scss.action;

import org.forten.dto.Message;
import org.forten.scss.bo.SelectCourseBo;
import org.forten.scss.dto.vo.CourseVoForSelect;
import org.forten.scss.dto.vo.SelectInfoVoForWrite;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SelectCourseAction {
    @Resource
    private SelectCourseBo bo;

    @GetMapping("/sc/courseForSelectList")
    public List<CourseVoForSelect> listCourseForSelect(){
        // TODO 干部ID应该从安全上下文中获取
        long studentId = 1;

        return bo.queryForSelect(studentId);
    }

    @GetMapping("/sc/courseForCancelList")
    public List<CourseVoForSelect> listCourseForCancel(){
        // TODO 干部ID应该从安全上下文中获取
        long studentId = 1;

        return bo.queryForCancel(studentId);
    }

    @GetMapping("/sc/selectedCourse")
    public List<CourseVoForSelect> listSelectedCourse(){
        // TODO 干部ID应该从安全上下文中获取
        long studentId = 1;

        return bo.querySelectedCourse(studentId);
    }

    @PostMapping("/sc/select")
    public Message selectCourse(@RequestBody SelectInfoVoForWrite vo){
        // 此时的vo中暂无studentId，而已经存在courseId和optType
        // TODO 干部ID应该从安全上下文中获取
        long studentId = 1;

        // 把studentId填充到vo对象里
        vo.setStudentId(studentId);

        return bo.doSelectCourse(vo);
    }

    @PutMapping("/sc/cancel/{courseId}")
    public Message cancelCourse(@PathVariable long courseId){
        // TODO 干部ID应该从安全上下文中获取
        long studentId = 1;

        return bo.doCancelCourse(studentId,courseId);
    }
}

package org.forten.scss.action;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.forten.dto.Message;
import org.forten.scss.bo.StudentBo;
import org.forten.scss.dto.qo.StudentQoForTeacher;
import org.forten.scss.dto.ro.PagedRoForEasyUI;
import org.forten.scss.dto.vo.StudentForTeacher;
import org.forten.scss.entity.Student;
import org.forten.utils.common.StringUtil;
import org.forten.utils.system.ValidateException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentAction {
    @Resource
    private StudentBo bo;




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

    @PostMapping("/student/export")
    public void exportData(StudentQoForTeacher qo , HttpServletResponse response){
        List<StudentForTeacher> list = bo.queryForExport(qo);
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("学员信息");

            Row head = sheet.createRow(0);
            Cell c1 = head.createCell(0);
            Cell c2 = head.createCell(1);
            Cell c3 = head.createCell(2);
            Cell c4 = head.createCell(3);
            Cell c5 = head.createCell(4);

            c1.setCellValue("ID");
            c2.setCellValue("姓名");
            c3.setCellValue("性别");
            c4.setCellValue("电话");
            c5.setCellValue("邮箱");

            for (int i = 0; i < list.size(); i++ ){
                StudentForTeacher s = list.get(i);
                Row dataRow = sheet.createRow(i + 1);

                dataRow.createCell(0).setCellValue(s.getId());
                dataRow.createCell(1).setCellValue(s.getName());
                dataRow.createCell(2).setCellValue(s.getGender());
                dataRow.createCell(3).setCellValue(s.getPhone());
                dataRow.createCell(4).setCellValue(s.getMailbox());

                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-Disposition", "attachment; filename=student-list.xlsx");
                ServletOutputStream out = response.getOutputStream();
                wb.write(out);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/student/importData")
    public void importData(MultipartFile file){
        List<Student> list = new ArrayList<>();
        try {
            InputStream in = file.getInputStream();
            Workbook wb = WorkbookFactory.create(in);
            Sheet sheet = wb.getSheetAt(0);
            for(int i = 1;i<=sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);

                Student s = new Student();
                s.setName(row.getCell(0).getStringCellValue());
                s.setGender(row.getCell(1).getStringCellValue());
                s.setPhone(row.getCell(2).getStringCellValue());
                s.setMailbox(row.getCell(3).getStringCellValue());

                list.add(s);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        bo.doBatchSave(list.toArray(new Student[list.size()]));
    }

}

package com.example.demo.controller;


import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihu
 * @since 2019-09-17
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/save")
    public String save(){
        Student student=new Student();
        student.setName("瓜田李下");
        student.setAge(23);

        studentService.save(student);

        return "success";
    }

    @RequestMapping("/update")
    public Student update(){
        Student student=studentService.getById(1);
        student.setName("海贼王");

        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean flag=studentService.updateById(student);
        System.out.println("更新操作："+flag);

        return studentService.getById(student.getId());
    }

    @RequestMapping("/update2")
    public Student update2(){
        Student student=studentService.getById(1);
        student.setName("海贼王");

        boolean flag=studentService.updateById(student);
        System.out.println("更新操作："+flag);

        return studentService.getById(student.getId());
    }
}


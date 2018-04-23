package cn.sicau.count.service.impl;

import cn.sicau.count.dao.StudentMapper;
import cn.sicau.count.domain.Student;
import cn.sicau.count.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yelei
 * @date 18-4-14
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getByStuNumber(String stuNumber) {
        return studentMapper.getByStuNumber(stuNumber);
    }
}

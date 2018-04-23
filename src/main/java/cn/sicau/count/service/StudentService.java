package cn.sicau.count.service;

import cn.sicau.count.domain.Student;

/**
 * @author yelei
 * @date 18-4-14
 */
public interface StudentService {
    Student getByStuNumber(String stuNumber);
}

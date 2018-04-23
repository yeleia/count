package cn.sicau.count.service;

import cn.sicau.count.domain.Abstain;

import java.util.List;

/**
 * @author yelei
 * @date 18-4-8
 */
public interface AbstainService {
    String addAbstain(Abstain abstain);
    String updateAbstain(Abstain abstain);
    List<Abstain> getAll(Integer tempPage,Integer pageCapacity);
    void deleteById(Integer id);
    Integer count();
    Abstain getByClasses(String classes);
}

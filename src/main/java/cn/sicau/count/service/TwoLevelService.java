package cn.sicau.count.service;

import cn.sicau.count.domain.TwoLevel;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-30
 */
public interface TwoLevelService {
    String addTwoLevel(TwoLevel twoLevel);
    String updateLevel(TwoLevel twoLevel);
    List<TwoLevel> getAll();
    Integer  deleteById(Integer id);
}

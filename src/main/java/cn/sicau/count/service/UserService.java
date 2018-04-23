package cn.sicau.count.service;

import cn.sicau.count.domain.Solo;
import cn.sicau.count.domain.User;

import java.util.List;

/**
 * @author yelei
 * @date 18-4-4
 */
public interface UserService {
    User login(User user);
    String addSoloScore(Solo solo);
    String updateSoloScore(Solo solo);
    String  deleteScoreById(Integer id);
    List<Solo> getAllSoloScore(Integer tempPage,Integer pageCapacity);
    Integer getCount();
}

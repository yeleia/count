package cn.sicau.count.service.impl;

import cn.sicau.count.dao.SoloMapper;
import cn.sicau.count.dao.UserMapper;
import cn.sicau.count.domain.Solo;
import cn.sicau.count.domain.User;
import cn.sicau.count.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-4-4
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SoloMapper soloMapper;

    @Override
    public User login(User user) {
        return userMapper.selectByNamePass(user);
    }

    @Override
    public String addSoloScore(Solo solo) {
        Solo solo1=soloMapper.selectByUserNummberPro(solo);
        if (solo1!=null){
            return "error";
        }else {
            Integer i=soloMapper.insert(solo);
            if (i==1){
                return "success";
            }else {
                return "bug";
            }

        }
    }

    @Override
    public String updateSoloScore(Solo solo) {
        if (soloMapper.updateByPrimaryKeySelective(solo)==1){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public String  deleteScoreById(Integer id) {
        if (soloMapper.deleteByPrimaryKey(id)!=0){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public List<Solo> getAllSoloScore(Integer tempPage,Integer pageCapacity) {
        Map<String,Object> map=new HashMap<>();
        map.put("tempPage",tempPage);
        map.put("pageCapacity",pageCapacity);
        return soloMapper.getAllSoloScore(map);
    }

    @Override
    public Integer getCount() {
        return soloMapper.getCount();
    }


}

package cn.sicau.count.service.impl;

import cn.sicau.count.dao.AbstainMapper;
import cn.sicau.count.domain.Abstain;
import cn.sicau.count.service.AbstainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-4-8
 */
@Service("abstainService")
public class AbstainServiceImpl implements AbstainService{
    @Autowired
    private AbstainMapper abstainMapper;

    @Override
    public String addAbstain(Abstain abstain) {
        try {
            abstainMapper.insert(abstain);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @Override
    public String updateAbstain(Abstain abstain) {
        if (abstainMapper.updateByPrimaryKey(abstain)!=0){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public List<Abstain> getAll(Integer tempPage,Integer pageCapacity) {
        Map<String,Object> map=new HashMap<>();
        map.put("tempPage",tempPage);
        map.put("pageCapacity",pageCapacity);
        return abstainMapper.getAll(map);
    }

    @Override
    public void deleteById(Integer id) {
        abstainMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer count() {
        return abstainMapper.count();
    }

    @Override
    public Abstain getByClasses(String classes) {
        return abstainMapper.getByClasses(classes);
    }
}

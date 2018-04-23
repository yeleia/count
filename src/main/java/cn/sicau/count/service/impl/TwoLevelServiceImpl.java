package cn.sicau.count.service.impl;

import cn.sicau.count.dao.TwoLevelMapper;
import cn.sicau.count.domain.TwoLevel;
import cn.sicau.count.service.TwoLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-3-30
 */
@Service("twoLevelService")
public class TwoLevelServiceImpl implements TwoLevelService{
    @Autowired
    private TwoLevelMapper twoLevelMapper;

    @Override
    public String addTwoLevel(TwoLevel twoLevel) {
        if (twoLevelMapper.getByProSex(twoLevel)==null){
            twoLevelMapper.insert(twoLevel);
            return "success";
        }
            return "error";
        }


    @Override
    public String updateLevel(TwoLevel twoLevel) {
        try {
            twoLevelMapper.updateByPrimaryKeySelective(twoLevel);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @Override
    public List<TwoLevel> getAll(Integer tempPage,Integer pageCapacity) {
        Map<String,Object> map=new HashMap<>();
        map.put("tempPage",tempPage);
        map.put("pageCapacity",pageCapacity);
        return twoLevelMapper.getAll(map);
    }

    @Override
    public Integer deleteById(Integer id) {
         return  twoLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer count() {
        return twoLevelMapper.count();
    }

    @Override
    public TwoLevel getByProSex(TwoLevel twoLevel) {
        return twoLevelMapper.getByProSex(twoLevel);
    }
}

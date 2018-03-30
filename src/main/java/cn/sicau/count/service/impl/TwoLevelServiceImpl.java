package cn.sicau.count.service.impl;

import cn.sicau.count.dao.TwoLevelMapper;
import cn.sicau.count.domain.TwoLevel;
import cn.sicau.count.service.TwoLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        try {
            twoLevelMapper.insert(twoLevel);
            return "success";
        }catch (Exception e){
            return "error";
        }
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
    public List<TwoLevel> getAll() {
        return twoLevelMapper.getAll();
    }

    @Override
    public Integer deleteById(Integer id) {
         return  twoLevelMapper.deleteByPrimaryKey(id);
    }
}

package cn.sicau.count.service.impl;

import cn.sicau.count.dao.SoloMapper;
import cn.sicau.count.domain.Solo;
import cn.sicau.count.service.BoySoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-30
 */
@Service("soloService")
public class BoySoloServiceImpl implements BoySoloService {
    @Autowired
    private SoloMapper soloMapper;
    @Override
    public String addBoyHunderdScore(Solo solo) {
        try {
            soloMapper.insert(solo);
            return "success";
        }catch (Exception e){
            return "error";
        }
}

    @Override
    public String updateBoyHunderdScore(Solo solo) {
        try {
            soloMapper.updateByPrimaryKeySelective(solo);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @Override
    public Integer deleteById(Integer id) {

        return soloMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Solo> getAllBoyHundredScore() {
        return soloMapper.getAllBoyOneHundredScore();
    }
}

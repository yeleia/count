package cn.sicau.count.service.impl;

import cn.sicau.count.dao.SoloMapper;
import cn.sicau.count.domain.Solo;
import cn.sicau.count.service.SoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-30
 */
@Service("soloService")
public class SoloServiceImpl implements SoloService {
    @Autowired
    private SoloMapper soloMapper;

    @Override
    public Integer deleteById(Integer id) {

        return soloMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Solo> getSoloByParameter(Solo solo) {
        return soloMapper.getByParameter(solo);
    }

    @Override
    public List<Solo> getByCampusPro(Solo solo) {
        return soloMapper.getByCampusPro(solo);
    }

    @Override
    public List<Solo> getByCampusProAse(Solo solo) {
        return soloMapper.getByCampusProAse(solo);
    }

    @Override
    public List<Solo> getByAse(Solo solo) {
        return soloMapper.getByPaAse(solo);
    }

    @Override
    public void updateGradeById(Solo solo) {
        soloMapper.updateGradeById(solo);
    }

    @Override
    public Solo getById(Solo solo) {
        return soloMapper.selectByPrimaryKey(solo);
    }

    @Override
    public List<Solo> getByClasses(String classes) {
        return soloMapper.getByClasses(classes);
    }

    @Override
    public List<Solo> getAll() {
        return soloMapper.getAll();
    }

    @Override
    public List<Solo> getByStuNumber(String usernumber) {
        return soloMapper.getByStuNumber(usernumber);
    }

    @Override
    public List<Solo> getByProSex(Solo solo) {
        return soloMapper.getByProSex(solo);
    }

    @Override
    public List<Solo> getByProSexAsc(Solo solo) {
        return soloMapper.getByProSexAsc(solo);
    }


}

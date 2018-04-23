package cn.sicau.count.service.impl;

import cn.sicau.count.dao.FinalSoloMapper;
import cn.sicau.count.dao.SoloMapper;
import cn.sicau.count.domain.FinalSolo;
import cn.sicau.count.domain.Solo;
import cn.sicau.count.service.FinalSoloService;
import cn.sicau.count.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-4-8
 */
@Service("/finalSoloService")
public class FinalSoloServiceImpl implements FinalSoloService{
    @Autowired
    private FinalSoloMapper finalSoloMapper;
    @Autowired
    private SoloMapper soloMapper;

    @Override
    public List<FinalSolo> getByParameter(FinalSolo solo) {
        return finalSoloMapper.getByParameter(solo);
    }

    @Override
    public List<FinalSolo> getPaAse(FinalSolo finalSolo) {
        return finalSoloMapper.getByAse(finalSolo);
    }

    @Override
    public List<FinalSolo> getAll(Integer tempPage,Integer pageCapacity) {
        Map<String,Object> map=new HashMap<>();
        map.put("tempPage",tempPage);
        map.put("pageCapacity",pageCapacity);
        return finalSoloMapper.getAll(map);
    }

    @Override
    public Integer count() {
        return finalSoloMapper.count();
    }

    @Override
    public String addFinal(FinalSolo finalSolo) {
        if (finalSoloMapper.getByNumberPro(finalSolo)==null){
            Solo solo=new Solo();
            solo.setProject(finalSolo.getFinalproject());
            solo.setUsernumber(finalSolo.getStunumber());
            Solo s=soloMapper.selectByUserNummberPro(solo);
            if (s!=null) {
                if (s.getUsername().equals(finalSolo.getStuname())&&s.getUsersex().equals(finalSolo.getStusex())){
                finalSolo.setSoloid(s.getId());
                finalSoloMapper.insert(finalSolo);
                return "success";
            }else {
                    return "msg";
                }
            }else {
                return "bug";
            }
        }else {
            return "error";
        }
    }

    @Override
    public String updateFinal(FinalSolo finalSolo) {
        if (finalSoloMapper.updateByPrimaryKeySelective(finalSolo)!=0){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public String deleteById(Integer id) {
        if (finalSoloMapper.deleteByPrimaryKey(id)!=0){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public List<FinalSolo> getByPro(FinalSolo finalSolo) {
        return finalSoloMapper.getByPro(finalSolo);
    }

    @Override
    public List<FinalSolo> getByProAsc(FinalSolo finalSolo) {
        return finalSoloMapper.getByProAsc(finalSolo);
    }

    @Override
    public void updateFinalScoreById(FinalSolo finalSolo) {
        finalSoloMapper.updateFinalScoreById(finalSolo);
    }

    @Override
    public List<FinalSolo> getByClasses(String classes) {
        return finalSoloMapper.getByClasses(classes);
    }

    @Override
    public List<FinalSolo> getAll() {
        return finalSoloMapper.getAlls();
    }

    @Override
    public List<FinalSolo> getByStuNumber(String stunumber) {
        return finalSoloMapper.getByStuNumber(stunumber);
    }

    @Override
    public List<FinalSolo> getByProSex(FinalSolo finalSolo) {
        return finalSoloMapper.getByProSex(finalSolo);
    }

    @Override
    public List<FinalSolo> getByProSexAsc(FinalSolo finalSolo) {
        return finalSoloMapper.getByProSexAsc(finalSolo);
    }
}

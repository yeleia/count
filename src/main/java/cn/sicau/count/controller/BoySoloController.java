package cn.sicau.count.controller;

import cn.sicau.count.domain.Solo;
import cn.sicau.count.service.BoySoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-3-28
 */
@Controller
@RequestMapping("/boys")
public class BoySoloController {
    @Autowired
    private BoySoloService boySoloService;

    /**
     * 添加男生百米成绩
     * 不可添加两个相同学号的记录
     * @param solo
     * @return
     */
    @RequestMapping("/addOneHundredScore")
    @ResponseBody
    public Map<String,Object> addOneHundred(Solo solo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        solo.setProject("一百米");
        solo.setUsersex("0");
        String re=boySoloService.addBoyHunderdScore(solo);
        if ("success".equals(re)){
            resultMap.put("status",200);
            resultMap.put("message","添加成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该学号已经存在");
        }
        return resultMap;
    }

    /**
     * 修改男子一百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/updateOneHundredScore")
    @ResponseBody
    public Map<String,Object> updateOneHundredScore(Solo solo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=boySoloService.updateBoyHunderdScore(solo);
        if ("success".equals(re)){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该学号已经存在");
        }
        return resultMap;
    }

    /**
     * 根据id删除该一百米记录
     * @param id
     * @return
     */
    @RequestMapping("/deleteOneHundredScore")
    @ResponseBody
    public Map<String,Object> deleteOneHundredScore(@RequestParam(value = "id")Integer id){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if (boySoloService.deleteById(id)!=null){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
        }
        return resultMap;
    }

    /**
     *获取男生一百米跑的成绩
     * @return
     */
    @RequestMapping("/getAllOneHundredScore")
    @ResponseBody
    public Map<String,Object> getAllOneHundredScore(){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        List<Solo> solos=boySoloService.getAllBoyHundredScore();
        resultMap.put("solo",solos);
        return resultMap;
    }

}

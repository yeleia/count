package cn.sicau.count.controller;

import cn.sicau.count.domain.FinalSolo;
import cn.sicau.count.service.FinalSoloService;
import cn.sicau.count.utils.Page;
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
 * @date 18-4-8
 */
@Controller
@RequestMapping("/final")
public class FinalSoloController {
    /**
     *对决赛的操作
     */
    @Autowired
    private FinalSoloService finalSoloService;

    /**
     * 添加决赛成绩
     * @param page
     * @return
     */
    @RequestMapping("/getFinal")
    @ResponseBody
    public Map<String,Object> getAll(Page page){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        List<FinalSolo> finalSolos=finalSoloService.getAll(page.getTempPage()*page.getPageCapacity(),page.getPageCapacity());
        resultMap.put("finalSolo",finalSolos);
        resultMap.put("count",finalSoloService.count());
        return resultMap;
    }

    /**
     * 添加决赛成绩
     * @param finalSolo
     * @return
     */
    @RequestMapping("/addFinal")
    @ResponseBody
    public Map<String,Object> addFinal(FinalSolo finalSolo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=finalSoloService.addFinal(finalSolo);
            if ("success".equals(re)) {
                resultMap.put("status", 200);
                resultMap.put("message", "添加成功");
            }else if ("error".equals(re)){
                resultMap.put("status",500);
                resultMap.put("message","该学号的该项目已经存在");
            }else if ("msg".equals(re)){
                resultMap.put("status",405);
                resultMap.put("message","请输入该学生正确的信息");
            }else {
                resultMap.put("status",404);
                resultMap.put("message","该学生未在预赛名单中");
            }
            return resultMap;
    }

    /**
     * 更新决赛信息
     * @param finalSolo
     * @return
     */
    @RequestMapping("/updateFinal")
    @ResponseBody
    public Map<String,Object> updateFianl(FinalSolo finalSolo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if ("success".equals(finalSoloService.updateFinal(finalSolo))){
            resultMap.put("status",200);
            resultMap.put("message","更新成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","更新失败");
        }
        return resultMap;
    }

    /**
     * 根据id删除决赛信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public Map<String,Object> deleteById(@RequestParam(value = "id")Integer id){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if ("success".equals(finalSoloService.deleteById(id))){
            resultMap.put("status",200);
            resultMap.put("message","成功删除");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","删除失败");
        }
        return resultMap;
    }
}

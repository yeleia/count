package cn.sicau.count.controller;

import cn.sicau.count.domain.Abstain;
import cn.sicau.count.service.AbstainService;
import cn.sicau.count.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yelei
 * @date 18-4-8
 */

/**
 * 对弃权进行操作
 */
@Controller
@RequestMapping("/abstain")
public class AbstainController {
    @Autowired
    private AbstainService abstainService;
    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> add(Abstain abstain){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if ("success".equals(abstainService.addAbstain(abstain))){
            resultMap.put("status",200);
            resultMap.put("message","添加成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该学院弃权的人数已存在");
        }
        return resultMap;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Abstain abstain){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if ("success".equals(abstainService.updateAbstain(abstain))){
            resultMap.put("status",200);
            resultMap.put("message","修改成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","修改失败");
        }
        return resultMap;
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public Map<String,Object> getAll(Page page){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        resultMap.put("abstain",abstainService.getAll(page.getTempPage()*page.getPageCapacity(),page.getPageCapacity()));
        resultMap.put("count",abstainService.count());
        return resultMap;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,Object> deleteById(@RequestParam(value = "id")Integer id){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        abstainService.deleteById(id);
        resultMap.put("status",200);
        return resultMap;
    }
}

package cn.sicau.count.controller;

import cn.sicau.count.domain.Record;
import cn.sicau.count.domain.TwoLevel;
import cn.sicau.count.service.RecordService;
import cn.sicau.count.service.TwoLevelService;
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
 * @date 18-3-29
 */
@Controller
@RequestMapping("/system")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private TwoLevelService twoLevelService;

    /**
     * 添加校记录
     * @param record
     * @return
     */
    @RequestMapping("/schoolLevel/addRecord")
    @ResponseBody
    public Map<String,Object> addRecord(Record record){
        Map<String, Object> resultMap=new LinkedHashMap<>();
        String re=recordService.addSchoolRecord(record);
        //System.out.println(re);
        if ("success".equals(re)){
            resultMap.put("status",200);
            resultMap.put("message","添加成功");

        }else {
            System.out.println("该项目的记录已经存在");
            resultMap.put("status",500);
            resultMap.put("message","该项目的记录已经存在哦");
        }
        return resultMap;

    }

    /**
     * 更新校记录
     * @param record
     * @return
     */
    @RequestMapping("/schoolLevel/updateRecord")
    @ResponseBody
    public Map<String,Object> updateRecord(Record record){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=recordService.updateSchoolRecord(record);
        if ("success".equals(re)){
            resultMap.put("status",200);
            resultMap.put("message","修改成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该项目的记录已经存在哦");
        }
        return resultMap;
    }

    /**
     * 查看校记录
     * @return
     */
    @RequestMapping("/schoolLevel/getAll")
    @ResponseBody
    public Map<String,Object> getAllRecord(Page page){
        //System.out.println("yyyyyyyy");
        Map<String,Object> resultMap=new LinkedHashMap<>();
        List<Record> records=recordService.getAll(page.getTempPage()*page.getPageCapacity(),page.getPageCapacity());
        resultMap.put("record",records);
        resultMap.put("count",recordService.count());
        return resultMap;
    }

    /**
     * 删除校记录
     * @param id
     * @return
     */
    @RequestMapping("/schoolLevel/deleteRecord")
    @ResponseBody
    public Map<String,Object> deleteRecord(@RequestParam(value = "id")Integer id){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if (recordService.deleteRecord(id)!=null){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
        }
        return resultMap;
    }

    /**
     * 添加二级运动员标准
     * @param twoLevel
     * @return
     */
    @RequestMapping("/twoLevel/addRecord")
    @ResponseBody
    public Map<String,Object> twoAddRecord(TwoLevel twoLevel){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=twoLevelService.addTwoLevel(twoLevel);
        if ("success".equals(re)){
            resultMap.put("status",200);
            resultMap.put("message","添加成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该项目的二级标准已经存在");
        }
        return resultMap;
    }

    /**
     * 更新二级运动员标准
     * @param twoLevel
     * @return
     */
    @RequestMapping("/twoLevel/updateRecord")
    @ResponseBody
    public Map<String,Object> twoUpdateRecord(TwoLevel twoLevel){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=twoLevelService.updateLevel(twoLevel);
        if ("success".equals(re)){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
        }
        return resultMap;
    }

    /**
     * 得到二级运动员标准
     * @param
     * @return
     */
    @RequestMapping("/twoLevel/getAll")
    @ResponseBody
    public Map<String,Object> twoGetAll(Page page){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        List<TwoLevel> twoLevels=twoLevelService.getAll(page.getTempPage()*page.getPageCapacity(),page.getPageCapacity());
        resultMap.put("twoLevel",twoLevels);
        resultMap.put("count",twoLevelService.count());
        return resultMap;
    }

    /**
     * 删除二级运动员标准
     * @param id
     * @return
     */
    @RequestMapping("/teoLevel/deleteRecord")
    @ResponseBody
    public Map<String,Object> twoDeleteById(@RequestParam(value = "id")Integer id){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if (twoLevelService.deleteById(id)!=null){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
        }
        return resultMap;
    }


}

package cn.sicau.count.controller;

import cn.sicau.count.domain.Record;
import cn.sicau.count.service.RecordService;
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
        if ("success".equals(re)){
            resultMap.put("status",200);
        }else {
            System.out.println("该项目的记录已经存在");
            resultMap.put("status",500);
        }
        return resultMap;

    }
    @RequestMapping("/schoolLevel/updateRecord")
    @ResponseBody
    public Map<String,Object> updateRecord(Record record){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=recordService.updateSchoolRecord(record);
        if ("success".equals(re)){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
        }
        return resultMap;
    }
    @RequestMapping("/schoolLevel/getAll")
    @ResponseBody
    public Map<String,Object> getAllRecord(){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        List<Record> records=recordService.getAll();
        resultMap.put("record",records);
        return resultMap;
    }
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


}

package cn.sicau.count.controller;

import cn.sicau.count.domain.Solo;
import cn.sicau.count.service.SoloService;
import cn.sicau.count.utils.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yelei
 * @date 18-4-1
 */
@Controller
@RequestMapping("/girl")
public class GirlSoloController {
    @Autowired
    private SoloService girlSoloService;

    /**
     * 添加女子一百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addOneHundredScore")
    @ResponseBody
    public Map<String,Object> addOneHundredScore(Solo solo){
        solo.setUsersex("1");
        solo.setProject("一百米");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的一百米成绩已经存在");
        }
    }

    /**
     * 添加女子两百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addTwoHundredScore")
    @ResponseBody
    public Map<String,Object> addTwoHundredScore(Solo solo){
        solo.setProject("两百米");
        solo.setUsersex("1");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的两百米成绩已经存在");
        }
    }

    /**
     * 添加女子四百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addFourHundredScore")
    @ResponseBody
    public Map<String,Object> addFourHundredScore(Solo solo){
        solo.setUsersex("1");
        solo.setProject("四百米");
        String  re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的四百米成绩已经存在");
        }
    }

    /**
     * 添加女子八百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addEightHundredScore")
    @ResponseBody
    public Map<String,Object> addEightHundredScore(Solo solo){
        solo.setProject("八百米");
        solo.setUsersex("1");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的八百米成绩已经存在");
        }
    }

    /**
     * 添加女子一千五百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addOneFiveHundredScore")
    @ResponseBody
    public Map<String,Object> addOneFiveHundredScore(Solo solo){
        solo.setUsersex("1");
        solo.setProject("一千五百米");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的一千五百米成绩已经存在");
        }
    }

    /**
     * 女子跳高
     * @param solo
     * @return
     */
    @RequestMapping("/addJumpScore")
    @ResponseBody
    public Map<String,Object> addJumpScore(Solo solo){
        solo.setProject("跳高");
        solo.setUsersex("1");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的跳高成绩已经存在");
        }
    }

    /**
     * 添加女子跳远成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addLongJumpScore")
    @ResponseBody
    public Map<String,Object> addLongJumpScore(Solo solo){
        solo.setUsersex("1");
        solo.setProject("跳远");
        String re=girlSoloService.addSoloScore(solo);
        if("success".equals(re)){
            return  ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的跳远成绩已经存在");
        }
    }

    /**
     * 添加女子三级跳远成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addTreeLevelJumpScore")
    @ResponseBody
    public Map<String,Object> addTreeLevelJumpScore(Solo solo){
        solo.setProject("三级跳远");
        solo.setUsersex("1");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的三级跳远成绩已经存在");
        }
    }

    /**
     * 添加女子铅球成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addShutScore")
    @ResponseBody
    public Map<String,Object> addShutScore(Solo solo){
        solo.setProject("铅球");
        solo.setUsersex("1");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的铅球成绩已经存在");
        }
    }

    /**
     * 添加女子4x100米接力成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addFourAndHundredScore")
    @ResponseBody
    public Map<String,Object> addFourAndHundredScore(Solo solo){
        solo.setProject("4x100");
        solo.setUsersex("1");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的４x100米接力成绩已经存在");
        }
    }

    /**]
     * 添加女子4x400米接力成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addFourAndFourHundredScore")
    @ResponseBody
    public Map<String,Object> addFourAndFourHundredScore(Solo solo){
        solo.setUsersex("1");
        solo.setProject("4x400");
        String re=girlSoloService.addSoloScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的4x400米接力成绩已经存在");
        }
    }

    /**
     * 根据id修改女子单项成绩
     * @param solo
     * @return
     */
    @RequestMapping("/updateOneHundredScore")
    @ResponseBody
    public Map<String,Object> updateOneHundredScore(Solo solo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=girlSoloService.updateSoloScore(solo);
        if ("success".equals(re)){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该学号已经存在");
        }
        return resultMap;
    }



}

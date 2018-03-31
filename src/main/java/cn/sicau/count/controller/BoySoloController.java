package cn.sicau.count.controller;

import cn.sicau.count.domain.Solo;
import cn.sicau.count.service.BoySoloService;
import cn.sicau.count.utils.ReturnMap;
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
        solo.setProject("一百米");
        solo.setUsersex("0");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的男子一百米成绩已经存在");
        }
    }

    /**
     * 添加男子两百米记录
     * @param solo
     * @return
     */
    @RequestMapping("/addTwoHundredScore")
    @ResponseBody
    public Map<String,Object> addTwoHundredScore(Solo solo){
        solo.setProject("两百米");
        solo.setUsersex("0");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的两百米成绩已经存在");
        }
    }

    /**\
     *
     * 添加男子四百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addFourHundredScore")
    @ResponseBody
    public Map<String,Object> addFourHundredScore(Solo solo){
        solo.setProject("四百米");
        solo.setUsersex("0");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的四百米成绩已经存在");

        }
    }

    /**
     * 添加男子八百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addEightHundredScore")
    @ResponseBody
    public Map<String,Object> addEightHundredScore(Solo solo){
        solo.setUsersex("0");
        solo.setProject("八百米");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的八百米成绩已经存在");
        }
    }

    /**
     * 添加男子一千五百米成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addOneFiveHundredScore")
    @ResponseBody
    public Map<String,Object> addOneFiveHundredScore(Solo solo){
        solo.setProject("一千五百米");
        solo.setUsersex("0");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");

        }else {
            return ReturnMap.resultMap(500,"该学号一千五百米的成绩已经存在");
        }
    }

    /**
     * 添加男子跳高成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addJumpScore")
    @ResponseBody
    public Map<String,Object> addJumpScore(Solo solo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        solo.setUsersex("0");
        solo.setProject("跳高");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的跳高成绩已经存在");
        }
    }

    /**
     * 添加男子跳远成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addLongJumpScore")
    public Map<String,Object> addLongJumpScore(Solo solo){
        solo.setProject("跳远");
        solo.setUsersex("0");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的跳远成绩以及存在");
        }

    }

    /**
     * 添加三级跳远的成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addTreeLevelJumpScore")
    @ResponseBody
    public Map<String,Object> addTreeLevelJumpScore(Solo solo){
        solo.setUsersex("0");
        solo.setProject("三级跳远");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
           return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的三级跳远已经存在");
        }
    }

    /**
     * 添加男子铅球成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addShutScore")
    @ResponseBody
    public Map<String,Object> resultMap(Solo solo){
        solo.setProject("铅球");
        solo.setUsersex("0");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的铅球成绩已经存在");
        }
    }

    /**
     * 添加男子４X１00米接力成绩
     * 只添加队长的成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addFourAndHundredScore")
    @ResponseBody
    public Map<String,Object> addFourAndHundredScore(Solo solo){
        solo.setUsersex("0");
        solo.setProject("4x100");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的４x100米接力成绩已经存在");
        }
    }

    /**
     * 添加男子4x400米接力的成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addFourAndFourHundredScore")
    @ResponseBody
    public Map<String,Object> addFourAndFourHundredScore(Solo solo){
        solo.setProject("4x400");
        solo.setUsersex("0");
        String re=boySoloService.addBoyScore(solo);
        if ("success".equals(re)){
            return ReturnMap.resultMap(200,"添加成功");
        }else {
            return ReturnMap.resultMap(500,"该学号的4x400米的接力成绩已经存在");
        }

    }


    /**
     * 修改男子单项成绩
     * @param solo
     * @return
     */
    @RequestMapping("/updateOneHundredScore")
    @ResponseBody
    public Map<String,Object> updateOneHundredScore(Solo solo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=boySoloService.updateBoyScore(solo);
        if ("success".equals(re)){
            resultMap.put("status",200);
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该学号已经存在");
        }
        return resultMap;
    }

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    @RequestMapping("/deleteOneHundredScore")
    @ResponseBody
    public Map<String,Object> deleteOneHundredScore(@RequestParam(value = "id")Integer id){
        if (boySoloService.deleteById(id)!=null){
            return ReturnMap.resultMap(200,"删除成功");
        }else {
            return ReturnMap.resultMap(500,"删除失败");
        }
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

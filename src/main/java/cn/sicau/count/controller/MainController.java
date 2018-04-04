package cn.sicau.count.controller;

import cn.sicau.count.domain.Solo;
import cn.sicau.count.domain.User;
import cn.sicau.count.service.UserService;
import cn.sicau.count.utils.Encryption;
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
 * @date 18-4-4
 */
@Controller
@RequestMapping("/solo")
public class MainController {
    @Autowired
    private UserService userService;

    /**
     *根据username和password登录
     * @param user
     * @return
     */
    @RequestMapping("/sysLogin")
    @ResponseBody
    public Map<String,Object> sysLogin(User user){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        user.setPassword(Encryption.md5(user.getPassword()));
        User user1=userService.login(user);
        if (user1!=null){
            resultMap.put("status",500);
            resultMap.put("message","请输入正确的帐号");
        }else {
            resultMap.put("status",200);
            resultMap.put("message","登录成功");
        }
        return resultMap;
    }

    /**
     * 添加单项成绩，不允许同一个学号录入同一个项目的成绩
     * @param solo
     * @return
     */
    @RequestMapping("/addSoloScore")
    @ResponseBody
    public Map<String,Object> addSoloScore(Solo solo){

        Map<String,Object> resultMap=new LinkedHashMap<>();
            String re=userService.addSoloScore(solo);
            if ("success".equals(re)){
                resultMap.put("status",200);
                resultMap.put("message","添加成功");
            }else {
                resultMap.put("status",500);
                resultMap.put("message","添加失败，该学号的该项目成绩已经记录");
            }
        return resultMap;
    }

    /**
     * 修改单项成绩
     * @param solo
     * @return
     */
    @RequestMapping("/updateSoloScore")
    @ResponseBody
    public Map<String,Object>  updateSoloScore(Solo solo){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=userService.updateSoloScore(solo);
        if ("success".equals(re)){
            resultMap.put("status",200);
            resultMap.put("message","修改成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","修改失败");
        }
        return resultMap;
    }

    /**
     * 根据id删除单项成绩
     * @param id
     * @return
     */
    @RequestMapping("/deleteSoloScore")
    @ResponseBody
    public Map<String,Object> deleteSoloScore(@RequestParam(value = "id")Integer id){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=userService.deleteScoreById(id);
        if ("success".equals(re)){
            resultMap.put("status",200);
            resultMap.put("message","删除成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","删除失败");
        }
        return resultMap;
    }
    @RequestMapping("/getAllSoloScore")
    @ResponseBody
    public Map<String,Object> getAllSoloScore(){
       Map<String,Object> resultMap=new LinkedHashMap<>();
       List<Solo> solos=userService.getAllSoloScore();
       resultMap.put("solo",solos);
       return resultMap;
    }

}

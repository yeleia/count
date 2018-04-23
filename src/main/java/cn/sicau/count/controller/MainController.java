package cn.sicau.count.controller;

import cn.sicau.count.domain.*;
import cn.sicau.count.service.FinalSoloService;
import cn.sicau.count.service.StudentService;
import cn.sicau.count.service.UserService;
import cn.sicau.count.utils.Encryption;
import cn.sicau.count.utils.JsonUtil;
import cn.sicau.count.utils.Page;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private StudentService studentService;
    @Autowired
    private FinalSoloService finalSoloService;

    /**
     *根据username和password登录
     * @param user
     * @return
     */
    @RequestMapping("/sysLogin")
    @ResponseBody
    public Map<String,Object> sysLogin(User user){
        Map<String,Object> resultMap=new LinkedHashMap<>();
       // System.out.println(user.getPassword());
        user.setPassword(Encryption.md5(user.getPassword()));
     //   System.out.println(user.getPassword());
        User user1=userService.login(user);
        if (user1==null){
            resultMap.put("status",500);
            resultMap.put("message","请输入正确的帐号");
        }else {
            resultMap.put("status",200);
            resultMap.put("message","登录成功");
        }
        return resultMap;
    }

    /**
     * 根据学号查询学生的信息
     * @param stuNumber
     * @return
     */
    @RequestMapping("/getStuMessage")
    @ResponseBody
    public Map<String,Object> getMessageByN(@RequestParam(value = "stuNumber")String stuNumber){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        Student student=studentService.getByStuNumber(stuNumber);
        if (student!=null){
            try {
                student.setStucampus(JsonUtil.getKeyByValue(student.getStucampus()));
                student.setStuclasses(JsonUtil.getKeyByValue(student.getStuclasses()));
                student.setStuprofession(JsonUtil.getKeyByValue(student.getStuprofession()));
            }catch (Exception e){
                student.setStucampus("");
                student.setStuprofession("");
                student.setStuclasses("");
            }

            resultMap.put("status",200);
            resultMap.put("student",student);
        }else {
            resultMap.put("status",500);
            resultMap.put("message","该学号不存在");
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
            }else{
                resultMap.put("status",500);
                resultMap.put("message","添加失败，该学号的该项目成绩已经记录");
            }
        return resultMap;
    }
    @RequestMapping("/addSolos")
    @ResponseBody
    public Map<String,Object> addSolos(@RequestParam(value = "stuScores")String o){
        JSONArray jsonArray=JSONArray.fromObject(o);
        List<Solo> solos=new ArrayList<>();
        for (int i=0;i<jsonArray.size();i++){
            Solo solo=new Solo();
            JSONObject json=new JSONObject();
            json= JSONObject.fromObject(jsonArray.getString(i));
            solo.setCampus(json.getString("campus"));
            solo.setClasses(json.getString("classes"));
            solo.setProject(json.getString("project"));
            solo.setProfession(json.getString("profession"));
            solo.setUsername(json.getString("username"));
            solo.setUsersex(json.getString("usersex"));
            solo.setUsernumber(json.getString("usernumber"));
            solo.setScore(json.getString("score"));
            solos.add(solo);
        }

        Map<String,Object> resultMap=new LinkedHashMap<>();
        List<Solo> solos1=new ArrayList<>();
        for (int i=0;i<solos.size();i++){
            String re=userService.addSoloScore(solos.get(i));
            if ("error".equals(re)){
               solos1.add(solos.get(i));
            }
        }
        if (solos1.size()>0){
            resultMap.put("status",500);
            resultMap.put("solos",solos1);
        }else {
            resultMap.put("status",200);
            resultMap.put("message","添加成功");
        }


        return resultMap;
    }
    @RequestMapping("/addFinalS")
    @ResponseBody
    public Map<String,Object> addFinals(@RequestParam(value = "stuScores")String o){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        JSONArray jsonArray=JSONArray.fromObject(o);
        List<FinalSolo> finalSolos=new ArrayList<>();
        for (int i=0;i<jsonArray.size();i++){
            JSONObject json=new JSONObject();
            json= JSONObject.fromObject(jsonArray.getString(i));
            FinalSolo finalSolo=new FinalSolo();
            finalSolo.setFinalcampus(json.getString("campus"));
            finalSolo.setFinalclasses(json.getString("classes"));
            finalSolo.setFinalprofession(json.getString("profession"));
            finalSolo.setFinalproject(json.getString("project"));
            finalSolo.setStuname(json.getString("username"));
            finalSolo.setStunumber(json.getString("usernumber"));
            finalSolo.setStusex(json.getString("usersex"));
            finalSolo.setSecscore(json.getString("score"));
            finalSolos.add(finalSolo);
        }
        List<FinalSolo> finalSolos1=new ArrayList<>();
        for (int i=0;i<finalSolos.size();i++){
            String re=finalSoloService.addFinal(finalSolos.get(i));
            if ("success".equals(re)==false){
               finalSolos1.add(finalSolos.get(i));
            }
        }
        if (finalSolos1.size()>0){
            resultMap.put("status",500);
            resultMap.put("finalSolo",finalSolos1);
        }else {
            resultMap.put("status",200);
            resultMap.put("message","添加成功");
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
    @PostMapping("/deleteSoloScore")
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
    public Map<String,Object> getAllSoloScore(Page page){
       Map<String,Object> resultMap=new LinkedHashMap<>();
       List<Solo> solos=userService.getAllSoloScore(page.getTempPage()*page.getPageCapacity(),page.getPageCapacity());
       resultMap.put("solo",solos);
       resultMap.put("count",userService.getCount());
       return resultMap;
    }


}

package cn.sicau.count;

import cn.sicau.count.dao.FinalSoloMapper;
import cn.sicau.count.dao.RecordMapper;
import cn.sicau.count.dao.SoloMapper;
import cn.sicau.count.dao.UserMapper;
import cn.sicau.count.domain.FinalSolo;
import cn.sicau.count.domain.Record;
import cn.sicau.count.domain.Solo;
import cn.sicau.count.domain.User;
import cn.sicau.count.service.UserService;
import cn.sicau.count.utils.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountApplicationTests {
	@Autowired
	private RecordMapper recordMapper;
	@Autowired
	private SoloMapper soloMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FinalSoloMapper finalSoloMapper;
	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test(){
		Record record=new Record();
		record.setReproject("001001");
		/*record.setRecord(102.0);*/
		record.setRecordsex("男");
		try {
			recordMapper.insert(record);
		}catch (Exception e){
			System.out.println("已经存在该项项目");
		}
	}
	@Test
	public void addUser(){
		User user=new User();
		user.setUsername("sicau");
		user.setPassword(Encryption.md5("sicau"));
		userMapper.insert(user);
	}
	@Test
	public void tet(){
		FinalSolo solo=new FinalSolo();
		/*solo.setFinalcampus("雅安");*/
		solo.setFinalproject("一百米");
		solo.setStusex("男");
		List<FinalSolo> finalSolos=finalSoloMapper.getByParameter(solo);
		for (int i=0;i<finalSolos.size();i++){
			System.out.println(finalSolos.get(i));
		}
	}
	@Test
	public void update(){
		FinalSolo finalSolo=new FinalSolo();
		finalSolo.setFinalgrade(20.0);
		finalSolo.setFinalscore(20.0);
		finalSolo.setId(1);
		System.out.println(finalSoloMapper.updateFinalScoreById(finalSolo));
	}
	@Test
	public void addSolos(){
		Solo solo=new Solo();
		solo.setUsersex("女");
		solo.setCampus("001");
		Solo solo1=new Solo();
		solo1.setCampus("002");
		solo1.setUsersex("男");
		List<Solo> solos=new ArrayList<>();
		solos.add(solo);
		solos.add(solo1);

	}

}

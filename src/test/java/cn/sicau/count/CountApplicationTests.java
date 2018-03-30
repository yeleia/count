package cn.sicau.count;

import cn.sicau.count.dao.RecordMapper;
import cn.sicau.count.dao.SoloMapper;
import cn.sicau.count.domain.Record;
import cn.sicau.count.domain.Solo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountApplicationTests {
	@Autowired
	private RecordMapper recordMapper;
	@Autowired
	private SoloMapper soloMapper;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test(){
		Record record=new Record();
		record.setReproject("100m");
		record.setRecord(22.0);
		record.setRecordsex("0");
		try {
			recordMapper.insert(record);
		}catch (Exception e){
			System.out.println("已经存在该项项目");
		}
	}
	@Test
	public void add(){
		Solo solo=new Solo();
		solo.setCampus("雅安");
		solo.setProject("一百米");
		solo.setClasses("信息工程学院");
		solo.setUsersex("男");
		solo.setUsername("test");
		solo.setScore(2.4);
		solo.setUsernumber("20158618");
		soloMapper.insert(solo);
	}
	@Test
	public void get(){
		List<Solo> solo=soloMapper.getAllBoyOneHundredScore();
		for (Solo solo1:solo){
			System.out.println(solo1.getCampus()+"dfhfgh");
		}
	}

}

package cn.sicau.count;

import cn.sicau.count.dao.RecordMapper;
import cn.sicau.count.domain.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountApplicationTests {
	@Autowired
	private RecordMapper recordMapper;
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

}

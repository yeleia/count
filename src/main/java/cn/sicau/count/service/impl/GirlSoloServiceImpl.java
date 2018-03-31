package cn.sicau.count.service.impl;

import cn.sicau.count.dao.SoloMapper;
import cn.sicau.count.service.GirlSoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yelei
 * @date 18-3-31
 */
@Service("girlSoloService")
public class GirlSoloServiceImpl implements GirlSoloService{
    @Autowired
    private SoloMapper soloMapper;

}

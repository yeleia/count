package cn.sicau.count.service;

import cn.sicau.count.domain.Solo;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-30
 */
public interface BoySoloService {
     String addBoyHunderdScore(Solo solo);
     String updateBoyHunderdScore(Solo solo);
     Integer deleteById(Integer id);
     List<Solo> getAllBoyHundredScore();
}

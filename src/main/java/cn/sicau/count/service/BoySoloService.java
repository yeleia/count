package cn.sicau.count.service;

import cn.sicau.count.domain.Solo;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-30
 */
public interface BoySoloService {
     String addBoyScore(Solo solo);
     String updateBoyScore(Solo solo);
     Integer deleteById(Integer id);
     List<Solo> getAllBoyHundredScore();
}

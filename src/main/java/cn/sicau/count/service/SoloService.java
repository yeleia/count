package cn.sicau.count.service;

import cn.sicau.count.domain.Solo;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-30
 */
public interface SoloService {
     String addSoloScore(Solo solo);
     String updateSoloScore(Solo solo);
     Integer deleteById(Integer id);
     List<Solo> getAllBoyHundredScore();
}

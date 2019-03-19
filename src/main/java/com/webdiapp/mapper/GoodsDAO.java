package com.webdiapp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.webdiapp.entities.Goods;

public interface GoodsDAO {
    
    public List<Goods> getGoodsPager(@Param("skip") int skip,@Param("size") int size);
    
    public Goods getGoodsById(int id);
    
    public int getGoodsCount();
    
    public int insert(Goods entity);
    
    public int delete(int id);
    
    public int update(Goods entity);
    
}
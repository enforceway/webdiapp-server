package com.webdiapp.services;

import java.util.List;
import com.webdiapp.entities.Goods;

/**
 * ��Ʒҵ��ӿ�
 *
 */
public interface GoodsService {

    //��ҳ
    List<Goods> getGoodsPager(int pageNO, int size);

    //��õ�����Ʒ����
    Goods getGoodsById(int id);
    
    //�����Ʒ����
    int getGoodsCount();

    //���
    int insert(Goods entity);

    //ɾ������
    int delete(int id);

    //ɾ�����
    int deletes(int[] ids);

    //����
    int update(Goods entity);

}
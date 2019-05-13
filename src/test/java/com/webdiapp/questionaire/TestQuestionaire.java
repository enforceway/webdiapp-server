package com.webdiapp.questionaire;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.mapper.QuestionaireDAO;
import com.webdiapp.util.MyBatisUtil;

import junit.framework.Assert;

public class TestQuestionaire {

    @Test
    public void getQuestionaireListOnPaging() {
        int skip = 1;
        int size = 5;
        SqlSession session = MyBatisUtil.getSession();
        try {
        	QuestionaireDAO dao = session.getMapper(QuestionaireDAO.class);
        	System.out.println("dao:" + dao.hashCode());
            List<Questionaire> list = dao.getList(skip, size);
            Assert.assertTrue(list.size() >= 0);
        } finally {
            session.close();
        }
    }
//
//    @Test
//    public void getGoodsByIdTest() {
//        SqlSession session=MyBatisUtil.getSession();
//        try {
//            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
//            Goods goods=bookdao.getGoodsById(1);
//            Assert.assertEquals(1, goods.getId());
//        } finally {
//            session.close();
//        }
//    }
//    
//    @Test
//    public void getGoodsCountTest() {
//        SqlSession session=MyBatisUtil.getSession();
//        try {
//            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
//            Assert.assertEquals(9, bookdao.getGoodsCount());
//        } finally {
//            session.close();
//        }
//    }
//    
//    @Test
//    public void insertTest() {
//        SqlSession session=MyBatisUtil.getSession();
//        try {
//            Goods entity=new Goods();
//            entity.setName("m俺妈说说名字必须的长");
//            entity.setPrice(108);
//            entity.setPicture("nopic.jpg");
//            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
//            Assert.assertEquals(18, bookdao.insert(entity));
//        } finally {
//            session.close();
//        }
//    }
//
//    @Test
//    public void deleteTest() {
//        SqlSession session=MyBatisUtil.getSession();
//        try {
//            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
//            Assert.assertEquals(8, bookdao.delete(12));
//        } finally {
//            session.close();
//        }
//    }
//
//    @Test
//    public void update() {
//        SqlSession session=MyBatisUtil.getSession();
//        try {
//            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
//            Goods entity=bookdao.getGoodsById(3);
//            entity.setName("名字一定要超级的长");
//            entity.setPrice(107);
//            entity.setPicture("nopicture.jpg");
//
//            Assert.assertEquals(1, bookdao.update(entity));
//        } finally {
//            session.close();
//        }
//    }
    
}
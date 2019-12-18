package com.webdiapp.userrole;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.webdiapp.entities.Questionaire;
import com.webdiapp.entities.User;
import com.webdiapp.mapper.QuestionaireDAO;
import com.webdiapp.mapper.UserAccessDAO;
import com.webdiapp.util.MyBatisUtil;

import junit.framework.Assert;

public class TestUserRole {

    @Test
    public void findUserByUsername() {
        SqlSession session = MyBatisUtil.getSession();
        System.out.println("session:" + session.hashCode());
        try {
        	UserAccessDAO userAccess = session.getMapper(UserAccessDAO.class);
        	User user = new User();
        	List<User> users = userAccess.findUserByUserModel(user);
        	System.out.println("Users:" + JSON.toJSONString(users));
            Assert.assertEquals(1, users.size());
        } finally {
            session.close();
        }
    }
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
package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.ICommentDao;
import com.eshop.dao.pojo.Comment;

@Repository("commentDao")
public class DaoCommentImpl implements ICommentDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Comment t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Comment t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Comment t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByOrderItemId(int orderItemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findByCommentStatus(int commentStatus) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

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
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(Comment t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(Comment t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<Comment> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Comment").list();
	}

	@Override
	public Comment findById(Integer k) throws Exception {
		return (Comment) sessionFactory.getCurrentSession().createQuery("from Comment c where c.commentId=:commentId")
				.setParameter("commntId", k).uniqueResult();
	}

	@Override
	public List<Comment> findByOrderItemId(int orderItemId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Comment c where c.orderItemId=:orderItemId")
				.setParameter("orderItemId", orderItemId).list();
	}

	@Override
	public List<Comment> findByUserId(int userId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Comment c where c.userId=:userId")
				.setParameter("userId", userId).list();
	}

	@Override
	public List<Comment> findByCommentStatus(int commentStatus) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Comment c where c.commentStatus=:commentStatus")
				.setParameter("commentStatus", commentStatus).list();
	}

}

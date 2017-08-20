package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.ICommentDao;
import com.eshop.dao.pojo.Comment;
import com.eshop.service.iservice.ICommentService;

@Service("commentService")
public class ServiceCommentImpl implements ICommentService {

	@Autowired
	@Qualifier("commentDao")
	private ICommentDao commentDao;

	@Transactional
	@Override
	public String save(Comment t) {
		String msg = "error";
		try {
				commentDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Comment t) {
		String msg = "error";
		try {
				commentDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Comment t) {
		String msg = "error";
		try {
				commentDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Comment> findAll() {
		List<Comment> CommentList = null;
		try {
			CommentList = commentDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommentList;
	}

	@Transactional(readOnly=true)
	@Override
	public Comment findById(Integer k) {
		Comment Comment = null;
		try {
			Comment = commentDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Comment;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Comment> findByOrderItemId(int orderItemId) {
		// TODO Auto-generated method stub
		List<Comment> commentList = null;
		try {
			commentList =  commentDao.findByOrderItemId(orderItemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Comment> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Comment> commentList = null;
		try {
			commentList =  commentDao.findByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Comment> findByCommentStatus(int commentStatus) {
		// TODO Auto-generated method stub
		List<Comment> commentList = null;
		try {
			commentList =  commentDao.findByCommentStatus(commentStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentList;
	}

}

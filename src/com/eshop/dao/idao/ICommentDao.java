package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.Comment;

public interface ICommentDao extends IBaseDao<Comment, Integer	> {
		//根据 orderItemId进行查询
		List<Comment> findByOrderItemId(int orderItemId) throws Exception;
		//根据 userId进行查询
		List<Comment> findByUserId(int userId) throws Exception;
	
		//根据 CommentStatus进行查询
		List<Comment> findByCommentStatus(int commentStatus) throws Exception;
	
	
}

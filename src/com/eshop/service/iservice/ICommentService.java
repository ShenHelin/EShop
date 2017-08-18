package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.Comment;

public interface ICommentService extends IBaseService<Comment, Integer	> {
		//根据 orderItemId进行查询
		List<Comment> findByOrderItemId(int orderItemId) ;
		//根据 userId进行查询
		List<Comment> findByUserId(int userId) ;
	
		//根据 CommentStatus进行查询
		List<Comment> findByCommentStatus(int commentStatus) ;
	
	
}

package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.Account;
import com.eshop.dao.pojo.Comment;
import com.eshop.service.iservice.ICommentService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("commentAction")
@Scope("prototype")
public class CommentAction implements ModelDriven<Comment>, RequestAware{
	
	@Autowired
	@Qualifier("commentService")
	private ICommentService commentService;	
	
	private Comment comment = new Comment();
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	@Override
	public Comment getModel() {
		// TODO Auto-generated method stub
		return comment;
	}
	
}	

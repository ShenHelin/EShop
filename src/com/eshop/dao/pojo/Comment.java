package com.eshop.dao.pojo;

import java.io.Serializable;

public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int CommentId;
	private String content;
	private String date;
	private String commentStatus;
	private OrderItem orderItem;
	private User user;
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		CommentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment(String content, String date, String commentStatus) {
		super();
		this.content = content;
		this.date = date;
		this.commentStatus = commentStatus;
	}
	public Comment() {
		super();
	}
	@Override
	public String toString() {
		return "Comment [CommentId=" + CommentId + ", content=" + content + ", date=" + date + ", commentStatus="
				+ commentStatus + ", orderItem=" + orderItem.getOrderItemId() + ", user=" + user.getUserId() + "]";
	}
	
	
	
}

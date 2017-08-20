package com.eshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.Goods;
import com.eshop.service.iservice.IGoodsService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ModelDriven;

@Controller("goodsAction")
@Scope("prototype")
public class GoodsAction implements ModelDriven<Goods>, RequestAware,ServletResponseAware{
	
	@Autowired
	@Qualifier("goodsService")
	private IGoodsService goodsService;
	private Goods goods = new Goods();
	private String option;// ִ�����ͣ�findById����update
	
	@Override
	public Goods getModel() {
		// TODO Auto-generated method stub
		return goods;
	}
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	private HttpServletResponse response; 
	//private Map<String, Object> response;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	public String getOption() {
		return option;
	}
	
	public String save() {
		return goodsService.save(goods);
	}

	public String update() {
		return goodsService.update(goods);
	}

	public String delete() {
		return goodsService.delete(goods);
	}

	public String findAll() throws IOException {
		String msg = "error";
		List<Goods> goodsList = goodsService.findAll();
		if (goodsList != null && goodsList.size() > 0) {
			request.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		
		Gson gson = new Gson();
		String result = gson.toJson(goodsList.toString());
		PrintWriter out = response.getWriter();
		out.println(result);
		return msg;
	}

	public String findById() {
		String msg = "error";
		Goods p = goodsService.findById(goods.getGoodsId());
		if (p != null) {
			if ("update".equals(option)) {
				request.put("goodsFromServer", p);
				msg = "updatesuccess";
			} else {
				List<Goods> goodsList = new ArrayList<Goods>();
				goodsList.add(p);
				request.put("goodsListFromServer", goodsList);
				msg = "success";
			}
		}
		return msg;
	}
	
	
	
	
	
	
}

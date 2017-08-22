package com.eshop.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.Admin;
import com.eshop.dao.pojo.Goods;
import com.eshop.service.iservice.IAdminService;
import com.eshop.service.iservice.IGoodsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("goodsAction")
@Scope("prototype")
public class GoodsAction extends ActionSupport implements ModelDriven<Goods>, RequestAware,ServletResponseAware,Serializable {
	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "/upload/";
	
	
	@Autowired
	@Qualifier("goodsService")
	private IGoodsService goodsService;
	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;
	private Goods goods = new Goods();
	private String option;
	
	
	
	
	
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
		
		Admin admin = adminService.findById(1);
		//System.out.println("adminId in Dao: "+admin.getAdminId());
		goods.setAdmin(admin);
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
		
//		Gson gson = new Gson();
//		String result = gson.toJson(goodsList.toString());
//		PrintWriter out = response.getWriter();
//		out.println(result);
		
		return msg;
	}

	public String findById() {
		String msg = "error";
		Goods p = goodsService.findById(goods.getGoodsId());
		List<Goods> goodsList = null;
		if (p != null) {
			if ("update".equals(option)) {
				request.put("goodsFromServer", p);
				msg = "updatesuccess";
			} else {
				goodsList = new ArrayList<Goods>();
				goodsList.add(p);
				request.put("goodsListFromServer", goodsList);
				msg = "findByIdSuccess";
			}
		}
		request.put("goodsFromServer", p);
		return msg;
	}
	
	public String findByGoodsName() {
		String msg = "error";
		List<Goods> goodsList = goodsService.findByGoodsName(goods.getGoodsName());
		if(goodsList != null && goodsList.size()>0){
			request.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return msg;
	}
	
	public String findByPrice() {
		String msg = "error";
		List<Goods> goodsList = goodsService.findByPrice(goods.getPrice(), goods.getPrice()+100);
		if(goodsList != null && goodsList.size()>0){
			request.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return msg;
	}
	
	public String findByRegTime(){
		// TODO Auto-generated method stub
		String msg = "error";
		List<Goods> goodsList = goodsService.findByRegTime(goods.getRegTime());
		if(goodsList != null && goodsList.size()>0){
			request.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return msg;
	}

	public String findByAdminId() {
		// TODO Auto-generated method stub
		//goods.getAdmin().getAdminId()
		String msg = "error";
		List<Goods> goodsList = goodsService.findByAdminId(1);
		if(goodsList != null && goodsList.size()>0){
			request.put("adminGoodsListFromServer", goodsList);
			msg = "adminGoodsSuccess";
		}
		System.out.println("goodsList========="+goodsList);
		return msg;
	}

	public String findByClassId(){
		// TODO Auto-generated method stub
		String msg = "error";
		List<Goods> goodsList = goodsService.findByClassId(goods.getGoodsClass().getClassId());
		if(goodsList != null && goodsList.size()>0){
			request.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return msg;
	}
	
	public String fileUpload(){
		
		return "";
	}
	

//	public List<Goods> findByPage(int page, int size) {
//		// TODO Auto-generated method stub
//		return sessionFactory.getCurrentSession().createQuery("from Goods").setFirstResult((page - 1) * size)
//				.setMaxResults(size).list();
//	}
	
	
	
	

	
	
	
	//关于文件上传
	private File file;
	private String contentType;
	private String filename;
	private String result;// 上传的结果信息
	
	//注意:此处的set***对应的是jsp页面<input type="file" name="upload"/>中的upload
	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		//该路径为Tomcat应用服务器中ST项目目录下的images
		//String path = getPath(filename);
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println("path: "+path);
		File filePath = new File(path);
		// 判断是否有该目录,如果没有就创建
		if (!filePath.exists()) {
			filePath.mkdir();
		}
//		System.out.println(file+":"+contentType+":"+filename);
		System.out.println("file: "+file);
		System.out.println("contentType: "+contentType);
		System.out.println("filename: "+filename);
		
		filename = System.currentTimeMillis()/1000+filename;
		// uploadFile上传的文件 file服务器放置上传文件的目录 uploadFileName上传文件名称
		FileUtils.copyFile(file, new File(filePath, filename));
		result = "上传成功";
		
		
		System.out.println("goodsId:::::::::::::::::: "+goods.getGoodsId());
		Goods goods1 = goodsService.findById(goods.getGoodsId());
		goods1.setImage(filename);
		goodsService.update(goods1);
		
		PrintWriter out = response.getWriter();
		out.print(filename);
		
		return SUCCESS;
	}
	
	private String getPath(String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String path  = ServletActionContext.getServletContext().getRealPath(FILE_PATH+System.currentTimeMillis()+ext);
		System.out.println("path===" + path);
		return path;
	}
	
	
	
}

package com.eshop.action;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eshop.dao.pojo.Admin;
import com.eshop.dao.pojo.Goods;
import com.eshop.dao.pojo.GoodsClass;
import com.eshop.service.iservice.IAdminService;
import com.eshop.service.iservice.IGoodsClassService;
import com.eshop.service.iservice.IGoodsService;

@Controller
@RequestMapping("goods")
public class GoodsAction implements ServletResponseAware,Serializable {
	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "/upload/";
	
	@Autowired
	@Qualifier("goodsService")
	private IGoodsService goodsService;
	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;
	@Autowired
	@Qualifier("goodsClassService")
	private IGoodsClassService goodsClassService;
	
	
	
	private String option;
	
	
	
	
	
	
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
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(@ModelAttribute Goods goods) {
		
		Admin admin = adminService.findById(1);
		//System.out.println("adminId in Dao: "+admin.getAdminId());
		goods.setAdmin(admin);
		GoodsClass goodsClass = goodsClassService.findById(1);
		goods.setGoodsClass(goodsClass);
		
		System.out.println("goodsName: " + goods.getGoodsName());
		System.out.println("goodsPrice： " + goods.getPrice());
		return "saveSuccess".equals(goodsService.save(goods))?"redirect:/goods/findByAdminId/1":"error";
	}
	
//	@ModelAttribute
//	public void before(@PathVariable("goodsId") int goodsId){
//		System.out.println("goodsId: "+goodsId);
//	}

	@RequestMapping(value="update/{goodsId}",method=RequestMethod.PUT)
	public String update(@ModelAttribute Goods goods ) {
		System.out.println("goodsId: "+goods.getGoodsId());
		goodsService.update(goods);
		return "redirect:/goods/findByAdminId/1";
		//"redirect:/goods/update/"+goodsId
	}
	
	@RequestMapping(value="delete/{goodsId}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("goodsId") int goodsId) {
		Goods goods = new Goods();
		goods.setGoodsId(goodsId);
		return goodsService.delete(goods);
	}

	@RequestMapping(value="findAll",method=RequestMethod.GET)
	public String findAll(Map<String,Object> map) throws IOException {
		String msg = "error";
		List<Goods> goodsList = goodsService.findAll();
		if (goodsList != null && goodsList.size() > 0) {
			//request.put("goodsListFromServer", goodsList);
			map.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		
		return "home_page";
	}

	@RequestMapping(value="findById/{goodsId}&{option}",method=RequestMethod.GET)
	public String findById(@PathVariable("goodsId") Integer goodsId,@PathVariable("option") Integer option,Map<String,Object> map) {
		String msg = "error";
		Goods p = goodsService.findById(goodsId);
		List<Goods> goodsList = null;
		if (p != null) {
			if (1 == option) {
				map.put("goods", p);
				msg = "updateSuccess";
			} else {
				goodsList = new ArrayList<Goods>();
				goodsList.add(p);
				map.put("goodsFromServer", p);
				msg = "findByIdSuccess";
			}
		}
		return "findByIdSuccess".equals(msg)?"detail1":"addGoods";
	}
	
	@RequestMapping(value="findBygoodsName/{goodsName}",method=RequestMethod.GET)
	public String findByGoodsName(@PathVariable("goodsName") String goodsName,Map<String,Object> map) {
		String msg = "error";
		List<Goods> goodsList = goodsService.findByGoodsName(goodsName);
		if(goodsList != null && goodsList.size()>0){
			map.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return "success".equals(msg)?"index.jsp":"error";
	}
	
	@RequestMapping("findByPrice")
	public String findByPrice(@ModelAttribute Goods goods,Map<String,Object> map) {
		String msg = "error";
		List<Goods> goodsList = goodsService.findByPrice(goods.getPrice(), goods.getPrice()+100);
		if(goodsList != null && goodsList.size()>0){
			map.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return "success".equals(msg)?"redirect:/index.jsp":"error";
	}
	
	@RequestMapping("findByRegTime")
	public String findByRegTime(@ModelAttribute Goods goods,Map<String,Object> map){
		// TODO Auto-generated method stub
		String msg = "error";
		List<Goods> goodsList = goodsService.findByRegTime(goods.getRegTime());
		if(goodsList != null && goodsList.size()>0){
			map.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return "success".equals(msg)?"redirect:/index.jsp":"error";
	}

	@RequestMapping(value="findByAdminId/{adminId}",method=RequestMethod.GET)
	public String findByAdminId(@PathVariable("adminId") int adminId,Map<String,Object> map) {
		// TODO Auto-generated method stub
		//goods.getAdmin().getAdminId()
		String msg = "error";
		List<Goods> goodsList = goodsService.findByAdminId(adminId);
		if(goodsList != null && goodsList.size()>0){
			map.put("adminGoodsListFromServer", goodsList);
			msg = "adminGoodsSuccess";
		}
		System.out.println("goodsList========="+goodsList);
		
		return "admin_goodsList";
	}

	@RequestMapping(value="findByClassId/{classId}",method=RequestMethod.GET)
	public String findByClassId(@PathVariable("classId") int classId,Map<String,Object> map){
		// TODO Auto-generated method stub
		String msg = "error";
		List<Goods> goodsList = goodsService.findByClassId(classId);
		if(goodsList != null && goodsList.size()>0){
			map.put("goodsListFromServer", goodsList);
			msg = "success";
		}
		return "success".equals(msg)?"redirect:/index.jsp":"error";
	}
	
	public String fileUpload(){
		
		return "";
	}
	

//	public List<Goods> findByPage(int page, int size) {
//		// TODO Auto-generated method stub
//		return sessionFactory.getCurrentSession().createQuery("from Goods").setFirstResult((page - 1) * size)
//				.setMaxResults(size).list();
//	}
	
	
	
	

	
	
	
//	//关于文件上传
//	private File file;
//	private String contentType;
//	private String filename;
//	private String result;// 上传的结果信息
//	
//	//注意:此处的set***对应的是jsp页面<input type="file" name="upload"/>中的upload
//	public void setUpload(File file) {
//		this.file = file;
//	}
//
//	public void setUploadContentType(String contentType) {
//		this.contentType = contentType;
//	}
//
//	public void setUploadFileName(String filename) {
//		this.filename = filename;
//	}
//
//	public String getResult() {
//		return result;
//	}
//
//	public void setResult(String result) {
//		this.result = result;
//	}

//	@Override
//	public String execute() throws Exception {
//		
//		//该路径为Tomcat应用服务器中ST项目目录下的images
//		//String path = getPath(filename);
//		String path = ServletActionContext.getServletContext().getRealPath("/upload");
//		System.out.println("path: "+path);
//		File filePath = new File(path);
//		// 判断是否有该目录,如果没有就创建
//		if (!filePath.exists()) {
//			filePath.mkdir();
//		}
////		System.out.println(file+":"+contentType+":"+filename);
//		System.out.println("file: "+file);
//		System.out.println("contentType: "+contentType);
//		System.out.println("filename: "+filename);
//		
//		filename = System.currentTimeMillis()/1000+filename;
//		// uploadFile上传的文件 file服务器放置上传文件的目录 uploadFileName上传文件名称
//		FileUtils.copyFile(file, new File(filePath, filename));
//		result = "上传成功";
//		
//		System.out.println("goodsId:::::::::::::::::: "+goods.getGoodsId());
//		Goods goods1 = goodsService.findById(goods.getGoodsId());
//		goods1.setImage(filename);
//		goodsService.update(goods1);
//		
//		PrintWriter out = response.getWriter();
//		out.print(filename);
//		return SUCCESS;
//	}
	
	private String getPath(String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String path  = ServletActionContext.getServletContext().getRealPath(FILE_PATH+System.currentTimeMillis()+ext);
		System.out.println("path===" + path);
		return path;
	}
	
	
	
	
	
//	@RequestMapping(value = "upload", method = RequestMethod.POST)
//    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, ModelMap model) {
//        System.out.println("开始");
//        String path = request.getSession().getServletContext().getRealPath("upload");
//        String fileName = file.getOriginalFilename();
//        System.out.println("fileName: " + fileName);
//        // String fileName = new Date().getTime()+".jpg";
//        System.out.println("path" + path);
//        File targetFile = new File(path, fileName);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
//
//        // 保存
//        try {
//            file.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
//        return "result";
//    }
	
	
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,@RequestParam("fileFromClient") MultipartFile sourceFile,@ModelAttribute Goods goods) throws Exception {
        
		if(!sourceFile.isEmpty()){
			String path = request.getSession().getServletContext().getRealPath("/upload");
			System.out.println("path: "+path);
			File filePath = new File(path);
			// 判断是否有该目录,如果没有就创建
			if (!filePath.exists()) {
				filePath.mkdir();
			}
			String fileName = System.currentTimeMillis()+sourceFile.getOriginalFilename();
			File targetFile = new File(path ,fileName);
			System.out.println("targetFile: " + targetFile.getName());
			FileUtils.copyInputStreamToFile(sourceFile.getInputStream(), targetFile);
			
			
			
			
			System.out.println("goodsId:::::::::::::::::: "+goods.getGoodsId());
			Goods goods1 = goodsService.findById(goods.getGoodsId());
			goods1.setImage(fileName);
			goodsService.update(goods1);
			
//			PrintWriter out = response.getWriter();
//			out.print(filename);
//			return SUCCESS;
			
		}
		
		return "success";
		
    }
	
	
	

	
	
	
	
	
	
	
	
}

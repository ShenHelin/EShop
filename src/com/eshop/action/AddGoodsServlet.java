package com.eshop.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.eshop.dao.pojo.Goods;
import com.eshop.service.impl.ServiceGoodsImpl;
import com.eshop.service.iservice.IGoodsService;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/addGoods")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "/upload/";
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("addGoodsServlet....................................");
		
		// 获取增加书的表单
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//
		factory.setSizeThreshold(1024 * 1024);
		factory.setRepository(new File("e://temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的大小
		upload.setFileSizeMax(1024 * 3000);
		// 设置总的文件的大小
		upload.setSizeMax(1024 * 1024 * 5);

		// Parse the request
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,String> map = new HashMap<>();
		for(FileItem item : items){
			if(item.isFormField()){
				String fieldName = item.getFieldName();
				String value = item.getString();
				map.put(fieldName, value);
			}else{
				String fieldName = item.getFieldName();
				String fileName = item.getName();
				String filePath = getPath(fileName);
				InputStream in = item.getInputStream();
				OutputStream os = new FileOutputStream(filePath);
				int len = -1;
				while((len = in.read()) != -1){
					os.write(len);
				}
				os.close();
				in.close();
				map.put(fieldName, filePath);
			}
		}
		
		
		
		//遍历map  把map中的数据赋值给    goods 对象中
		Goods goods = new Goods();
		for(Map.Entry<String,String> entry:map.entrySet()){
			try {
				BeanUtils.setProperty(goods, entry.getKey(), entry.getValue());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//GoodsService service = new GoodsServiceImpl();
		IGoodsService service = new ServiceGoodsImpl();
		service.save(goods);
		
		response.sendRedirect("admin/goods_add.jsp");
		
	}
	
	private String getPath(String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String path  = getServletContext().getRealPath(FILE_PATH+System.currentTimeMillis()+ext);
		System.out.println(path);
		return path;
	}
}

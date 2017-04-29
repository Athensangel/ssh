package com.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.ssh.entity.User;
import com.ssh.service.UserService;
import com.ssh.utils.PoiExcelExportUtil;

public class UserAction implements ServletRequestAware{
	// myFile属性用来封装上传的文件  
    private File myFile;  
      
    // myFileContentType属性用来封装上传文件的类型  
    private String myFileContentType;  
  
    // myFileFileName属性用来封装上传文件的文件名  
    private String myFileFileName;  
	HttpServletRequest request;
	private UserService uService;

	public UserService getuService() {
		return uService;
	}

	public void setuService(UserService uService) {
		this.uService = uService;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}


	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	/**
	 * 登录
	 * @return
	 */
	public String userLogin(){
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		User currentUser = uService.login(user);
		if(currentUser != null){
			return "loginSuccess";
		}else{
			return "loginError";
		}
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public String findAllUsers(){
		List<User> userList = uService.findUsers();
		request.setAttribute("userList", userList);
		return "findAllUsers";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	public String jumpUserAdd(){
		return "jumpUserAdd";
	}
	
	
	/**
	 * 新增用户
	 * @return
	 */
	public String saveUser()throws Exception{
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		//获取文件存储路径  
		//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(myFile);  
        String logoPathDir = "/upload/";     
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");  
        // 设置目标文件  
        File toFile = new File(uploadPath, this.getMyFileFileName());  
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);  
        //设置缓存  
        byte[] buffer = new byte[1024];  
        int length = 0;  
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        } 
        System.out.println("上传文件名"+myFileFileName);  
        System.out.println("上传文件类型"+myFileContentType);
        
        String fileTemp = logoPathDir +myFileFileName;
        User user = new User();
		user.setId(getUUID());
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setImgUrl(fileTemp);
		uService.saveUser(user);
        
        //关闭输入流  
        is.close();  
        //关闭输出流  
        os.close();  
		return "saveUser";
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	public String jumpUserUpdate(){
		String id = request.getParameter("id");
		User user = new User();
		user.setId(id);
		User currentUser = uService.findUserById(user);
		request.setAttribute("currentUser", currentUser);
		return "jumpUserUpdate";
	}
	
	
	/**
	 * 修改用户
	 * @return
	 */
	public String updateUser(){
		String id = request.getParameter("id");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setPassWord(passWord);
		uService.updateUser(user);
		return "updateUser";
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String deleteUser(){
		String id = request.getParameter("id");
		User user = new User();
		user.setId(id);
		uService.deleteUser(user);;
		return "deleteUser";
	}
	
	/** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    }
    
	/**
	 * 导出excel
	 * @return
	 */
	public String exportUserExcel(){
		// 声明一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        //声明一个单子并命名
        HSSFSheet sheet = wb.createSheet("用户表");
        //给单子名称一个长度
        sheet.setDefaultColumnWidth((short)15);
        // 生成一个样式  
        HSSFCellStyle style = wb.createCellStyle();
        //创建第一行（也可以称为表头）
        HSSFRow row = sheet.createRow(0);
        //样式字体居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //给表头第一行一次创建单元格
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("id"); 
        cell.setCellStyle(style);
        cell = row.createCell( (short) 1);  
                cell.setCellValue("账号");  
                cell.setCellStyle(style);  
                cell = row.createCell((short) 2);  
                cell.setCellValue("密码");  
                cell.setCellStyle(style); 
         
               //添加一些数据，这里先写死，大家可以换成自己的集合数据
               List<User> userList = uService.findUsers();
 
               //向单元格里填充数据
               for (short i = 0; i < userList.size(); i++) {
                row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(userList.get(i).getId());
                row.createCell(1).setCellValue(userList.get(i).getUserName());
                row.createCell(2).setCellValue(userList.get(i).getPassWord());
            }
           try {
            //默认导出到E盘下
            FileOutputStream out = new FileOutputStream("E://用户表.xls");
            wb.write(out);
            out.close();
            JOptionPane.showMessageDialog(null, "导出成功!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "导出失败!");
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "导出失败!");
            e.printStackTrace();
        }
		return "exportUserExcel";
	}

	
	/**
	 * 导出excel2
	 * @return
	 */
	public String exportUserExcel2(){
	  PoiExcelExportUtil pee = new PoiExcelExportUtil("E:/test.xls","sheet1");  
        //数据  
	  	List<User> userList = uService.findUsers();
        //调用  
        String titleColumn[] = {"id","userName","passWord"};  
        String titleName[] = {"id","账号","密码"};  
        int titleSize[] = {13,13,13,13,13};  
        pee.wirteExcel(titleColumn, titleName, titleSize, userList);  
	return "exportUserExcel2";
	}
	
}

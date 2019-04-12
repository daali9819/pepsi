package org.hr_xiangmu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;





import org.hr_xiangmu.entity.Emp;
import org.hr_xiangmu.entity.Position;
import org.hr_xiangmu.entity.Properties;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Salayitems;
import org.hr_xiangmu.entity.Sysright;
import org.hr_xiangmu.entity.User;
import org.hr_xiangmu.entity.Train;
import org.hr_xiangmu.entity.Train;





import freemarker.template.Configuration;
import freemarker.template.Template;

public class AutoGenerateProject {

	private static String projectName = "hr_xiangmu";
	private static Class[] clazzes = new Class[] {  };




	public static void main(String[] args) throws Exception {
		generateDao();
		generateDaoImpl();
		generateAction();
		generateActionConfig();
		generateJsp_List();
		generateJsp_js();
		generateJsp_Add();
	}

	/**
	 * 生成Dao接口
	 */
	private static void generateDao() throws Exception {
		// 读文件：Inputstream， 写文件 Outputstream
		// 1. 读取模板文件
		File file = new File("src/templates/dao.moban");
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();
		String content = new String(b);

		for (Class clazz : clazzes) {
			// 2. 替换模板中对应的占位符
			String entityName = clazz.getSimpleName();
			String shortName = entityName.substring(0,1).toLowerCase() + entityName.substring(1);
			String c = content.replace("${projectName}", projectName)
					.replace("${entityName}", clazz.getSimpleName())
					.replace("${short_entityName}", shortName);
			// 3. 保存到指定的地方
			File dest = new File("src/org/" + projectName + "/dao/" + entityName
					+ "Dao.java");
			OutputStream os = new FileOutputStream(dest);
			os.write(c.getBytes());
			os.close();
		}
		
		System.out.println("dao生成成功了");
	}
	
	private static void generateDaoImpl() throws Exception {
		// 读文件：Inputstream， 写文件 Outputstream
		// 1. 读取模板文件
		File file = new File("src/templates/daoImpl.moban");
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();
		String content = new String(b);

		for (Class clazz : clazzes) {
			// 2. 替换模板中对应的占位符
			String entityName = clazz.getSimpleName();
			String shortName = entityName.substring(0,1).toLowerCase() + entityName.substring(1);
			String c = content.replace("${projectName}", projectName)
					.replace("${entityName}", clazz.getSimpleName())
					.replace("${short_entityName}", shortName);
			// 3. 保存到指定的地方
			File dest = new File("src/org/" + projectName + "/dao/impl/" + entityName
					+ "DaoImpl.java");
			OutputStream os = new FileOutputStream(dest);
			os.write(c.getBytes());
			os.close();
		}
		
		System.out.println("daoImpl生成成功了");
	}
	
	private static void generateAction() throws Exception {
		// 读文件：Inputstream， 写文件 Outputstream
		// 1. 读取模板文件
		File file = new File("src/templates/action.moban");
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();
		String content = new String(b);

		for (Class clazz : clazzes) {
			// 2. 替换模板中对应的占位符
			String entityName = clazz.getSimpleName();
			String shortName = entityName.substring(0,1).toLowerCase() + entityName.substring(1);
			String c = content.replace("${projectName}", projectName)
					.replace("${entityName}", clazz.getSimpleName())
					.replace("${short_entityName}", shortName);
			// 3. 保存到指定的地方
			File dest = new File("src/org/" + projectName + "/web/" + entityName
					+ "Action.java");
			OutputStream os = new FileOutputStream(dest);
			os.write(c.getBytes());
			os.close();
		}
		
		System.out.println("action生成成功了");
	}
	
	private static void generateActionConfig() throws Exception {
		// 读文件：Inputstream， 写文件 Outputstream
		// 1. 读取模板文件
		File file = new File("src/templates/config.moban");
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();
		String content = new String(b);

		for (Class clazz : clazzes) {
			// 2. 替换模板中对应的占位符
			String entityName = clazz.getSimpleName();
			String shortName = entityName.substring(0,1).toLowerCase() + entityName.substring(1);
			String c = content.replace("${projectName}", projectName)
					.replace("${entityName}", clazz.getSimpleName())
					.replace("${short_entityName}", shortName);
			// 3. 保存到指定的地方
			File dest = new File("src/struts_" + shortName
					+ ".xml");
			OutputStream os = new FileOutputStream(dest);
			os.write(c.getBytes());
			os.close();
		}
		
		System.out.println("action配置文件生成成功了");
	}
	
	private static void generateJsp_List() throws Exception {
		// 读文件：Inputstream， 写文件 Outputstream
		// 1. 读取模板文件
		File file = new File("src/templates/list_jsp.moban");
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();
		String content = new String(b);

		for (Class clazz : clazzes) {
			// 2. 替换模板中对应的占位符
			String entityName = clazz.getSimpleName();
			String shortName = entityName.substring(0,1).toLowerCase() + entityName.substring(1);
			String c = content.replace("${projectName}", projectName)
					.replace("${entityName}", clazz.getSimpleName())
					.replace("${short_entityName}", shortName);
			// 3. 保存到指定的地方
			File dir = new File("WebRoot/sys/"+shortName);
			if(!dir.exists()) {
				dir.mkdir();
			}
			File dest = new File("WebRoot/sys/"+shortName + "/list.jsp");
			OutputStream os = new FileOutputStream(dest);
			os.write(c.getBytes());
			os.close();
		}
	}
	
	private static void generateJsp_js() throws Exception {
			Configuration config = new Configuration();
			config.setDirectoryForTemplateLoading(new File("src/templates"));
			// 1. 读取模板文件
			Template template = config.getTemplate("jsp_js.moban");
			
			//準備模型數據
			Map<String, Object> root = new HashMap<String, Object>();
			for (Class clazz : clazzes) {
				String entityName = clazz.getSimpleName();
				String shortName = entityName.substring(0,1).toLowerCase() + entityName.substring(1);
				
				List<String> displayFields = new ArrayList<String>();
				
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					if(field.getType() == Set.class  || field.getType() == List.class ){
						continue;
					}
					displayFields.add(field.getName());
				}
				
				root.put("projectName", projectName);
				root.put("entityName", entityName);
				root.put("short_entityName", shortName);
				root.put("displayFields", displayFields);
				
				File dest = new File("WebRoot/sys/"+shortName + "/"+shortName+".js");
				OutputStream os = new FileOutputStream(dest);
				
				template.process(root,new OutputStreamWriter(os));
			}
			
		System.out.println("JavaScript生成成功了");
	}
	
	private static void generateJsp_Add() throws Exception {
		Configuration config = new Configuration();
		config.setDirectoryForTemplateLoading(new File("src/templates"));
		// 1. 读取模板文件
		Template template = config.getTemplate("jsp_add.moban");
		
		//準備模型數據
		Map<String, Object> root = new HashMap<String, Object>();
		for (Class clazz : clazzes) {
			String entityName = clazz.getSimpleName();
			String shortName = entityName.substring(0,1).toLowerCase() + entityName.substring(1);
			
			List<String> displayFields = new ArrayList<String>();
			
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if(field.getType() == Set.class  || field.getType() == List.class ){
					continue;
				}
				displayFields.add(field.getName());
			}
			
			root.put("projectName", projectName);
			root.put("entityName", entityName);
			root.put("short_entityName", shortName);
			root.put("displayFields", displayFields);
			
			File dest = new File("WebRoot/sys/"+shortName + "/"+shortName+".jsp");
			OutputStream os = new FileOutputStream(dest);
			
			template.process(root,new OutputStreamWriter(os));
		}
		
	System.out.println("jsp生成成功了");
}

}










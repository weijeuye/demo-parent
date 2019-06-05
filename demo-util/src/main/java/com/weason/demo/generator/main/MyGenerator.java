/**
 * @filename:UserController 2019年4月9日
 * @project wallet-manage  V1.0
 * Copyright(c) 2018 flying-cattle Co. Ltd. 
 * All right reserved. 
 */
package com.weason.demo.generator.main;




import com.weason.demo.generator.entity.BasisInfo;
import com.weason.demo.generator.util.EntityInfoUtil;
import com.weason.demo.generator.util.Generator;
import com.weason.demo.generator.util.MySqlToJavaUtil;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 自动生成工具</P>
 * <p>源码地址：https://gitee.com/flying-cattle/mybatis-dsc-generator</P>
 */
public class MyGenerator {
	/***
	 * 基础信息
	 */
	public static final String PROJECT = "demo-parent";
	public static final String AUTHOR = "weilei";
	public static final String VERSION = "0.0.1";
	/***
	 * 数据库连接信息
 	 */
	public static final String URL = "jdbc:mysql://39.107.253.236:3306/crmoa?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false&useSSL=true&serverTimezone=UTC";
	public static final String NAME = "root";
	public static final String PASS = "admin";
	public static final String DATABASE = "crmoa";
	/***
	 * 类信息
	 */
	public static final String TABLE = "sys_user";
	public static final String CLASSNAME = "user";
	public static final String CLASSCOMMENT = "用户表";
	public static final String TIME = "2019年5月29日";
	public static final String AGILE = (new Date()).getTime() + "";
	/***
	 * 路径信息，分开路径方便聚合工程项目，微服务项目
 	 */
	public static final String ENTITY_URL = "com.weason.demodal.po";
	public static final String DAO_URL = "com.weason.demodal.mapper";
	public static final String XML_URL = "mapper";
	public static final String SERVICE_URL = "com.weason.demoservice.service";
	public static final String SERVICE_IMPL_URL = "com.weason.demoservice.service.impl";
	public static final String CONTROLLER_URL = "com.weason.demoweb.controller";

	public static void main(String[] args) {
		/***
		 * 是否生成swagger config文件 和 抽象controller文件
		 */
		Boolean flag = true;

		execute(flag);
	}

	private static void execute(Boolean flag) {
		BasisInfo bi = new BasisInfo(PROJECT, AUTHOR, VERSION, URL, NAME, PASS, DATABASE, TIME, AGILE, ENTITY_URL,
				DAO_URL, XML_URL, SERVICE_URL, SERVICE_IMPL_URL, CONTROLLER_URL);
		bi.setTable(TABLE);
		bi.setEntityName(MySqlToJavaUtil.getClassName(CLASSNAME));
		bi.setObjectName(MySqlToJavaUtil.changeToJavaFiled(CLASSNAME));
		bi.setEntityComment(CLASSCOMMENT);
		try {
			bi = EntityInfoUtil.getInfo(bi);
			// 生成文件存放位置
			String fileUrl = System.getProperty("user.dir")+ File.separator+"src/main/java/";
			String xmlFileUrl = System.getProperty("user.dir")+ File.separator+"src/main/resources/";
			String aa1 = Generator.createEntity(fileUrl, bi).toString();

			String aa2 = Generator.createDao(fileUrl, bi).toString();
			String aa3 = Generator.createDaoImpl(xmlFileUrl, bi).toString();
			String aa4 = Generator.createService(fileUrl, bi).toString();
			String aa5 = Generator.createServiceImpl(fileUrl, bi).toString();
			String aa6 = Generator.createController(fileUrl, bi,flag).toString();

			// 是否创建swagger配置文件
			if (flag){
				String aa7 = Generator.createSwaggerConfig(fileUrl, bi).toString();
				System.out.println(aa7);
			}

			System.out.println(aa1);
			System.out.println(aa2); System.out.println(aa3); System.out.println(aa4);
			System.out.println(aa5); System.out.println(aa6);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

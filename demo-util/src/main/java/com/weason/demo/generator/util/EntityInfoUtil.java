/**   
 * Copyright © 2019 dream horse Info. Tech Ltd. All rights reserved.
 * @Package: com.github.mybatis.fl.util
 * @author: flying-cattle  
 * @date: 2019年4月9日 下午8:15:25 
 */
package com.weason.demo.generator.util;




import com.weason.demo.generator.entity.BasisInfo;
import com.weason.demo.generator.entity.PropertyInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明：  链接数据库并获取表信息</P>
 * @version: v3.0.0
 * @author: flying-cattle
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * 2019年4月9日      		flying-cattle   v3.0.0           initialize
 */
public class EntityInfoUtil {
	public static BasisInfo getInfo(BasisInfo bi) throws SQLException {
		List<PropertyInfo> columns= new ArrayList<PropertyInfo>();
		// 创建连接
		Connection con = null;
		PreparedStatement pstemt = null;
		ResultSet rs = null;
		//sql
		String sql="select column_name,data_type,column_comment from information_schema.columns where table_schema='"+bi.getDatabase()+"' and table_name='"+bi.getTable()+"'";
		try {
			con = DriverManager.getConnection(bi.getDbUrl(), bi.getDbName(), bi.getDbPassword());
			pstemt = con.prepareStatement(sql);
			rs = pstemt.executeQuery();
			while (rs.next()) {
				String column = rs.getString(1);
				String jdbcType = rs.getString(2);
				String comment = rs.getString(3);
				PropertyInfo ci=new PropertyInfo();
				ci.setColumn(column);
				if (jdbcType.equalsIgnoreCase("int")) {
					ci.setJdbcType("Integer");
				}else if (jdbcType.equalsIgnoreCase("datetime")) {
					ci.setJdbcType("timestamp");
				}else {
					ci.setJdbcType(jdbcType);
				}
				ci.setComment(comment);
				ci.setProperty(MySqlToJavaUtil.changeToJavaFiled(column));
				ci.setJavaType(MySqlToJavaUtil.jdbcTypeToJavaType(jdbcType));
				//设置注解类型
				if (column.equalsIgnoreCase("id")) {
					bi.setIdType(ci.getJavaType());
					bi.setIdJdbcType(ci.getJdbcType());
				}
				columns.add(ci);
			}
			bi.setCis(columns);
			// 完成后关闭
			rs.close();
			pstemt.close();
			con.close();
			return bi;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("自动生成实体类错误："+e.getMessage());
		} finally {
            try{
                if(rs!=null) rs.close();
            }catch(SQLException se2){
            }
			// 关闭资源
            try{
                if(pstemt!=null) pstemt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(con!=null) con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
		}
	}
}

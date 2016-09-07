/**
 * <b>项目名：</b>cloud-common<br/>
 * <b>包名：</b>com.hbdiy.sc.common.model<br/>
 * <b>文件名：</b>User.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-下午4:57:40<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc.common.model;

/**
 * <b>类名称：</b>User <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 下午4:57:40<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

public class User {
	
	private String name;
	
	private String password;
	
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

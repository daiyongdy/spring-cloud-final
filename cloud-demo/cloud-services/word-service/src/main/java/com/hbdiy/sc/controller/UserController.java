/**
 * <b>项目名：</b>word-service<br/>
 * <b>包名：</b>com.hbdiy.sc.controller<br/>
 * <b>文件名：</b>UserController.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-下午4:59:26<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hbdiy.sc.common.model.User;

/**
 * <b>类名称：</b>UserController <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 下午4:59:26<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/get")
	public User get() {
		User user = new User();
		user.setName("代勇");
		user.setPassword("111111");
		user.setGender("男");
		return user;
	}
	
}

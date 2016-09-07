/**
 * <b>项目名：</b>word-client<br/>
 * <b>包名：</b>com.hbdiy.sc.controller<br/>
 * <b>文件名：</b>WordController.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-上午10:16:46<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.hbdiy.sc.common.model.User;
import com.hbdiy.sc.common.util.discoverClient.DiscoverClientUtil;

/**
 * <b>类名称：</b>WordController <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 上午10:16:46<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

@RestController
public class WordController {
	
	@Autowired
	private DiscoverClientUtil discoverClientUtil;
	
	@RequestMapping("/sen")
	public String sen() {
		return this.discoverClientUtil.getForObject("http://word-service/", String.class);
	}
	
	@RequestMapping("/getUser")
	public String getUser() {
		User user = this.discoverClientUtil.getForObjectById("word-service", "/user/get", User.class);
		return JSON.toJSONString(user);
		
//		URI uri = this.bkClientUtil.getUri("word-service", "");
//		String url = uri.toString() + "/user/get";
//		String json = new RestTemplate().getForObject(url, String.class);
//		
//		return json;
	}
	
	/**
	 * @author daiyong
	 */
	@RequestMapping("/getUser2")
	public User getUser2() {
		String url = "http://WORD-SERVICE/user/get";
		User user = this.discoverClientUtil.getForObject(url, User.class);
		return user;
	}
	
	
}

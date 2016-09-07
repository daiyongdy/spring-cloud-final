/**
 * <b>项目名：</b>cloud-common<br/>
 * <b>包名：</b>com.hbdiy.sc.common.util.discoverClient<br/>
 * <b>文件名：</b>RestTemplateFactory.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-下午9:22:56<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc.common.util.discoverClient;

import java.util.Map;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

/**
 * <b>类名称：</b>RestTemplateFactory <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 下午9:22:56<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

public class RestTemplateFactory {

	private static Map<String, RestTemplate> store = Maps.newHashMap();
	
	public static RestTemplate getRestTemplate() {
		
		if (null != RestTemplateFactory.store.get("rt")) {
			return RestTemplateFactory.store.get("rt");
		} else {
			RestTemplate template = new RestTemplate();
			SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template
					.getRequestFactory();
			factory.setConnectTimeout(3000);
			factory.setReadTimeout(3000);
			
			RestTemplateFactory.store.put("rt", template);
			return template;
		}
	}
	
}

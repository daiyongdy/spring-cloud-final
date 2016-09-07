/**
 * <b>项目名：</b>cloud-common<br/>
 * <b>包名：</b>com.hbdiy.sc.common.util.discoverClient<br/>
 * <b>文件名：</b>DiscoverClientUtil.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-下午7:36:32<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc.common.util.discoverClient;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

/**
 * <b>类名称：</b>DiscoverClientUtil <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 下午7:36:32<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

@Component
public class DiscoverClientUtil {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	public <T> T getForObject(String url, Class<T> cls) {
		String resultJson = this.restTemplate.getForObject(url, String.class);
		T t = JSON.parseObject(resultJson, cls);
		return t;
	}
	public <T> List<T> getForObjects(String url, Class<T> cls) {
		String resultJson = this.restTemplate.getForObject(url, String.class);
		List<T> ts = JSON.parseArray(resultJson, cls);
		return ts;
	}
	
	public <T> T getForObjectById(String serviceId, String path, Class<T> cls) {
		URI uri = this.getUri(serviceId);
		String url = uri.toString() + path;
		
		String resultJson = RestTemplateFactory.getRestTemplate().getForObject(url, String.class);
		T t = JSON.parseObject(resultJson, cls);
		return t;
	}
	public <T> List<T> getForObjectsById(String serviceId, String path, Class<T> cls) {
		
		URI uri = this.getUri(serviceId);
		String url = uri.toString() + path;
		
		String resultJson = RestTemplateFactory.getRestTemplate().getForObject(url, String.class);
		List<T> ts = JSON.parseArray(resultJson, cls);
		return ts;
	}
	
	
	public URI getUri(String serviceId) {
		URI uri = null;
		
		ServiceInstance instance = this.loadBalancerClient.choose(serviceId);
		if (null == instance) {
			throw new RuntimeException("no such service!");
		} else {
			uri = instance.getUri();
		}
		return uri;
	}
	
	
}

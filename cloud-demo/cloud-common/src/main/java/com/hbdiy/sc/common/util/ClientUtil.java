/**
 * <b>项目名：</b>cloud-common<br/>
 * <b>包名：</b>com.hbdiy.sc.common.util<br/>
 * <b>文件名：</b>ClientUtil.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-下午4:40:23<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc.common.util;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * <b>类名称：</b>ClientUtil <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 下午4:40:23<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

@Component
public class ClientUtil {
	
	/**
	 * 负载均衡
	 */
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	public URI getUri(String serviceId, String fallBackUri) {
		URI uri = null;
		try {
			ServiceInstance instance = loadBalancerClient.choose(serviceId);
			uri = instance.getUri();
		} catch (Exception e) {
			e.printStackTrace();
			uri = URI.create(fallBackUri);
		}
		return uri;
	}
	
	public static <T> ResponseEntity<T> createOkResponse(T body) {
        return createResponse(body, HttpStatus.OK);
    }
 
    public static <T> ResponseEntity<T> createResponse(T body, HttpStatus httpStatus) {
        return new ResponseEntity<>(body, httpStatus);
    }
 
    public static <T> T json2Object(ResponseEntity<String> response, Class<T> clazz) {
        try {
 
            return (T) JSON.parseObject(response.getBody(), clazz);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
 
    }
 
    public static <T> List<T> json2Objects(ResponseEntity<String> response, Class<T> clazz) {
        try {
            return JSON.parseArray(response.getBody(), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	
	
}

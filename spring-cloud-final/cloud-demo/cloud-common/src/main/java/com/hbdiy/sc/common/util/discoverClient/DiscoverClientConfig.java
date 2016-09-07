/**
 * <b>项目名：</b>cloud-common<br/>
 * <b>包名：</b>com.hbdiy.sc.common.util.discoverClient<br/>
 * <b>文件名：</b>DiscoverClientConfig.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-下午8:31:12<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc.common.util.discoverClient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <b>类名称：</b>DiscoverClientConfig <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 下午8:31:12<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

@Configuration
public class DiscoverClientConfig {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return RestTemplateFactory.getRestTemplate();
	}

}

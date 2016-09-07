/**
 * <b>项目名：</b>eureka-server<br/>
 * <b>包名：</b>com.hbdiy.sc<br/>
 * <b>文件名：</b>EurekaApplication.java<br/>
 * <b>描述：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 * <b>日期：</b>2016年9月7日-上午9:49:21<br/>
 * <b>Copyright (c)</b> 2016<br/>
 */

package com.hbdiy.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>类名称：</b>EurekaApplication <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>daiyong<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2016年9月7日 上午9:49:21<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClusterApplication.class, args);
	}
	
}

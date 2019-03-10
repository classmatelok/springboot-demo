package com.lok.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.lok.domain.User;
import com.lok.service.imp.UserServiceImp;

@ManagedResource(objectName="bean:name=UserServiceMBean")
public class UserServiceMBean {
	
	//如果是xml配置方式注入，则用构造方法注入字段为佳，否则没必要的字段get/set方法也会被jconsole监控
	@Autowired
	private UserServiceImp userServiceImp;
	
	@ManagedOperation()
	@ManagedOperationParameters({
		@ManagedOperationParameter(name="id", description="User id")
	})
	public String getList(String id) {
		User user = userServiceImp.findUser(Integer.valueOf(id));
		if (user!=null) {
			return "Get data success, id="+user.getId();
		} else {
			return "Get data null";
		}
	}
}

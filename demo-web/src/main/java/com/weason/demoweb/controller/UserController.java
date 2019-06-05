package com.weason.demoweb.controller;


import com.weasom.demodal.po.User;
import com.weason.demoservice.service.IUserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>说明： 用户表API接口层</P>
 * @version: 0.0.1
 * @author: weilei
 *
 */
@Api(description = "用户表",value="用户表" )
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<IUserService,User>{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
}
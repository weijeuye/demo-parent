package com.weason.demoservice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weasom.demodal.mapper.UserMapper;
import com.weasom.demodal.po.User;
import com.weason.demoservice.service.IUserService;
import org.springframework.stereotype.Service;

/**   
 *
 * <p>说明： 用户表服务实现层</P>
 * @version: 0.0.1
 * @author: weilei
 * 
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService  {
	
}
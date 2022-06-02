package com.liyeam.seckill.service.impl;

import com.liyeam.seckill.entity.User;
import com.liyeam.seckill.mapper.UserMapper;
import com.liyeam.seckill.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liyeam
 * @since 2022-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

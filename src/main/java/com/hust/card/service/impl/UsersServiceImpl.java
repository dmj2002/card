package com.hust.card.service.impl;

import com.hust.card.domains.po.Users;
import com.hust.card.mapper.UsersMapper;
import com.hust.card.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dmjkk
 * @since 2025-05-28
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}

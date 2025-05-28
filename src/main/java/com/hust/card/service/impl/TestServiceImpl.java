package com.hust.card.service.impl;

import com.hust.card.domains.po.Test;
import com.hust.card.mapper.TestMapper;
import com.hust.card.service.ITestService;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}

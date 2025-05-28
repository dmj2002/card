package com.hust.card.service.impl;

import com.hust.card.domains.po.Board;
import com.hust.card.mapper.BoardMapper;
import com.hust.card.service.IBoardService;
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
public class BoardServiceImpl extends ServiceImpl<BoardMapper, Board> implements IBoardService {

}

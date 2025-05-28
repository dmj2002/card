package com.hust.card.domains.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dmjkk
 * @since 2025-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("board")
public class Board implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "board_id", type = IdType.AUTO)
    private Integer boardId;

    private String factory;

    private String boardType;

    private String ratedCurrent;

    private Boolean calibrated;


}

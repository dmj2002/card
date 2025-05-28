package com.hust.card.domains.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("test_records")
public class TestRecords implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "test_records_id", type = IdType.AUTO)
    private Integer testRecordsId;

    private Integer testId;

    private Integer chipId;

    private LocalDate date;

    private BigDecimal temperature;


}

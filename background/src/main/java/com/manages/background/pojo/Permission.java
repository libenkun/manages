package com.manages.background.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lbk
 * @date 2020/7/31 17:08
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "tb_psermission")
public class Permission implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    private Long pid;
    private String name;
    private Integer state;
    private String types;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT, update = "now()")
    private LocalDateTime updateTime;

}

package com.manages.background.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lbk
 * @date 2020/8/10 16:39
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "tb_category")
public class Category implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private Long pid;
    private Integer states;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT, update = "now()")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private List<Category> list;
}

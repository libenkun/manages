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
 * @date 2020/7/31 17:15
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "tb_role")
public class Role implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    private String roleName;
    private String picture;
    private String path;
    private Integer states;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT, update = "now()")
    private LocalDateTime updateTime;


    @TableField(exist = false)
    List<Permission> permission;
}

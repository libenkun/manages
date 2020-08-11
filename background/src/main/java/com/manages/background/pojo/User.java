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
 * @date 2020/7/31 11:37
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "tb_user")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    private String username;
    private String password;
    private Boolean states;
    private String email;
    private String phone;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT, update = "now()")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    List<Menu> menus;

}

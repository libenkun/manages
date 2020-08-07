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
 * @date 2020/7/31 17:03
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "tb_menu")
public class Menu implements Serializable {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    private Long pid;
    private String menuName;
    private String path;
    private Long permissionId;
    private String picture;
    private Integer states;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT, update = "now()")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    List<Menu> menusChild;

}

package com.manages.background.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lbk
 * @date 2020/9/8 15:15
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "tb_category_explain")
public class CategoryExplain {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    private Long categoryId;
    private Integer types;
    private String valued;

}

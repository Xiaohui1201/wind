package com.windcloud.windupmsapi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * file:SysMenu.js
 * created by Fanghonghui on 2019-09-16
 * email:a6551142@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_department")
@ApiModel(value = "SysDepartment对象" , description = "")
public class SysMenu extends Model<SysMenu> {
    private static final long serialVersionUID=1L;
    
    @TableId(value = "id" , type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Long id;
    
    @ApiModelProperty(value = "菜单名称")
    private String menuName;
    
    @ApiModelProperty(value = "")
    private String menuCode;
    
    @TableLogic
    @ApiModelProperty(value = "")
    private Boolean del;
    
    @ApiModelProperty(value = "")
    private Boolean type;
    
    @ApiModelProperty(value = "")
    private String permCode;
    
    @ApiModelProperty(value = "")
    private Long parentId;
}


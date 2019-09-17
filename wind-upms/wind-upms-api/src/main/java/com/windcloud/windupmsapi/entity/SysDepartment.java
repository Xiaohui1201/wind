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
 * file:SysDepartment.js
 * created by Fanghonghui on 2019-09-16
 * email:a6551142@163.com
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_department")
@ApiModel(value = "SysDepartment对象" , description = "")
public class SysDepartment extends Model<SysDepartment> {
    private static final long serialVersionUID=1L;
    
    @TableId(value = "id" , type = IdType.AUTO)
    @ApiModelProperty(value = "")
    private Long id;
    
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    
    @ApiModelProperty(value = "部门编码")
    private String deptCode;
    
    @TableLogic
    @ApiModelProperty(value = "是否删除，0:否 1:是")
    private Boolean del;
}


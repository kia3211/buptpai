package com.itmk.web.sys_menu.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@TableName("sys_menu")
public class SysMenu {
    @TableId(type = IdType.AUTO)
    private Long menuId;
    private Long parentId;
    private String title;
    private String code;
    //标明这个字段在数据库里面是没有的，但是需要这个字段
    @TableField(exist = false)
    private Long value;
    @TableField(exist = false)
    private String label;
    private String type;
    private String icon;
    private String path;
    private String parentName;
    private Integer orderNum;
    private Date createTime;
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<>();
}

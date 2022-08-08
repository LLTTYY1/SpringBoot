package com.boot03.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName emp
 */
@TableName(value ="emp")
@Data
@ToString
public class Emp implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String ename;

    /**
     * 
     */
    private Integer deptid;

    /**
     * 
     */
    private Double sal;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
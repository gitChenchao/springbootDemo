package com.cc.cloud.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类名称：User<br>
 * 类描述：<br>
 * 创建时间：2018年04月30日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 6284609870351294927L;
    private String id;
    private String name;
    private String age;
}

package com.cc.cloud.bo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类名称：Company<br>
 * 类描述：<br>
 * 创建时间：2018年05月08日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@ToString
@Data
public class Company implements Serializable {
    private static final long serialVersionUID = -6954589537683212630L;

    private String companyName;

    private String companyAdress;
}

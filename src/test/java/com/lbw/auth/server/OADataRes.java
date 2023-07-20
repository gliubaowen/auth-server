package com.lbw.auth.server;

import java.io.Serializable;

import lombok.Data;

/**
 * OA登录响应数据
 *
 * @author LiuBaoWen
 *
 */
@Data
public class OADataRes implements Serializable {

	private static final long serialVersionUID = 2025269821854358515L;

	/** 用户名 */
	private String username;

	/** 工号 */
	private String account;

}

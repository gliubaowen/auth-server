package com.lbw.auth.server;

import java.io.Serializable;

import lombok.Data;

/**
 * OA登录响应信息
 *
 * @author LiuBaoWen
 *
 */
@Data
public class OALoginRes implements Serializable {

	private static final long serialVersionUID = -3297692637726882606L;

	/** 响应状态 0：请求成功 -1：请求失败 */
	private int status;

	/** 响应信息 */
	private String msg;

	/** 是否登录 true：登录信息有效 false:登录信息失效 */
	private boolean isLogin;

	/** 响应数据 */
	private OADataRes data;

}

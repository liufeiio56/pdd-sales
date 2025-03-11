package com.lora.pay.utils;


import com.lora.pay.constants.CommonConstants;
import com.lora.pay.constants.StatusCodeConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author lengleng
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String customCode;

	@Getter
	@Setter
	private String msg;


	@Getter
	@Setter
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, CommonConstants.SUCCESS, null, null);
	}
	public static <T> R<T> okCustom() {
		return restResult(null, CommonConstants.SUCCESS, null, StatusCodeConstants.ALL_IS_NORMAL);
	}

	public static <T> R<T> ok(String msg) {
		return restResult(null, CommonConstants.SUCCESS, msg, null);
	}
	public static <T> R<T> okCustom(String msg) {
		return restResult(null, CommonConstants.SUCCESS, msg, StatusCodeConstants.ALL_IS_NORMAL);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, CommonConstants.SUCCESS, null, null);
	}

	public static <T> R<T> okCustom(T data) {
		return restResult(data, CommonConstants.SUCCESS, null, StatusCodeConstants.ALL_IS_NORMAL);
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, CommonConstants.SUCCESS, msg, null);
	}
	public static <T> R<T> okCustom(T data, String msg) {
		return restResult(data, CommonConstants.SUCCESS, msg, StatusCodeConstants.ALL_IS_NORMAL);
	}

	public static <T> R<T> failed() {
		return restResult(null, CommonConstants.FAIL, null, null);
	}
	public static <T> R<T> failedCustom(String customCode) {
		return restResult(null, CommonConstants.FAIL, null, customCode);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, CommonConstants.FAIL, msg, null);
	}
	public static <T> R<T> failedCustom(String msg, String customCode) {
		return restResult(null, CommonConstants.FAIL, msg, customCode);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, CommonConstants.FAIL, null, null);
	}
	public static <T> R<T> failedCustom(T data, String customCode) {
		return restResult(data, CommonConstants.FAIL, null, customCode);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, CommonConstants.FAIL, msg, null);
	}
	public static <T> R<T> failedCustom(T data, String msg, String customCode) {
		return restResult(data, CommonConstants.FAIL, msg, customCode);
	}

	private static <T> R<T> restResult(T data, int code, String msg, String customCode) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		apiResult.setCustomCode(customCode);
		return apiResult;
	}
}

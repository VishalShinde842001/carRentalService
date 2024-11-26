package com.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

	private Integer status;

	private Object result;

	private String message;

}

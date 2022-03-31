package com.citi.projeto.model.exception;

import java.io.Serializable;
import java.time.Instant;

public class ErroPadrao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Instant timmeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
			
	public ErroPadrao() {
			}

	public ErroPadrao(Instant timmeStamp, Integer status, String error, String message, String path) {
		this.timmeStamp = timmeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimmeStamp() {
		return timmeStamp;
	}

	public void setTimmeStamp(Instant timmeStamp) {
		this.timmeStamp = timmeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	
	
}

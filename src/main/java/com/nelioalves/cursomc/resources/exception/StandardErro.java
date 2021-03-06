// ESSA CLASSE FOI CRIADA APENAS PARA CONTER O CONTEUDO DO ERRO PADRÃO QUE O PROGRAMA IRA MANDAR CASO OCORRA UMA EXESCÇÃO

package com.nelioalves.cursomc.resources.exception;

import java.io.Serializable;

public class StandardErro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	public StandardErro(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}

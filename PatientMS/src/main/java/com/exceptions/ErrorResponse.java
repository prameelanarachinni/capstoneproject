package com.exceptions;

import java.util.List;

public class ErrorResponse {
		private String msg;
		
		private int code;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public ErrorResponse(String msg, int code) {
			super();
			this.msg = msg;
			this.code = code;
		}

		public ErrorResponse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ErrorResponse(String msg2, List<String> details) {
			// TODO Auto-generated constructor stub
		}

	}







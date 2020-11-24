package com.myway.tok.model;

public class TokTok {
	
	
	
	public TokTok(String title) {
		super();
		this.title = title;
	}

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "TokTok [title=" + title + "]";
	}
	
}

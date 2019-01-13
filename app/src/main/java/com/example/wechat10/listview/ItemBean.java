package com.example.wechat10.listview;

public class ItemBean {
	public int itemImageid;
	public String itenTitle;
	public String itemContent;
	public String textTime;
	public String getTextTime() {
		return textTime;
	}

	public void setTextTime(String textTime) {
		this.textTime = textTime;
	}

	public int getItemImageid() {
		return itemImageid;
	}

	public void setItemImageid(int itemImageid) {
		this.itemImageid = itemImageid;
	}

	public String getItenTitle() {
		return itenTitle;
	}

	public void setItenTitle(String itenTitle) {
		this.itenTitle = itenTitle;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public ItemBean(int itemImageid, String itenTitle, String itemContent,String textTime) {
		
		this.itemImageid = itemImageid;
		this.itenTitle = itenTitle;
		this.itemContent = itemContent;
		this.textTime=textTime;
	}
	
}

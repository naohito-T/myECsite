package com.internousdev.ecsite.dto;

public class HairInfoDTO {
	private int id;
	private int hairId;
	private String hairDiscription;
	private String imageFilePath;
	private String imageFileName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHairId() {
		return hairId;
	}
	public void setHairId(int hairId) {
		this.hairId = hairId;
	}
	public String getHairDiscription() {
		return hairDiscription;
	}
	public void setHairDiscription(String hairDiscription) {
		this.hairDiscription = hairDiscription;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
}

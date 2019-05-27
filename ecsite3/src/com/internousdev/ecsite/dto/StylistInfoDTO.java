package com.internousdev.ecsite.dto;

public class StylistInfoDTO {

	private int id;
	private int stylistId;
	private String stylistName;
	private String stylistDescription;
	private String imageFilePath;
	private String imageFileName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStylistId() {
		return stylistId;
	}
	public void setStylistId(int stylistId) {
		this.stylistId = stylistId;
	}
	public String getStylistName() {
		return stylistName;
	}
	public void setStylistName(String stylistName) {
		this.stylistName = stylistName;
	}
	public String getStylistDescription() {
		return stylistDescription;
	}
	public void setStylistDescription(String stylistDescription) {
		this.stylistDescription = stylistDescription;
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

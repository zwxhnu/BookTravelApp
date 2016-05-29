package com.application.booktravel.model;


public class Book {

	private String name;

	private int imageId;

	public Book(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}

}

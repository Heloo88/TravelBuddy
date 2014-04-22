package com.travelbuddy.web.dao;


public class Review {

	private int id;
	private String title;
	private int rating;
	private String description;
	
	public void showReviews() {
		System.out.println(id + ". " + title + " : " + rating + "/10, description:"+ description);
	}

	public Review() {}
	
	public Review(String title, int rating, String description) {
		this.title = title;
		this.rating= rating;
		this.description = description;
	}
	
	public Review(int id, String title, int rating, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", rating=" + rating
				+ ", description=" + description + "]";
	}



}

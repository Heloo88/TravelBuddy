package com.travelbuddy.web.dao;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Review {

	private int id;
	@NotNull
	@Size(min = 5, max = 100, message = "Title must be between 5 and 100 character")
	private String title;

	@Max(value=10, message = "Rating between 1 and 10")	
	@Min(value=1, message = "Rating between 1 and 10")
	//@ValidRating(min=1)
	private int rating;
	
	@Size(min = 1, message = "Description must not be empty")
	private String description;
	//for email: @Pattern(regexp=".*\\@.*\\..*")
	
	public void showReviews() {
		System.out.println(id + ". " + title + " : " + rating
				+ "/10, description:" + description);
	}

	public Review() {
	}

	public Review(String title, int rating, String description) {
		this.title = title;
		this.rating = rating;
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

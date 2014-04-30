package com.travelbuddy.web.dao;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Review {

	private int id;
	
	private User user;
	
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
		this.user = new User();
	}

	public Review(User user, String title, int rating, String description) {
		this.title = title;
		this.rating = rating;
		this.description = description;
		this.user = user;
	}

	public Review(int id, User user, String title, int rating, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.user = user;		
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + rating;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (rating != other.rating)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", user=" + user + ", title=" + title
				+ ", rating=" + rating + ", description=" + description + "]";
	}


	public String getUsername() {
		return user.getUsername();
	}



	
}

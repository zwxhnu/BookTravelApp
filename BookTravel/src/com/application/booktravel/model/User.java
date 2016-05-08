package com.application.booktravel.model;

import java.util.HashSet;
import java.util.Set;

import com.application.booktravel.application.Mybook;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private Mybook mybook;
	private String username;
	private String password;
	private String tel;
	private String photo;
	private Set topics = new HashSet(0);
	private Set driftprocesses = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set mybooks = new HashSet(0);
	private Set bookreviews = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, String tel) {
		this.username = username;
		this.password = password;
		this.tel = tel;
	}

	/** full constructor */
	public User(Mybook mybook, String username, String password, String tel, String photo, Set topics,
			Set driftprocesses, Set comments, Set mybooks, Set bookreviews) {
		this.mybook = mybook;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.photo = photo;
		this.topics = topics;
		this.driftprocesses = driftprocesses;
		this.comments = comments;
		this.mybooks = mybooks;
		this.bookreviews = bookreviews;
	}

	public User(Mybook mybook, String username, String password, String tel, String photo) {
		this.mybook = mybook;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.photo = photo;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Mybook getMybook() {
		return this.mybook;
	}

	public void setMybook(Mybook mybook) {
		this.mybook = mybook;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set getTopics() {
		return this.topics;
	}

	public void setTopics(Set topics) {
		this.topics = topics;
	}

	public Set getDriftprocesses() {
		return this.driftprocesses;
	}

	public void setDriftprocesses(Set driftprocesses) {
		this.driftprocesses = driftprocesses;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getMybooks() {
		return this.mybooks;
	}

	public void setMybooks(Set mybooks) {
		this.mybooks = mybooks;
	}

	public Set getBookreviews() {
		return this.bookreviews;
	}

	public void setBookreviews(Set bookreviews) {
		this.bookreviews = bookreviews;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", mybook=" + mybook + ", username=" + username + ", password=" + password
				+ ", tel=" + tel + ", photo=" + photo + ", topics=" + topics + ", driftprocesses=" + driftprocesses
				+ ", comments=" + comments + ", mybooks=" + mybooks + ", bookreviews=" + bookreviews + "]";
	}

}
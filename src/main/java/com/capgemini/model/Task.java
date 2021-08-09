package com.capgemini.model;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="ttasks")
public class Task {
	
	@Id
	private long id;
	
	private String title;
	private String comments;
	private Date created;
	private Date planned;
	private Date finished;
	private String categoria;
	
	
	public Task(long id, String title) {
		super();
		this.id = id;
		this.title = title;
		this.comments = "";
		this.created = new Date();
		this.categoria = categoria;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getPlanned() {
		return planned;
	}


	public void setPlanned(Date planned) {
		this.planned = planned;
	}


	public Date getFinished() {
		return finished;
	}


	public void setFinished(Date finished) {
		this.finished = finished;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", comments=" + comments + ", created=" + created + ", planned="
				+ planned + ", finished=" + finished + ", categoria=" + categoria + "]";
	}
	
	
	
	
	
}
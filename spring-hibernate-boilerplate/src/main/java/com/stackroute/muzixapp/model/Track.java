package com.stackroute.muzixapp.model;

import javax.persistence.*;

@Entity
//make this class as hibernate entity
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Track{" +
				"id=" + id +
				", name='" + name + '\'' +
				", comment='" + comment + '\'' +
				'}';
	}
}

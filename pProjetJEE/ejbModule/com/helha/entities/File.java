package com.helha.entities;

import javax.persistence.Entity;

@Entity
public class File extends Media {

	public File() {
		super();
	}

	public File(String path, String description) {
		super(path, description);
	}

}

package main;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Publication {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	private int version;

	@ManyToMany
	@JoinTable(name = "publication_author",
			joinColumns = @JoinColumn(name = "publication_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors;
	
	private Date publishingDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	
}


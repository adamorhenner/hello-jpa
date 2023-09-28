package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Publication> publications;

	@ManyToMany
	@JoinTable(name = "author_article",
		joinColumns = @JoinColumn(name = "author_id"),
		inverseJoinColumns = @JoinColumn(name = "article_id"))
	private List<Article> articles = new ArrayList<>();

	@Embedded
	private Address address;

	public Author(){

	}

	public Author(Long id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

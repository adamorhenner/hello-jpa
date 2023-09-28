package main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Livro")
public class Book {
	
	static public enum StatusType {
		Available, Unavalaible, Removed
	}
	
	@Id
	@GeneratedValue
	@Column(name ="codigo")
	private Integer id;
	
	@Column(name ="titulo", nullable = false)
	private String title;
	
	@Column(name ="descricao", nullable = false)
	private String description;
	
	@Column(name ="isbn", nullable = false, unique = true)
	private String isbn;
	
	@Column(name ="data_publicacao", nullable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	private Calendar publishDate;
	
	@Enumerated(EnumType.STRING)
	private StatusType status;
	
	public Book() {
		this(null, "","","", new GregorianCalendar());
		
	}

	public Book(Integer id, String title, String description, String isbn, Calendar publishDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.isbn = isbn;
		this.publishDate = publishDate;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Calendar getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Calendar publishDate) {
		this.publishDate = publishDate;
	}
	
	
}

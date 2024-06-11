package entity.media.category;

import java.io.IOException;
import java.time.LocalDate;

import dao.DAOFactory;
import dao.ISpecificMediaDAO;
import exception.EmptyFieldsException;
import utils.Config;
import views.screen.BaseScreen;
import views.screen.admin.create.BookCreateScreen;
import views.screen.admin.create.SpecificMediaCreateScreen;

public class Book extends SpecificMedia{
	private int id;
	private String author;
	private String publisher;
	private String coverType;
	private LocalDate publicationDate;
	private int pages;
	private String genre;
	private String language;
	
	public Book() {};

	public Book(String author, String publisher, String coverType, LocalDate publicationDate, int pages, String genre,
			String language) {
		super();
		this.author = author;
		this.publisher = publisher;
		this.coverType = coverType;
		this.publicationDate = publicationDate;
		this.pages = pages;
		this.genre = genre;
		this.language = language;
	}

	public Book(int id, int mediaId, String author, String publisher, String coverType, LocalDate publicationDate,
			int pages, String genre, String language) {
		this.id = id;
		this.mediaId = mediaId;
		this.author = author;
		this.publisher = publisher;
		this.coverType = coverType;
		this.publicationDate = publicationDate;
		this.pages = pages;
		this.genre = genre;
		this.language = language;
	}

	@Override
	public ISpecificMediaDAO getSpecificMediaDAO() {
		// TODO Auto-generated method stub
		return DAOFactory.getInstance().getBookDAO();
	}
	
	public void fetch() {
		
	}
	
	public int getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getCoverType() {
		return coverType;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public int getPages() {
		return pages;
	}

	public String getGenre() {
		return genre;
	}

	public String getLanguage() {
		return language;
	}

	public void validateInfo() throws EmptyFieldsException {
		if (!validateEmptyFields()) throw new EmptyFieldsException("All fields, except pages, genre, language, must be filled!");
	}
	
	private boolean validateEmptyFields() {
		if (author.isEmpty() || publisher.isEmpty() || coverType.isEmpty() || publicationDate==null) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", mediaId=" + mediaId + ", author=" + author + ", publisher=" + publisher
				+ ", coverType=" + coverType + ", publicationDate=" + publicationDate + ", pages=" + pages + ", genre="
				+ genre + ", language=" + language + "]";
	}

	@Override
	public SpecificMediaCreateScreen getCreateScreen() throws IOException {
		return new BookCreateScreen(Config.BOOK_CREATE_SCREEN_PATH);
	}
	
}

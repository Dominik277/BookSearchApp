package book.search.app;

public class Book {

    private String openLibraryId;
    private String author;
    private String title;

    public String getOpenLibraryId() {
        return openLibraryId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getCoverUrl(){
        return "http://covers.openlibrary.org/b/olid"
                + openLibraryId + "-M.jpg?default=false";
    }

    public String getLargeCoverUrl(){
        return "http://covers.openlibrary.org/b/olid"
                + openLibraryId + "-M.jpg?default=false";
    }
}

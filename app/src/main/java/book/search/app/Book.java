package book.search.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public static Book fromJson(JSONObject jsonObject){
        Book book = new Book();
        try {
            if (jsonObject.has("cover_edition_key")){
                book.openLibraryId = jsonObject.getString("cover_edition_key");
            }else if (jsonObject.has("edition_key")){
                final JSONArray ids = jsonObject.getJSONArray("edition_key");
                book.openLibraryId = ids.getString(0);
            }
            book.title = jsonObject.has("title_suggest") ? jsonObject.getString("title_suggest"):"";
            book.author = getAuthor(jsonObject);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

}

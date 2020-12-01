package book.search.app;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Headers;

import android.os.Bundle;
import android.widget.ListView;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    private ListView lvBooks;
    private BookAdapter bookAdapter;
    private BookClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        lvBooks = findViewById(R.id.lvBooks);
        ArrayList<Book> aBooks = new ArrayList<Book>();
        bookAdapter = new BookAdapter(this,aBooks);
        lvBooks.setAdapter(bookAdapter);
    }

    private void fetchBooks(){
        client = new BookClient();
        client.getBooks("oscar Wilde", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON response) {
                try {
                    JSONArray docs = null;
                    if (response != null){
                        docs = response.getJSONArray("docs");
                        final ArrayList<Book> books = Book.fromJson(docs);
                        bookAdapter.clear();
                        for (Book book : books){
                            bookAdapter.add(book);
                        }
                        bookAdapter.notifyDataSetChanged();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }


        });
    }
}
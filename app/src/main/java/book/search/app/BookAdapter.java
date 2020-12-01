package book.search.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BookAdapter extends ArrayAdapter<Book> {

    //Book adapter nam omogućava da objekt od klase Book pretvorimo u nekakav View

    //Konstruktor
    public BookAdapter(Context context, ArrayList<Book> aBooks){
        super(context,0,aBooks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return null;
    }
}

package book.search.app;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends ArrayAdapter<Book> {

    private static class ViewHolder{
        public ImageView ivCover;
        public TextView tvTitle;
        public TextView tvAuthor;
    }
    //Book adapter nam omogućava da objekt od klase Book pretvorimo u nekakav View
    //Konstruktor
    public BookAdapter(Context context, ArrayList<Book> aBooks){
        super(context,0,aBooks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Book book = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_book,parent,false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.ivBookCover);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.tvAuthor = (TextView)convertView.findViewById(R.id.tvAuthor);
            convertView.setTag(viewHolder);
            }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTitle.setText(book.getTitle());
        viewHolder.tvAuthor.setText(book.getAuthor());
        Picasso.with(getContext()).load(Uri.parse(book.getCoverUrl()))
                .error(R.drawable.ic_nocover).into(viewHolder.ivCover);
        return convertView;
    }
}

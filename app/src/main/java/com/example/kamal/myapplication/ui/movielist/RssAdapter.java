package com.example.kamal.myapplication.ui.movielist;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamal.myapplication.R;
import com.example.kamal.myapplication.model.pojo.Item;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;



public class RssAdapter extends RecyclerView.Adapter<RssAdapter.MyViewHolder> {

    private List<Item> rssList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
      TextView tvTitle, tvDesc;
      ImageView background, image;

      public MyViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvDesc = itemView.findViewById(R.id.tvDesc);
        image = itemView.findViewById(R.id.imageImg);
        background = itemView.findViewById(R.id.imageBackground);

      }
    }


    public RssAdapter(List<Item> rssList) {
        this.rssList = rssList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rss_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      Document documentT = Jsoup.parse(rssList.get(position).getTitle());
      String srcT = documentT.select("img").attr("src");
      documentT.select("img").remove();
      String title = documentT.toString();
      holder.tvTitle.setText(Html.fromHtml(title));

      Document documentD = Jsoup.parse(rssList.get(position).getDescription());
      String srcD = documentD.select("img").attr("src");
      documentD.select("img").remove();
      String desc = documentD.toString();
      holder.tvDesc.setText(Html.fromHtml(desc));
      if (srcD != "" && srcD != null) {
        Picasso.with(holder.image.getContext()).load(srcD).into(holder.image);
      }
      else {
        holder.image.setImageDrawable(null);
      }
    }

    @Override
    public int getItemCount() {
        return rssList.size();
    }
}
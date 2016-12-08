package com.example.mrbennerham.calendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class FeedArticleRecyclerAdapter extends RecyclerView.Adapter<FeedArticleRecyclerAdapter.CustomViewHolder> {
    private List<FeedItem> feedItemList;
    private Context mContext;

    public FeedArticleRecyclerAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CustomViewHolder holder = (CustomViewHolder) view.getTag();
            int position = holder.getPosition();

            FeedItem feedItem = feedItemList.get(position);

            Bundle b = new Bundle();
            b.putString("valID", feedItem.getID());
            b.putString("valTitle", feedItem.getTitle());

            view.getContext().startActivity(new Intent(view.getContext(), ViewArticleActivity.class).putExtras(b));
        }
    };

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_article, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {

        //Handle click event on both title and image click
        customViewHolder.textView_title.setOnClickListener(clickListener);
        customViewHolder.textView_title.setTag(customViewHolder);
        FeedItem feedItem = feedItemList.get(i);
        customViewHolder.textView_title.setText(Html.fromHtml(feedItem.getTitle()));
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        //protected TextView textView_id;
        protected TextView textView_title;

        public CustomViewHolder(View view) {
            super(view);
            this.textView_title = (TextView) view.findViewById(R.id.titleSearch);
        }
    }
}

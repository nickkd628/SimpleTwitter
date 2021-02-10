package com.codepath.apps.restclienttemplate;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class TweetsAdapter extends  RecyclerView.Adapter<TweetsAdapter.ViewHolder> {
        Context context;
        List<Tweet>tweets;
        //pass in the context and list of tweets
        public TweetsAdapter (Context context,List<Tweet> tweets){
            this.context= context;
            this.tweets = tweets;
        }

        //for each row inflate the layout
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
            return new ViewHolder(view);
        }
        //bind values based on the postion of the element
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // get the data at postion
            Tweet tweet = tweets.get(position);
            //bind the tweet
            holder.bind(tweet);
        }

        @Override
        public int getItemCount() {
            return tweets.size();
        }

            // Clean all elements of the recycler
            public void clear() {
            tweets.clear();
            notifyDataSetChanged();
        }
        // Add a list of items
        public void addAll(List<Tweet> tweetList) {
            tweets.addAll( tweetList);
            notifyDataSetChanged();
        }



        //define a viewholder;
        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView ivProfileImage;
            TextView tvBody;
            TextView tvScreenName;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                ivProfileImage = itemView.findViewById(R.id.ivProfileImagie);
                tvBody = itemView.findViewById(R.id.tvBody);
                tvScreenName = itemView.findViewById(R.id.tvScreenName);

            }

            public void bind(Tweet tweet) {

                tvBody.setText(tweet.body);
                tvScreenName.setText(tweet.user.screenName);
                Glide.with(context).load(tweet.user.profileImageUrl).transform(new RoundedCornersTransformation(30, 10)).into(ivProfileImage);
            }
        }
    }

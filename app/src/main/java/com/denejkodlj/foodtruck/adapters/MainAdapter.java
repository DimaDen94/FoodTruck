package com.denejkodlj.foodtruck.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.denejkodlj.foodtruck.Data.Dish;
import com.denejkodlj.foodtruck.R;


import java.util.Date;
import java.util.List;

/**
 * Created by Dmitry on 09.10.2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private List<Dish> dishes;
    private Context mContext;


    public MainAdapter(Context context, List<Dish> dishes) {
        mContext = context;
        this.dishes = dishes;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView photo;
        private TextView title;
        private TextView ingredients;
        private TextView price;
        private TextView left;

        private MyViewHolder(View view) {
            super(view);
            photo = (ImageView) view.findViewById(R.id.photo_m_order);
            title = (TextView) view.findViewById(R.id.title_m_order);
            ingredients = (TextView) view.findViewById(R.id.ingredients_m_order);
            price = (TextView) view.findViewById(R.id.price_m_order);
            left = (TextView) view.findViewById(R.id.left_m_order);

        }


    }

    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        final Dish dish = dishes.get(position);

        holder.title.setText(dish.getTitle());
        holder.ingredients.setText(dish.getIngredients());
        String price = dish.getPrice() + " грн";
        holder.price.setText(price);
        String left = "Осталось " + dish.getLeft() + " порций";
        holder.left.setText(left);
        Glide.with(mContext)
                .load(dish.getPhoto())
                .thumbnail(0.01f)
                .crossFade()
                .into(holder.photo);
        holder.photo.setImageURI(Uri.parse(dish.getPhoto()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dish.setCount(dish.getCount()+1);
                    dish.save();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

}

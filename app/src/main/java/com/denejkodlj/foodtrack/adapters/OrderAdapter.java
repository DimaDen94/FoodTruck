package com.denejkodlj.foodtrack.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.denejkodlj.foodtrack.Dish;
import com.denejkodlj.foodtrack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 09.10.2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    private ArrayList<Dish> dishes;
    private Context mContext;


    public OrderAdapter(Context context, ArrayList<Dish> dishes) {
        mContext = context;
        this.dishes = dishes;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView photo;
        private TextView title;
        private TextView ingredients;
        private TextView price;

        private MyViewHolder(View view) {
            super(view);
            photo = (ImageView) view.findViewById(R.id.photo_order);
            title = (TextView) view.findViewById(R.id.title_order);
            ingredients = (TextView) view.findViewById(R.id.ingredients_order);
            price = (TextView) view.findViewById(R.id.price_order);
        }


    }

    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Dish dish = dishes.get(position);

        holder.title.setText(dish.getTitle());
        holder.ingredients.setText(dish.getIngredients());
        String price = dish.getPrice() + " грн";
        holder.price.setText(price);
        Glide.with(mContext)
                .load(dish.getPhoto())
                .thumbnail(0.01f)
                .crossFade()
                .into(holder.photo);
        holder.photo.setImageURI(Uri.parse(dish.getPhoto()));


    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public void removeItem(int position) {
        dishes.remove(position);
        notifyItemRemoved(position);
        Dish.deleteAll(Dish.class);
        addToList();
                // notify the item removed by position
                // to perform recycler view delete animations
                // NOTE: don't call notifyDataSetChanged()

    }


    private void addToList() {
        for (int i = 0; i <= dishes.size()-1; i++) {
            Dish dish = dishes.get(i);
            dish.save();
        }
    }
}

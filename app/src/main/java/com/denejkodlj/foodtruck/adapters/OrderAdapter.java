package com.denejkodlj.foodtruck.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.denejkodlj.foodtruck.Data.Dish;
import com.denejkodlj.foodtruck.R;

import java.util.ArrayList;

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
        private TextView price;
        private TextView count;
        private Button inc;
        private Button dinc;
        private TextView tot;


        private MyViewHolder(View view) {
            super(view);
            photo = (ImageView) view.findViewById(R.id.photo_order);
            title = (TextView) view.findViewById(R.id.title_order);
            price = (TextView) view.findViewById(R.id.price_order);
            count = (TextView) view.findViewById(R.id.d_count);
            inc = (Button) view.findViewById(R.id.btn_i_count);
            dinc = (Button) view.findViewById(R.id.btn_d_count);
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


        final Dish dish = dishes.get(position);

        holder.title.setText(dish.getTitle());
        String price = dish.getPrice() + " грн";

        holder.price.setText(price);

        holder.count.setText(String.valueOf(dish.getCount()));

        Glide.with(mContext)
                .load(dish.getPhoto())
                .thumbnail(0.01f)
                .crossFade()
                .into(holder.photo);


        holder.inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dish.setCount(dish.getCount()+1);
                dish.save();
                notifyDataSetChanged();
            }
        });

        holder.dinc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dish.getCount()>0) {
                    dish.setCount(dish.getCount() - 1);
                    dish.save();
                    notifyDataSetChanged();
                }
            }
        });


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
        for (int i = 0; i <= dishes.size() - 1; i++) {
            Dish dish = dishes.get(i);
            dish.save();
        }
    }
}

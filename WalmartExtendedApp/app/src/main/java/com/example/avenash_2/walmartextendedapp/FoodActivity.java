package com.example.avenash_2.walmartextendedapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    ListView lstFood;
    List<Food> foodItems =new ArrayList<>();
    static FoodActivity foodActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        lstFood=findViewById(R.id.lstFood);
        initializeFoodList();
        foodActivity=this;
        FoodListAdapter foodListAdapter=new FoodListAdapter();
        lstFood.setAdapter(foodListAdapter);
    }

    private void initializeFoodList() {
        foodItems.add(new Food(R.drawable.burger, "Burger", "Burger"));
        foodItems.add(new Food(R.drawable.chicken,"Chicken","Chicken"));
        foodItems.add(new Food(R.drawable.rice, "Rice", "Rice"));
        foodItems.add(new Food(R.drawable.samosa, "Samosa","Samosa"));
    }

    public class FoodListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return foodItems.size();
        }

        @Override
        public Object getItem(int position) {
            return foodItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(FoodActivity.foodActivity);
            View view=inflater.inflate(R.layout.layoutitemfoodlist, null);
            ImageView imageView = view.findViewById(R.id.ivFoodItemImage);
            TextView lblFoodDescription= view.findViewById(R.id.lblFoodItemDescription);

            imageView.setImageResource(foodItems.get(position).getResourseId());

            lblFoodDescription.setText(foodItems.get(position).getDescription());
            return view;

        }
    }
}

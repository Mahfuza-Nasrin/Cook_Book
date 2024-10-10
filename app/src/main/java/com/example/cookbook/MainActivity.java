package com.example.cookbook;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvRecipeTitle ,tvIngredients ,tvInstructions;
    LinearLayout listLayout;
    LinearLayout descriptionLayout;
    ListView listView;
    String [] recipeNames;
    Button btn_back;
    int [] recipeImages = {R.drawable.spaghetti,R.drawable.chickencurry,R.drawable.vegetable_stir_fry,R.drawable.caprese_salad,R.drawable.tacos,R.drawable.pancake,R.drawable.beef,R.drawable.minestrone_soup,R.drawable.chocolate_chip_cookies,R.drawable.greek_yogurt_parfait};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listLayout = findViewById(R.id.list_layout);
        descriptionLayout = findViewById(R.id.description_layout);

        listView = findViewById(R.id.listview);
        recipeNames = getResources().getStringArray(R.array.recipe_names);
        btn_back = findViewById(R.id.btn_back);
        tvRecipeTitle = findViewById(R.id.tv_recipeTitle);
        tvIngredients = findViewById(R.id.tv_ingredients);
        tvInstructions = findViewById(R.id.tv_instructions);


        CustomAdapter adapter = new CustomAdapter(this,recipeNames,recipeImages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                listLayout.setVisibility(View.GONE);
                descriptionLayout.setVisibility(View.VISIBLE);

                String recipeName = recipeNames[position];
                tvRecipeTitle.setText(recipeName);
                if(position==0) {
                    tvIngredients.setText(getString(R.string.spaghetti_ingredients));
                    tvInstructions.setText(getString(R.string.spaghetti_instructions));
                } else if(position==1){
                    tvIngredients.setText(getString(R.string.chicken_curry_ingredients));
                    tvInstructions.setText(getString(R.string.chicken_curry_instructions));
                } else if(position==2){
                    tvIngredients.setText(getString(R.string.veggie_stirfry_ingredients));
                    tvInstructions.setText(getString(R.string.veggie_stirfry_instructions));
                } else if(position==3){
                    tvIngredients.setText(getString(R.string.caprese_ingredients));
                    tvInstructions.setText(getString(R.string.caprese_instructions));
                } else if(position==4){
                    tvIngredients.setText(getString(R.string.tacos_ingredients));
                    tvInstructions.setText(getString(R.string.tacos_instructions));
                } else if(position==5){
                    tvIngredients.setText(getString(R.string.pancakes_ingredients));
                    tvInstructions.setText(getString(R.string.pancakes_instructions));
                } else if(position==6){
                    tvIngredients.setText(getString(R.string.beef_stirfry_ingredients));
                    tvInstructions.setText(getString(R.string.beef_stirfry_instructions));
                } else if(position==7){
                    tvIngredients.setText(getString(R.string.minestrone_ingredients));
                    tvInstructions.setText(getString(R.string.minestrone_instructions));
                } else if(position==8){
                    tvIngredients.setText(getString(R.string.cookies_ingredients));
                    tvInstructions.setText(getString(R.string.cookies_instructions));
                }  else if(position==9){
                    tvIngredients.setText(getString(R.string.parfait_ingredients));
                    tvInstructions.setText(getString(R.string.pancakes_instructions));
                }








            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listLayout.setVisibility(View.VISIBLE);
                descriptionLayout.setVisibility(View.GONE);




            }
        });





    }
}
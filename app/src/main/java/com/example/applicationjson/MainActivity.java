package com.example.applicationjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.applicationjson.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private static String url = "https://dummyjson.com/products";
    ActivityMainBinding binding;
    AdapterCard adapterCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapterCard = new AdapterCard(this);
        binding.recyclerview.setAdapter(adapterCard);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3, GridLayoutManager.VERTICAL,false);
        binding.recyclerview.setLayoutManager(gridLayoutManager);

        fetchJson();
        Log.i(TAG,"jsuis dans le oncreate"+ JSONObject.class);
    }

    private void fetchJson()
    {
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                   JSONArray jsonArrayCard = response.getJSONArray("products");

                   for (int i=0 ;i<jsonArrayCard.length();i++)
                   {
                       JSONObject jsonCard = jsonArrayCard.getJSONObject(i);

                       String title = jsonCard.getString("title");
                       String description = jsonCard.getString("description");
                       int price = jsonCard.getInt("price");
                       String thumbnail = jsonCard.getString("thumbnail");
                       CardShowModelClass cardShowModelClass = new CardShowModelClass(title,description,price,thumbnail);
                       adapterCard.add(cardShowModelClass);
                   }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }


}
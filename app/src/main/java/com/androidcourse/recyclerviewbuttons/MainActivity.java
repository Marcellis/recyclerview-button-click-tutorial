package com.androidcourse.recyclerviewbuttons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private List<Fruit> fruits = new ArrayList<>();
	private RecyclerView rvFruits;
	private FruitListAdapter fruitListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initToolbar();
		initFruitsList();
	}

	private void initToolbar() {
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		setTitle("Fruits");
	}

	private void initFruitsList() {
		fruitListAdapter = new FruitListAdapter(fruits);
		rvFruits = findViewById(R.id.rv_fruits);
		rvFruits.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		rvFruits.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
		rvFruits.setAdapter(fruitListAdapter);

		Fruit banana = new Fruit("Banana", 0);
		Fruit apple = new Fruit("Apple", 4);
		Fruit lemon = new Fruit("Lemon", 3);
		Fruit mango = new Fruit("Mango", 10);
		fruits.addAll(Arrays.asList(banana, apple, lemon, mango));
		updateRecyclerView();
	}

	private void updateRecyclerView() {
		fruitListAdapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

}

package com.androidcourse.recyclerviewbuttons;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class FruitListAdapter extends RecyclerView.Adapter<FruitListAdapter.ViewHolder> {

	private List<Fruit> fruits;
	private FruitsClickListener fruitsClickListener;

	public FruitListAdapter(List<Fruit> fruits, FruitsClickListener fruitsClickListener) {
		this.fruits = fruits;
		this.fruitsClickListener = fruitsClickListener;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new ViewHolder(
				LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fruit, viewGroup, false)
		);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
		final Fruit fruit = fruits.get(i);

		viewHolder.tvName.setText(fruit.getName());
		viewHolder.tvCount.setText(String.valueOf(fruit.getCount()));

		// Make a callback to the @FruitsClickListener.onPlusClick when clicking the plus button.
		viewHolder.ibPlus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				fruitsClickListener.onPlusClick(fruit);
			}
		});

		// Make a callback to the @FruitsClickListener.onMinusClick when clicking the minus button.
		viewHolder.ibMinus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				fruitsClickListener.onMinusClick(fruit);
			}
		});
	}

	@Override
	public int getItemCount() {
		return fruits.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		TextView tvName;
		TextView tvCount;
		ImageButton ibPlus;
		ImageButton ibMinus;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			tvName = itemView.findViewById(R.id.tv_name);
			tvCount = itemView.findViewById(R.id.tv_count);
			ibPlus = itemView.findViewById(R.id.ib_plus);
			ibMinus = itemView.findViewById(R.id.ib_minus);
		}
	}

	public interface FruitsClickListener {
		void onPlusClick(Fruit fruit);

		void onMinusClick(Fruit fruit);
	}
}

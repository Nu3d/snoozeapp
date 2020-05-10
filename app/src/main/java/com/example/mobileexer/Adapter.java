package com.example.mobileexer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter<String> {

	private Context context;
	private String[] soundName;
	private int[] soundPic;

	Adapter(Context c, int[] pic, String[] name) {
		super(c, R.layout.list_item, R.id.sound_name, name);
		this.context = c;
		this.soundName = name;
		this.soundPic = pic;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

		LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		@SuppressLint("ViewHolder") View list_item = layoutInflater.inflate(R.layout.list_item, parent, false);
		ImageView sound_pic = list_item.findViewById(R.id.sound_pic);
		TextView sound_name = list_item.findViewById(R.id.sound_name);


		sound_pic.setImageResource(soundPic[position]);
		sound_name.setText(soundName[position]);


		return list_item;
	}
}
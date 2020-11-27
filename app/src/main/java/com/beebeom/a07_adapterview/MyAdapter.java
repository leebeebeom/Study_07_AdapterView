package com.beebeom.a07_adapterview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Weather> mItems = new ArrayList<>();
    //이미지를 넣기위해 해쉬맵을 만들어줌.
    //해쉬맵은 키값을 넣으면 이미지를 리턴해주는 자료구조.
    private HashMap<String, Integer> mItemsImageMap;

    public void setItems(List<Weather> items) {
        mItems = items;
        mItemsImageMap = new HashMap<>();
        mItemsImageMap.put("맑음",R.drawable.sunny);
        mItemsImageMap.put("폭설",R.drawable.blizzard);
        mItemsImageMap.put("구름",R.drawable.cloudy);
        mItemsImageMap.put("비",R.drawable.rainy);
        mItemsImageMap.put("눈",R.drawable.snow);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //뷰홀더 패턴
        MyViewHolder viewHolder = new MyViewHolder();
        if (convertView == null) {
            //인플레이트 할 레이아웃을 만들어 줘야함.
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_weather, parent, false);
            viewHolder.weatherImage = convertView.findViewById(R.id.weather_image);
            viewHolder.cityText = convertView.findViewById(R.id.city_text);
            viewHolder.tempText = convertView.findViewById(R.id.temp_text);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) convertView.getTag();
        }
        //데이터 바이딩
        Weather weather = mItems.get(position);
        viewHolder.cityText.setText(weather.getCity());
        viewHolder.tempText.setText(weather.getTemp());
        //weather 객체에서 얻은 날씨 키값으로 해쉬맵에서 이미지를 로드해옴
        viewHolder.weatherImage.setImageResource(mItemsImageMap.get(weather.getWeather()));

        return convertView;
    }

    //뷰홀더 클래스 생성
    private static class MyViewHolder {
        ImageView weatherImage;
        TextView cityText;
        TextView tempText;
    }
}


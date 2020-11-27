package com.beebeom.a07_adapterview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);

        //데이터 준비
        List<Weather> weatherList = new ArrayList<>();
        //모델 클래스에 데이터 넣어주기
        //여기서 생성자가 쓰임
        weatherList.add(new Weather("서울", "맑음", "10도"));
        weatherList.add(new Weather("대전", "비", "15도"));
        weatherList.add(new Weather("대구", "구름", "17도"));
        weatherList.add(new Weather("부산", "눈", "21도"));
        weatherList.add(new Weather("전주", "폭설", "1도"));
        weatherList.add(new Weather("인천", "맑음", "2도"));
        weatherList.add(new Weather("부천", "비", "9도"));
        weatherList.add(new Weather("제주", "구름", "5도"));
        weatherList.add(new Weather("강원", "눈", "10도"));
        weatherList.add(new Weather("춘천", "폭설", "8도"));
        //어댑터
        MyAdapter adapter = new MyAdapter();
        //어댑터에 데이터 넣어주기
        adapter.setItems(weatherList);
        mListView.setAdapter(adapter);



    }
}
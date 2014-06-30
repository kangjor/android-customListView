package com.example.android09_customlistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class CustomListActivity extends ActionBarActivity {
	
	// 리스트뷰 객체 선언
	ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_list);
		//xml로 부터 객체 생성
		listview = (ListView) findViewById(R.id.listview);
		// 나만의 아답터 클래스 만들어줌
		// ArrayList에 데이터를 삽입
		ArrayList<Star> list = new ArrayList<>();
		list.add(new Star(R.drawable.icon01, "김태희", "비의 여자친구"));
		list.add(new Star(R.drawable.icon02, "한효주", "광해 주인공"));
		list.add(new Star(R.drawable.icon03, "윤은혜", "베이비복스 멤버"));
		list.add(new Star(R.drawable.icon04, "신민아", "구미호 주인공"));
		list.add(new Star(R.drawable.icon05, "성유리", "핑클 전 멤버"));
		list.add(new Star(R.drawable.icon06, "이민정", "이병헌 아내"));
		list.add(new Star(R.drawable.icon07, "박신혜", "상속자들"));
		
		// 우리가 만든 어뎁터 클래스 객체 생성
		ImageAdapter adapter = new ImageAdapter(this, R.layout.customlist, list);
		// 리스트 뷰에 붙임
		listview.setAdapter(adapter);
	}

}

package com.example.android09_customlistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// 이미지를 한꺼번에 등록하여 주는 어덥터 클래스임
public class ImageAdapter extends BaseAdapter {
	
	// 액티비티로 부터 컨텍스트 값을 받아온다.
	// 모든 뷰는 어떤 액티비티에 보여줘야할지 대한 정보를 받아야 한다. !!!!important
	Context mcontext;
	// 레이아웃 객체를 얻어오기 위한 변수 선언
	int layoutRes; 
	// 이미지와 데이터를 한꺼번에 저장하는 Star객체를 저장하는 객체 선언
	ArrayList<Star> slist;
	LayoutInflater inflater;
	// 체크박스를 이용하여 이벤트를 설정하기 위해서 체크박스 객체 선언
	CheckBox check;
	
	// 생성자를 이용하여 각종 정보를 액티비티로 부터 받아옴
	public ImageAdapter(Context context, int layout, ArrayList<Star> list) {
		mcontext = context;
		layoutRes = layout;
		slist = list;
		// 리스트뷰에 들어갈 한칸에 대한 레이아웃을 가져옴
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// 몇개의 데이터를 listview에 붙일지 갯수를 파악
		return slist.size();
	}

	@Override
	public Object getItem(int index) {
		// 인자로 넘어오는 인덱스(listview의 인덱스)값을 알아내어 해당 객체를 리턴
		return slist.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		// 지역변수는 리턴하면 사라지기 때문에 final로 만들어줌
		final int pos = index;
		
		// 메소드가 처음 실행되면 null값이 넘어옴
		if(view == null) {
			// 우리가 직접만든 customlist.xml에 레이아웃을 가져온다.
			view = inflater.inflate(layoutRes, parent, false);
		}
		// 커스텀 뷰에서 사용할 3개의 데이터를 넣어줌
		// 1. 이미지뷰에 이미지 값을 넣어줌
		// 이미지 객체 생성 (customlist.xml에 선언한 imageview 값을 가져옴
		ImageView image = (ImageView) view.findViewById(R.id.image);
		// 이미지뷰에 값을 대입
		image.setImageResource(slist.get(pos).imgres);
		// 2. 연예인의 이름을 부여
		// customlist에서 선언한 textview객체를 가져옴
		TextView tview = (TextView) view.findViewById(R.id.name);
		tview.setText(slist.get(pos).name);
		// 3. 연예인의 이름을 부여
		// customlist에서 선언한 textview객체를 가져옴
		TextView tintro = (TextView) view.findViewById(R.id.intro);
		tintro.setText(slist.get(pos).intro);
		// 체크박스 객체 생성
		check = (CheckBox) view.findViewById(R.id.checkbox);
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					Toast.makeText(mcontext, slist.get(pos).intro + "인 " + slist.get(pos).name, 1).show();
				} else {
					Toast.makeText(mcontext, slist.get(pos).name + "해제", 1).show();
				}
				
			}
		});
		
		return view;
	}
	
}

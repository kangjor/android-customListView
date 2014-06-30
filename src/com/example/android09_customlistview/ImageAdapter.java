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

// �̹����� �Ѳ����� ����Ͽ� �ִ� ����� Ŭ������
public class ImageAdapter extends BaseAdapter {
	
	// ��Ƽ��Ƽ�� ���� ���ؽ�Ʈ ���� �޾ƿ´�.
	// ��� ��� � ��Ƽ��Ƽ�� ����������� ���� ������ �޾ƾ� �Ѵ�. !!!!important
	Context mcontext;
	// ���̾ƿ� ��ü�� ������ ���� ���� ����
	int layoutRes; 
	// �̹����� �����͸� �Ѳ����� �����ϴ� Star��ü�� �����ϴ� ��ü ����
	ArrayList<Star> slist;
	LayoutInflater inflater;
	// üũ�ڽ��� �̿��Ͽ� �̺�Ʈ�� �����ϱ� ���ؼ� üũ�ڽ� ��ü ����
	CheckBox check;
	
	// �����ڸ� �̿��Ͽ� ���� ������ ��Ƽ��Ƽ�� ���� �޾ƿ�
	public ImageAdapter(Context context, int layout, ArrayList<Star> list) {
		mcontext = context;
		layoutRes = layout;
		slist = list;
		// ����Ʈ�信 �� ��ĭ�� ���� ���̾ƿ��� ������
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// ��� �����͸� listview�� ������ ������ �ľ�
		return slist.size();
	}

	@Override
	public Object getItem(int index) {
		// ���ڷ� �Ѿ���� �ε���(listview�� �ε���)���� �˾Ƴ��� �ش� ��ü�� ����
		return slist.get(index);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		// ���������� �����ϸ� ������� ������ final�� �������
		final int pos = index;
		
		// �޼ҵ尡 ó�� ����Ǹ� null���� �Ѿ��
		if(view == null) {
			// �츮�� �������� customlist.xml�� ���̾ƿ��� �����´�.
			view = inflater.inflate(layoutRes, parent, false);
		}
		// Ŀ���� �信�� ����� 3���� �����͸� �־���
		// 1. �̹����信 �̹��� ���� �־���
		// �̹��� ��ü ���� (customlist.xml�� ������ imageview ���� ������
		ImageView image = (ImageView) view.findViewById(R.id.image);
		// �̹����信 ���� ����
		image.setImageResource(slist.get(pos).imgres);
		// 2. �������� �̸��� �ο�
		// customlist���� ������ textview��ü�� ������
		TextView tview = (TextView) view.findViewById(R.id.name);
		tview.setText(slist.get(pos).name);
		// 3. �������� �̸��� �ο�
		// customlist���� ������ textview��ü�� ������
		TextView tintro = (TextView) view.findViewById(R.id.intro);
		tintro.setText(slist.get(pos).intro);
		// üũ�ڽ� ��ü ����
		check = (CheckBox) view.findViewById(R.id.checkbox);
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					Toast.makeText(mcontext, slist.get(pos).intro + "�� " + slist.get(pos).name, 1).show();
				} else {
					Toast.makeText(mcontext, slist.get(pos).name + "����", 1).show();
				}
				
			}
		});
		
		return view;
	}
	
}

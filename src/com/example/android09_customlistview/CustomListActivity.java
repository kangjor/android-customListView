package com.example.android09_customlistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

public class CustomListActivity extends ActionBarActivity {
	
	// ����Ʈ�� ��ü ����
	ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_list);
		//xml�� ���� ��ü ����
		listview = (ListView) findViewById(R.id.listview);
		// ������ �ƴ��� Ŭ���� �������
		// ArrayList�� �����͸� ����
		ArrayList<Star> list = new ArrayList<>();
		list.add(new Star(R.drawable.icon01, "������", "���� ����ģ��"));
		list.add(new Star(R.drawable.icon02, "��ȿ��", "���� ���ΰ�"));
		list.add(new Star(R.drawable.icon03, "������", "���̺񺹽� ���"));
		list.add(new Star(R.drawable.icon04, "�Źξ�", "����ȣ ���ΰ�"));
		list.add(new Star(R.drawable.icon05, "������", "��Ŭ �� ���"));
		list.add(new Star(R.drawable.icon06, "�̹���", "�̺��� �Ƴ�"));
		list.add(new Star(R.drawable.icon07, "�ڽ���", "����ڵ�"));
		
		// �츮�� ���� ��� Ŭ���� ��ü ����
		ImageAdapter adapter = new ImageAdapter(this, R.layout.customlist, list);
		// ����Ʈ �信 ����
		listview.setAdapter(adapter);
	}

}

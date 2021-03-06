package de.jonesir.fakultaeten;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import de.jonesir.R;

public class FakultaetenListAdapter extends BaseAdapter {
	private String[] _listItems;
	private Context _context;

	public FakultaetenListAdapter(Context context) {
		this._context = context;
		this._listItems = this._context.getResources().getStringArray(R.array.fakultaeten);
	}

	@Override
	public int getCount() {
		return this._listItems.length;
	}

	@Override
	public Object getItem(int arg0) {
		return this._listItems[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		convertView = LayoutInflater.from(this._context).inflate(R.layout.fakultaeten_list_item, null);
		TextView index = (TextView) convertView.findViewById(R.id.index);
		index.setText("" + (1 + arg0));
		TextView item = (TextView) convertView.findViewById(R.id.item_text);
		item.setText(this._listItems[arg0]);
		// item.setBackgroundColor(arg0%2==0?this._context.getResources().getColor(R.color.white):this._context.getResources().getColor(R.color.tubs_theme_color));
		item.setBackgroundColor(this._context.getResources().getColor(R.color.white));
		// item.setTextColor(arg0%2==0?this._context.getResources().getColor(R.color.tubs_theme_color):this._context.getResources().getColor(R.color.white));
		item.setTextColor(this._context.getResources().getColor(R.color.tubs_theme_color));
		return convertView;
	}

}

package de.jonesir;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import de.jonesir.R;

public class NaviListAdapter extends BaseAdapter {
	private String[] _naviItems;
	private Context _context;
	private int _selected;

	public NaviListAdapter(Context context, String[] mPlanetTitles) {
		this._context = context;
		this._naviItems = mPlanetTitles;
	}

	@Override
	public int getCount() {
		return this._naviItems.length;
	}

	@Override
	public Object getItem(int arg0) {
		return this._naviItems[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	public void setSelected(int index) {
		this._selected = index;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		convertView = LayoutInflater.from(this._context).inflate(R.layout.drawer_list_item, null);
		TextView item = (TextView) convertView.findViewById(R.id.naviItemText);
		item.setText(this._naviItems[arg0]);
		Resources resource = this._context.getResources();
		if (this._selected == arg0) {
			item.setBackgroundColor(resource.getColor(R.color.navi_item_selected_background_color));
			item.setTextColor(resource.getColor(R.color.navi_item_selected_text_color));
		} else {
			item.setBackgroundColor(resource.getColor(R.color.tubs_theme_color));
			item.setTextColor(resource.getColor(R.color.default_text_color));
		}
		return convertView;
	}

}

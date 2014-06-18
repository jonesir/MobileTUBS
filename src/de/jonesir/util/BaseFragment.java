package de.jonesir.util;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import de.jonesir.MainActivity;
import de.jonesir.R;

public class BaseFragment extends Fragment implements OnClickListener{
	private Context _context;
	private RelativeLayout _relativeLayout;
	
	public BaseFragment(){}
	
	public Context getContext() {
		return _context;
	}

	public RelativeLayout getRelativeLayout() {
		return _relativeLayout;
	}

	public BaseFragment(Context context) {
		this._context = context;
	}
	
	public void showDrawer(){
		((MainActivity)this._context).showDrawer();
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.base, null);
		this._relativeLayout = (RelativeLayout)v;
		
		TextView titleView = (TextView)v.findViewById(R.id.title);
		titleView.setText(getArguments().getString("TITLE"));
		titleView.setOnClickListener(this);
		
		((ImageView)v.findViewById(R.id.drawer_icon)).setOnClickListener(this);
		
		return v;
	}

	@Override
	public void onClick(View arg0) {
		showDrawer();
	}

}

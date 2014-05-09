package de.jonesir.fakultaeten;

import de.jonesir.util.BaseFragment;
import de.jonesir.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class FakultaetenFragment extends BaseFragment {

	public FakultaetenFragment(Context context) {
		super(context);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// get parent view
		View v = super.onCreateView(inflater, container, savedInstanceState);
		
		RelativeLayout title = getRelativeLayout();
		
		ListView listView = (ListView)LayoutInflater.from(getContext()).inflate(R.layout.list, null);
		listView.setAdapter(new FakultaetenListAdapter(getContext()));
		
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.BELOW, R.id.divider_view);
		listView.setLayoutParams(params);
		
		
		title.addView(listView);
		
		return v;
	}
}

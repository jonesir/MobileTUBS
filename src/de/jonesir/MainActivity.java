package de.jonesir;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import de.jonesir.R;
import de.jonesir.fakultaeten.FakultaetenFragment;
import de.jonesir.institute.InstituteFragment;
import de.jonesir.util.BaseFragment;
import de.jonesir.wirueberuns.WirueberunsFragment;
import de.jonesir.zentraleeinrichtungen.ZentraleeinrichtungenFragment;

/**
 * 
 * @author jonesir
 *
 */
public class MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private RelativeLayout mRelativeLayout;

	private CharSequence mTitle;
	private String[] mNaviTitles;
	private NaviListAdapter _adapter;
	private ArrayList<BaseFragment> _fragments = new ArrayList<BaseFragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = getTitle();
		mNaviTitles = getResources().getStringArray(R.array.tubs_navi_list);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mRelativeLayout = (RelativeLayout) findViewById(R.id.left_drawer);
		mDrawerList = (ListView) findViewById(R.id.menu_list);

		// set a custom shadow that overlays the main content when the drawer opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		// set up the drawer's list view with items and click listener
		this._adapter = new NaviListAdapter(this, mNaviTitles);
		mDrawerList.setAdapter(this._adapter);
		mDrawerList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selectItem(position);
			}
		});

		_fragments.add(new WirueberunsFragment(this));
		_fragments.add(new FakultaetenFragment(this));
		_fragments.add(new InstituteFragment(this));
		_fragments.add(new ZentraleeinrichtungenFragment(this));

		if (savedInstanceState == null) {
			selectItem(1);
		}
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments
		BaseFragment fragment = _fragments.get(position);
		if (fragment.getArguments() == null) {
			Bundle args = new Bundle();
			args.putString("TITLE", mNaviTitles[position]);
			fragment.setArguments(args);
		}
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
		// update selected item and title, then close the drawer
		this._adapter.setSelected(position);
		this._adapter.notifyDataSetChanged();
		closeDrawer();
	}

	public void closeDrawer() {
		mDrawerLayout.closeDrawer(mRelativeLayout);
	}

	public void showDrawer() {
		mDrawerLayout.openDrawer(mRelativeLayout);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
}
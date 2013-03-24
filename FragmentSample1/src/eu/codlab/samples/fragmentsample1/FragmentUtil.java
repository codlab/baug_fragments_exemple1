package eu.codlab.samples.fragmentsample1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class FragmentUtil {
	private static ItemDetailFragment _detail_fragment;
	private static ItemListFragment _list_fragment;
	
	public static Fragment getTopFragment(FragmentManager manager, int ressource_id){
		return manager.findFragmentById(ressource_id);
	}
	
	public static boolean isTopBackable(Fragment fragment){
		return fragment != null && fragment instanceof ItemDetailFragment;
	}
	
	public static boolean isTopBackable(FragmentManager manager, int ressource_id){
		return isTopBackable(manager.findFragmentById(ressource_id));
	}
}

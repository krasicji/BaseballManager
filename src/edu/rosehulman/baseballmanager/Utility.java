package edu.rosehulman.baseballmanager;

import android.app.ActionBar.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;


/*
 * This is outside code found from Stack Overflow user "DougW" found here:
 * http://stackoverflow.com/questions/3495890/how-can-i-put-a-listview-into-a-scrollview-without-it-collapsing
 */
public class Utility {

	public static void setListViewHeightBasedonChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
        // pre-condition
              return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        for (int i = 0; i < listAdapter.getCount(); i++) {
             View listItem = listAdapter.getView(i, null, listView);
             if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
             }
             listItem.measure(0, 0);
             totalHeight += listItem.getMeasuredHeight() + 1;
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
                  listView.setLayoutParams(params);
    }	
}

package com.cat.leopard.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import com.cat.leopard.R;

@SuppressLint("NewApi")
public class WebViewsActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_web);
    
    }
	
	@Override
	protected void onResume() {
	    // TODO Auto-generated method stub
	    super.onResume();
	
	    
	    
	}
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
     
//        getActionBar();
//        getActionBar().show();
//        getActionBar().setHomeButtonEnabled(true);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setDisplayShowHomeEnabled(true);
       
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.web, menu);
    }
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
        case android.R.id.home:
           
            setContentView(R.layout.activity_web);
            setTheme(android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            break;
        default:
            break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}

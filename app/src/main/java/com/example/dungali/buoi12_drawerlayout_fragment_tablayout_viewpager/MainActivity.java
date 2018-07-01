package com.example.dungali.buoi12_drawerlayout_fragment_tablayout_viewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dungali.adapter.DrawerAdapter;
import com.example.dungali.adapter.PagerAdapter;
import com.example.dungali.model.Story;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
  DrawerLayout drawerLayout;
  TabLayout tlTitleStory;
  ViewPager vpContentStory;
  ListView lvStory;
  ArrayList<Story> arrStory;
  DrawerAdapter drawerAdapter;
  //Button xu ly su kien tren actionbar
  ActionBarDrawerToggle toggle;
  PagerAdapter pagerAdapter;
  android.support.v7.app.ActionBar actionBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setUpActionBar();
    addNavigation();//thanh menu ben tay trai
    addViewPagerAndTabLayout();
    addEvents();
  }

  private void setUpActionBar() {
    actionBar = getSupportActionBar();
    actionBar.setHomeButtonEnabled(true);
    actionBar.setDisplayHomeAsUpEnabled(true);
  }

  private void addNavigation() {
    lvStory = (ListView) findViewById(R.id.lvStory);
    arrStory = new ArrayList<Story>();
    arrStory.add(new Story(R.drawable.conan, "Conan Story"));
    arrStory.add(new Story(R.drawable.doremon, "Doremon Story"));
    arrStory.add(new Story(R.drawable.dragon, "Dragon Story"));
    drawerAdapter = new DrawerAdapter(this, arrStory);
    lvStory.setAdapter(drawerAdapter);

    drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) {
      @Override
      public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        actionBar.setTitle(R.string.menu);
      }

      @Override
      public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        actionBar.setTitle(R.string.story);
      }
    };
    drawerLayout.addDrawerListener(toggle);

  }

  private void addViewPagerAndTabLayout() {
    vpContentStory = (ViewPager) findViewById(R.id.vpContentStory);
    pagerAdapter = new PagerAdapter(getSupportFragmentManager(), arrStory);
    vpContentStory.setAdapter(pagerAdapter);
    tlTitleStory = (TabLayout) findViewById(R.id.tlTitleStory);
    tlTitleStory.setupWithViewPager(vpContentStory);
  }

  private void addEvents() {

    lvStory.setOnItemClickListener(this);
    vpContentStory.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {
        Toast.makeText(MainActivity.this, "page " + position, Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    toggle.syncState();
    if (toggle.onOptionsItemSelected(item)) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    vpContentStory.setCurrentItem(i, true);
    drawerLayout.closeDrawer(lvStory);
  }
}

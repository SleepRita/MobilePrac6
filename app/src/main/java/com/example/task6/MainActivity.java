package com.example.task6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {
    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получаем ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Главная");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //ActionBarDrawerToggle, который добавит иконку меню для открытия и закрытия
        // Drawer и обеспечит анимацию иконки
        toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, R.string.drawer_open, R.string.drawer_close);

        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView myNavigationView = findViewById(R.id.nav_view);
        myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id  == R.id.ant) {
                    OnClick1(findViewById(R.id.ant));
                    actionBar.setTitle("Муравей");
                    drawer.close();
                } else if (id == R.id.dragonfly) {
                    OnClick2(findViewById(R.id.dragonfly));
                    actionBar.setTitle("Стрекоза");
                    drawer.close();
                } else if (id == R.id.bee) {
                    OnClick3(findViewById(R.id.bee));
                    actionBar.setTitle("Пчела");
                    drawer.close();
                } else if (id == R.id.bumblebee) {
                    OnClick4(findViewById(R.id.bumblebee));
                    actionBar.setTitle("Шмель");
                    drawer.close();
                } else if (id == R.id.butterfly) {
                    OnClick5(findViewById(R.id.butterfly));
                    actionBar.setTitle("Бабочка");
                    drawer.close();
                } else if (id == R.id.next_activity) {
                    OnClick6(findViewById(R.id.butterfly));
                    drawer.close();
                }
                return false;
            }
        });
    }

    // Обработка нажатия на иконку меню в ActionBar для открытия и закрытия Drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnClick1(View view)
    {
        Fragment1 f1 = new Fragment1();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.conteiner,f1);
        ft.commit();
    }

    public void OnClick2(View view)
    {
        Fragment2 f2 = new Fragment2();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.conteiner,f2);
        ft.commit();
    }

    public void OnClick3(View view)
    {
        Fragment3 f3 = new Fragment3();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.conteiner,f3);
        ft.commit();
    }

    public void OnClick4(View view)
    {
        Fragment4 f4 = new Fragment4();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.conteiner,f4);
        ft.commit();
    }

    public void OnClick5(View view)
    {
        Fragment5 f5 = new Fragment5();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.conteiner,f5);
        ft.commit();
    }

    public void OnClick6(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}
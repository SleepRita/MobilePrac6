package com.example.task6;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Получаем ActionBar
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GRAY));

        // При нажатии на значок откроется боковая панель
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // Показать кнопку назад
            actionBar.setTitle("Главная");

            BottomNavigationView bottomNavigationView = (findViewById(R.id.bottom_navigation));
            bottomNavigationView.setBackground(new ColorDrawable(Color.LTGRAY));
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.home) {
                    actionBar.setTitle("Главная");
                } else if (item.getItemId() == R.id.notification) {
                    actionBar.setTitle("Уведомления");
                    OnClick(findViewById(R.id.notification));

                } else if (item.getItemId() == R.id.settings) {
                    actionBar.setTitle("Настройки");
                    OnClick2(findViewById(R.id.settings));
                }
                return false;
            });
        }
    }

    public void OnClick(View view)
    {
        BlankFragment1 f1 = new BlankFragment1();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.conteiner2,f1);
        ft.commit();
    }

    public void OnClick2(View view)
    {
        BlankFragment2 f2 = new BlankFragment2();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.conteiner2,f2);
        ft.commit();
    }
}
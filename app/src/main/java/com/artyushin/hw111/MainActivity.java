package com.artyushin.hw111;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Настройки", "Записная книжка", "Регистрация", "Платеж"
    };

    String[] subtitle ={
            "Переход в системные настройки",
            "Приложение Записная книжка.\n" +
                    "Данные сохраняютя и подгружаются при следующем запуске приложения. \n" +
                    "Используется SharedPreferences",
            "Простая форма для ввода регистрационных данных",
            "Интерфейс для ввода данных о платеже"
    };

    // Картинки можно подобрать посимпатичнее, но в задании написано "скриншот"...
    Integer[] imgid={
            R.mipmap.ic_settings,R.mipmap.ic_note,
            R.mipmap.ic_password,R.mipmap.ic_payment
    };

    Boolean ischecket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        setSupportActionBar(toolbar);

        final ItemData adapter=new ItemData(this, maintitle, subtitle, imgid, ischecket);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_settings : {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                return true;
            }
            case R.id.main_menu_note : {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.main_menu_login : {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.main_menu_payment : {
                Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return false;
    }
}
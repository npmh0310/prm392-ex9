package com.example.ex9;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.squareup.picasso.Picasso;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main
        ), (v, insets) -> {
            Insets systemBars =
                    insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });
//Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//TextView
        TextView textView = (TextView)
                findViewById(R.id.tvShow);
//ImageView 1
        ImageView imageView1 = (ImageView)
                findViewById(R.id.imageView1);
//ImageView 2
        ImageView imageView2 = (ImageView)
                findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.anh2);

//ImageView 3
        ImageView imageView3 = (ImageView)
                findViewById(R.id.imageView3);
        String url =
                "https://th.bing.com/th/id/OIP.Cga6n463iIHOMxogvt7hdQHaEK?rs=1&pid=ImgDetMain";
        if (url == null || url.equals("")) {
            Toast.makeText(MainActivity.this, "Error",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Picasso.get()
                    .load(url)
                    .into(imageView3);
        }
//Long press ImageViews to dislay Context Menu
        registerForContextMenu(imageView1);
        registerForContextMenu(imageView2);
        registerForContextMenu(imageView3);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.message) {
            Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.picture)
        {
            Toast.makeText(getApplicationContext(), "You clicked Picture menu", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.mode)
        {
            Toast.makeText(getApplicationContext(),"You clicked Mode menu",Toast.LENGTH_SHORT).show();
            return true;

        }
        else if (item.getItemId() == R.id.option_favorites1)
        {
            Toast.makeText(getApplicationContext(),"You clicked Music menu",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.option_favorites2)
        {
            Toast.makeText(getApplicationContext(),"You clicked Book menu",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.about)
        {
            Toast.makeText(getApplicationContext(),"You clicked About menu",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.exit)
        {
            finish();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.context_edit) {
            Toast.makeText(this, "Edit clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (item.getItemId() == R.id.context_delete) {
            Toast.makeText(this, "Delete clicked", Toast.LENGTH_SHORT).show();

            return true;
        }
        else if (item.getItemId() == R.id.context_share) {
            Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return super.onContextItemSelected(item);
    }
}
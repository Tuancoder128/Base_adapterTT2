package com.example.dell.base_adaptertt2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.base_adaptertt2.Adapter.Album;
import com.example.dell.base_adaptertt2.Adapter.Custombaseadapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listAlbum;
    int[] Hinhalbum = {R.drawable.aqua, R.drawable.aslongasyouloveme, R.drawable.images, R.drawable.nevergone, R.drawable.noname};
    String[] Tenalbum = {"Thach Sanh", "Tam Cam", "Thanh Giong", "Co Tam", "Chi Pheo"};
    String[] Ngayphathanh = {"1/2/1886", "2/3/1887", "3/6/2001", "5/5/2005", "7/8/2016"};
    List<Album> danhsachalbum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAlbum = (ListView) findViewById(R.id.LvAlbum);
        danhsachalbum =  new ArrayList<>();
        for(int i = 0 ; i<Hinhalbum.length;i++){
            Album album = new Album();
            album.setHinhAlbum(Hinhalbum[i]);
            album.setTenAlbum(Tenalbum[i]);
            album.setNgayPhatHanh(Ngayphathanh[i]);

            danhsachalbum.add(album);

        }
        Custombaseadapter custombaseadapter = new Custombaseadapter(MainActivity.this,R.layout.layout_custom_baseadapter,danhsachalbum);
        custombaseadapter.notifyDataSetChanged();
        listAlbum.setAdapter(custombaseadapter);


        listAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "ngay phat hanh la :"+ danhsachalbum.get(position).getNgayPhatHanh(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}

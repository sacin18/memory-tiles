package com.example.sacin.remembertiles;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.Math.*;

/**
 * Created by sacin on 10/30/2017.
 */
public class MemoryTiles  extends AppCompatActivity {
    public static ImageButton mtib[]=new ImageButton[20];
    public static Button mtbtn;
    public static TextView mttv;
    public static int grid[]=new int[20];
    public static int isDone[]=new int[20];
    int corrects=0,numberOfOpenTiles=0,score=100;
    void initGame()
    {
        corrects=0;numberOfOpenTiles=0;score=100;
        initgrid();
        initbuttons();
    }
    void initbuttons()
    {
        for(int i=0;i<grid.length;i++)
        {
            mtib[i]=(ImageButton)findViewById(getResources().getIdentifier("mtib"+i,"id",getPackageName()));
            //mtib[i].setBackgroundColor(250);
            if(grid[i]==1){mtib[i].setBackgroundColor(Color.parseColor("#0000ff"));numberOfOpenTiles++;}
            else mtib[i].setBackgroundColor(Color.parseColor("#000000"));
            mtib[i].setVisibility(View.VISIBLE);
        }
    }
    void initgrid()
    {
        int r;//= (int) (Math.random());
        for(int i=0;i<grid.length;i++)
        {
            r =  (int)(Math.random()+0.5);
            grid[i]=r;
            isDone[i]=0;
            //System.out.print(grid[i]+" ");
        }
    }
    void stage2()
    {
        for(int i=0;i<grid.length;i++)
        {
            mtib[i].setBackgroundColor(Color.parseColor("#888888"));
            mtib[i].setOnClickListener(btnClick);
        }
    }

    void result()
    {
        MediaPlayer ring= MediaPlayer.create(MemoryTiles.this,R.raw.cheering);
        ring.start();
        System.out.println("win "+score);
        mttv.setText("SCORE IS "+score);
        mttv.setVisibility(View.VISIBLE);
        mtbtn.setText("PLAY AGAIN");
        mtbtn.setVisibility(View.VISIBLE);
    }

    void right(int i)
    {
        if(isDone[i]==0)
        {
            mtib[i].setBackgroundColor(Color.parseColor("#00ff00"));
            isDone[i]=1;
            corrects++;
            if(corrects==numberOfOpenTiles)result();
        }
    }
    void wrong(int i)
    {
        if(isDone[i]==0)
        {
            mtib[i].setBackgroundColor(Color.parseColor("#ff0000"));
            isDone[i]=1;
            score-=5;
        }

    }

    View.OnClickListener btnClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for(int i=0;i<grid.length;i++)
            {
                if(v.getId()==getResources().getIdentifier("mtib"+i,"id",getPackageName()))
                {
                    if (grid[i]==1)right(i);
                    else wrong(i);
                }
            }
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_tiles);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.setTitle("memory tiles");
        mttv=(TextView)findViewById(R.id.mttv1);
        mtbtn=(Button)findViewById(R.id.mtbtn1);
        mtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mttv.setVisibility(View.INVISIBLE);
                mtbtn.setVisibility(View.INVISIBLE);
                initGame();
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stage2();
                    }
                },2000);
            }
        });
        //System.out.println("hehe");
    }
}

package com.example.sacin.remembertiles;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class RememberTiles extends AppCompatActivity {
    public static ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12;
    public static Button showButton;
    public static TextView scoreView;
    public static ImageView imgBack;
    public static int[] imarray={1,1,2,2,3,3,4,4,5,5,6,6};
    public static int[] imselect={0,0,0,0,0,0,0,0,0,0,0,0};
    public static int clickNumber=0;
    public static int wrongsNumber=0;
    public static int done=0;
    public static int hide=0;
    /////////////////////functions/////////////////////
    //clear -------- clear array
    //match -------- check if images match
    public static void printstat(int[] a)
    {
        for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");
        System.out.println();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            // do something on back.
            /*
            hide=1;
            clickNumber=0;
            done=0;
            wrongsNumber=0;
            startActivity(new Intent(RememberTiles.this, GameSelector.class));
            */
            if(clickNumber!=0)playagain(0);
            else
            {
                clickNumber=0;
                wrongsNumber=0;
                done=0;
                hide=0;
                startActivity(new Intent(RememberTiles.this, GameSelector.class));
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    //////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.setTitle("remember tiles");
        //ImageView image = (ImageView) findViewById(R.id.image);
        //image_ID = getResources().getIdentifier(imageName, "drawable", getPackageName());

        //image.setBackgroundResource(image_ID);
        imgBack=(ImageView)findViewById(R.id.imgBack);
        scoreView=(TextView)findViewById(R.id.scoreView);
        ib1=(ImageButton) findViewById(R.id.ib1);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[0]==0  && hide==1)
                {
                    imselect[0]=1;
                    if(clickNumber%2==1)
                    {
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        ib1.setImageResource(getResources().getIdentifier("i"+imarray[0], "drawable", getPackageName()));
                        clickNumber++;
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[0]=1;
                        ib1.setImageResource(getResources().getIdentifier("i"+imarray[0], "drawable", getPackageName()));
                        clickNumber++;
                    }
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib2=(ImageButton) findViewById(R.id.ib2);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[1]==0  && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[1]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        ib2.setImageResource(getResources().getIdentifier("i"+imarray[1], "drawable", getPackageName()));
                        clickNumber++;
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[1]=1;
                        ib2.setImageResource(getResources().getIdentifier("i"+imarray[1], "drawable", getPackageName()));
                        clickNumber++;
                    }
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib3=(ImageButton) findViewById(R.id.ib3);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[2]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[2]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        ib3.setImageResource(getResources().getIdentifier("i"+imarray[2], "drawable", getPackageName()));
                        clickNumber++;
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[2]=1;
                        ib3.setImageResource(getResources().getIdentifier("i"+imarray[2], "drawable", getPackageName()));
                        clickNumber++;
                    }
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib4=(ImageButton) findViewById(R.id.ib4);
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[3]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[3]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        ib4.setImageResource(getResources().getIdentifier("i"+imarray[3], "drawable", getPackageName()));
                        clickNumber++;
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[3]=1;
                        ib4.setImageResource(getResources().getIdentifier("i"+imarray[3], "drawable", getPackageName()));
                        clickNumber++;
                    }
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib5=(ImageButton) findViewById(R.id.ib5);
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[4]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[4]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[4]=1;
                    }
                    clickNumber++;
                    ib5.setImageResource(getResources().getIdentifier("i"+imarray[4], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib6=(ImageButton) findViewById(R.id.ib6);
        ib6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[5]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[5]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[5]=1;
                    }
                    clickNumber++;
                    ib6.setImageResource(getResources().getIdentifier("i"+imarray[5], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib7=(ImageButton) findViewById(R.id.ib7);
        ib7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[6]==0 && hide==1)
                {
                    imselect[6]=1;
                    if(clickNumber%2==1)
                    {
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[6]=1;
                    }
                    clickNumber++;
                    ib7.setImageResource(getResources().getIdentifier("i"+imarray[6], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib8=(ImageButton) findViewById(R.id.ib8);
        ib8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[7]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[7]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[7]=1;
                    }
                    clickNumber++;
                    ib8.setImageResource(getResources().getIdentifier("i"+imarray[7], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib9=(ImageButton) findViewById(R.id.ib9);
        ib9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[8]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[8]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[8]=1;
                    }
                    clickNumber++;
                    ib9.setImageResource(getResources().getIdentifier("i"+imarray[8], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib10=(ImageButton) findViewById(R.id.ib10);
        ib10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[9]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[9]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[9]=1;
                    }
                    clickNumber++;
                    ib10.setImageResource(getResources().getIdentifier("i"+imarray[9], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib11=(ImageButton) findViewById(R.id.ib11);
        ib11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[10]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[10]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[10]=1;
                    }
                    clickNumber++;
                    ib11.setImageResource(getResources().getIdentifier("i"+imarray[10], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });
        ib12=(ImageButton) findViewById(R.id.ib12);
        ib12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imselect[11]==0 && hide==1)
                {
                    if(clickNumber%2==1)
                    {
                        imselect[11]=1;
                        if(match(imarray,imselect)){done++;printstat(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.correct);ring.start();}
                        else {wrongsNumber++;clear(imselect);MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.buzzer2);ring.start();}
                        clear(imselect);
                    }
                    else
                    {
                        clear(imselect);
                        imselect[11]=1;
                    }
                    clickNumber++;
                    ib12.setImageResource(getResources().getIdentifier("i"+imarray[11], "drawable", getPackageName()));
                }
                System.out.println(done+" "+clickNumber+" "+wrongsNumber);if(done==6)playagain(1);
            }
        });

        shuffle(imarray);

        showButton=(Button)findViewById(R.id.showButton);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreView.setVisibility(View.INVISIBLE);
                imgBack.setVisibility(View.INVISIBLE);
                int i=0;
                hide=(hide+1)%2;
                //Random r = new Random();
                //int randomNumber = r.nextInt(7 - 1) + 1;
                String imageName = "i" + imarray[i++];
                if(hide==0)imageName = "i" +0;
                ib1.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib2.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib3.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib4.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib5.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib6.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib7.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib8.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib9.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib10.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib11.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                //randomNumber = r.nextInt(7 - 1) + 1;
                if(hide==0)imageName = "i" +0;
                else imageName = "i" + imarray[i++];
                ib12.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ib1.setImageResource(R.drawable.i0);
                        ib2.setImageResource(R.drawable.i0);
                        ib3.setImageResource(R.drawable.i0);
                        ib4.setImageResource(R.drawable.i0);
                        ib5.setImageResource(R.drawable.i0);
                        ib6.setImageResource(R.drawable.i0);
                        ib7.setImageResource(R.drawable.i0);
                        ib8.setImageResource(R.drawable.i0);
                        ib9.setImageResource(R.drawable.i0);
                        ib10.setImageResource(R.drawable.i0);
                        ib11.setImageResource(R.drawable.i0);
                        ib12.setImageResource(R.drawable.i0);
                        showButton.setVisibility(View.INVISIBLE);
                    }
                }, 2000);
            }
        });
    }

    public static void shuffle(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            // between i and n-1
            int r = i + (int) (Math.random() * (n-i));
            int tmp = a[i];    // swap
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    public static void clear(int[] a)
    {
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            if(a[i]!=2)
            {
                if(i==0)ib1.setImageResource(R.drawable.i0);
                if(i==1)ib2.setImageResource(R.drawable.i0);
                if(i==2)ib3.setImageResource(R.drawable.i0);
                if(i==3)ib4.setImageResource(R.drawable.i0);
                if(i==4)ib5.setImageResource(R.drawable.i0);
                if(i==5)ib6.setImageResource(R.drawable.i0);
                if(i==6)ib7.setImageResource(R.drawable.i0);
                if(i==7)ib8.setImageResource(R.drawable.i0);
                if(i==8)ib9.setImageResource(R.drawable.i0);
                if(i==9)ib10.setImageResource(R.drawable.i0);
                if(i==10)ib11.setImageResource(R.drawable.i0);
                if(i==11)ib12.setImageResource(R.drawable.i0);
                a[i]=0;
            }
        }
    }
    public static boolean match(int[] imagearray,int[] chooser)
    {
        int i1=0;
        while(true){if(chooser[i1]==1)break;i1++;}
        int i2=imagearray.length-1;
        while(true){if(chooser[i2]==1)break;i2--;}
        if(imagearray[i1]==imagearray[i2]){chooser[i1]=2;chooser[i2]=2;return true;}
        else return false;
    }
    public void playagain(int stat)
    {
        MediaPlayer ring= MediaPlayer.create(RememberTiles.this,R.raw.cheering);
        ring.start();
        shuffle(imarray);
        for(int i=0;i<imarray.length;i++)imselect[i]=0;
        clear(imselect);
        if(stat==1)scoreView.setText("SCORE IS "+(100-(clickNumber-12)*5));
        else scoreView.setText("TRY AGAIN !!");
        scoreView.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.VISIBLE);
        showButton.setText("PLAY AGAIN");
        hide=0;
        clickNumber=0;
        done=0;
        wrongsNumber=0;
        showButton.setVisibility(View.VISIBLE);
    }
}

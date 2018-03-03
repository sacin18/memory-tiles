package com.example.sacin.remembertiles;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by sacin on 10/25/2017.
 */
public class RememberImages extends AppCompatActivity{
    ImageView iv0,ivriright;
    int allimages[]=new int[100];
    int imarray[]=new int[6];
    int imdisplayarray[]=new int[6];
    int imqueue=0,sequence=0;
    ImageButton ib[]=new ImageButton[6];
    int wrongMoves=0;
    int presentOnTheGrid=0;
    Button bri1;
    TextView tvri1;

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
    public void initIdArray()
    {
        for(int i=0;i<allimages.length;i++)
        {
            allimages[i]=i+1;//getResources().getIdentifier("i_"+(i+1), "drawable", getPackageName());
        }
        shuffle(allimages);
        for(int i=0;i<imarray.length;i++)
        {
            imarray[i]=allimages[i];
        }
    }

    public void resetGame()
    {
        initIdArray();
        imqueue=0;
        sequence=0;
        wrongMoves=0;
        presentOnTheGrid=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_images);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.setTitle("remember images");
        //initIdArray();
        bri1=(Button) findViewById(R.id.bri1);
        tvri1=(TextView)findViewById(R.id.tvri1);
        iv0=(ImageView) findViewById(R.id.iv0);
        ivriright=(ImageView) findViewById(R.id.ivriright);
        //iv0.setImageResource(imarray[0]);
        ///////////////////////////
        /*
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    iv0.setImageResource(imarray[imqueue]);
                    imqueue++;
                }
            }, 1000);
            */

        /*
        AnimationDrawable animation = new AnimationDrawable();
        for(int i=0;i<16;i++)animation.addFrame(getResources().getDrawable(imarray[i]), 1000);
        animation.setOneShot(false);

        iv0.setBackgroundDrawable(animation);

        animation.start();

        */


        /////////////////////////////////
       bri1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               resetGame();
               tvri1.setVisibility(View.INVISIBLE);
               bri1.setVisibility(View.INVISIBLE);
               CountDownTimer animation;
               animation=new CountDownTimer(1000,10) {
                   @Override
                   public void onTick(long millisUntilFinished) {
                   }

                   @Override
                   public void onFinish() {
                       iv0.setImageResource(getResources().getIdentifier("i_"+imarray[imqueue], "drawable", getPackageName()));
                       iv0.setVisibility(View.VISIBLE);
                       System.out.println(imqueue+" "+imarray[imqueue]);
                       imqueue++;
                       //System.out.println("h");
                       if(imqueue==imarray.length){}
                       else start();
                   }
               }.start();

               Handler handler=new Handler();
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       stage2();
                   }
               },imarray.length*1000+1000);
           }
       });

        /////////////////////////////

        //if(sequence==1)iv0.setVisibility(View.INVISIBLE);
    }
    public void stage2()
    {
        for(int i=0;i<imarray.length;i++)imdisplayarray[i]=imarray[i];
        shuffle(imdisplayarray);
        iv0.setVisibility(View.INVISIBLE);
        /*
        ib[0]=(ImageButton)findViewById(R.id.iib0);
        //ib[0].findViewById(R.id.iib0);
        ib[0].setVisibility(View.VISIBLE);
        ib[0].setImageResource(getResources().getIdentifier("i_"+imdisplayarray[0], "drawable", getPackageName()));
        */
        for(int i=0;i<imdisplayarray.length;i++)
        {
            ib[i]=(ImageButton)findViewById(getResources().getIdentifier("iib"+i,"id",getPackageName()));
            ib[i].setVisibility(View.VISIBLE);
            ib[i].setImageResource(getResources().getIdentifier("i_"+imdisplayarray[i], "drawable", getPackageName()));
            ib[i].setOnClickListener(imageButtonClick);
        }


    }

    /////////////////////////////////
    public void right()
    {
        MediaPlayer ring= MediaPlayer.create(RememberImages.this,R.raw.correct);ring.start();
        presentOnTheGrid++;
        ivriright.setVisibility(View.VISIBLE);
        Handler wrongorright=new Handler();
        ivriright.setBackgroundColor(Color.parseColor("#27ba57"));
        wrongorright.postDelayed(new Runnable() {
            @Override
            public void run() {
                ivriright.setVisibility(View.INVISIBLE);
            }
        }, 150);
    }
    public void wrong()
    {
        MediaPlayer ring= MediaPlayer.create(RememberImages.this,R.raw.buzzer2);ring.start();
        wrongMoves++;
        ivriright.setVisibility(View.VISIBLE);
        Handler wrongorright=new Handler();
        ivriright.setBackgroundColor(Color.parseColor("#bd2424"));
        wrongorright.postDelayed(new Runnable() {
            @Override
            public void run() {
                ivriright.setVisibility(View.INVISIBLE);
            }
        }, 150);
    }
    ////////////////////////////////

    View.OnClickListener imageButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Handler wrongorright=new Handler();
            switch(v.getId())
            {
                case R.id.iib0:
                    if(imdisplayarray[0]==imarray[presentOnTheGrid])right();
                    else wrong();
                    if(presentOnTheGrid==imdisplayarray.length)rigameover();
                    break;
                case R.id.iib1:
                    if(imdisplayarray[1]==imarray[presentOnTheGrid])right();
                    else wrong();
                    if(presentOnTheGrid==imdisplayarray.length)rigameover();
                    break;
                case R.id.iib2:
                    if(imdisplayarray[2]==imarray[presentOnTheGrid])right();
                    else wrong();
                    if(presentOnTheGrid==imdisplayarray.length)rigameover();
                    break;
                case R.id.iib3:
                    if(imdisplayarray[3]==imarray[presentOnTheGrid])right();
                    else wrong();
                    if(presentOnTheGrid==imdisplayarray.length)rigameover();
                    break;
                case R.id.iib4:
                    if(imdisplayarray[4]==imarray[presentOnTheGrid])right();
                    else wrong();
                    if(presentOnTheGrid==imdisplayarray.length)rigameover();
                    break;
                case R.id.iib5:
                    if(imdisplayarray[5]==imarray[presentOnTheGrid])right();
                    else wrong();
                    if(presentOnTheGrid==imdisplayarray.length)rigameover();
                    break;
            }
            System.out.println(presentOnTheGrid+" "+wrongMoves);
        }
    };
    public void rigameover()
    {
        MediaPlayer ring= MediaPlayer.create(RememberImages.this,R.raw.cheering);
        ring.start();
        System.out.println("game over buddy");
        for(int i=0;i<imdisplayarray.length;i++) {
            ib[i].setVisibility(View.INVISIBLE);
        }
        tvri1.setText("score is "+(100-wrongMoves*5));
        bri1.setText("play again");
        bri1.setVisibility(View.VISIBLE);
        tvri1.setVisibility(View.VISIBLE);
    }
}

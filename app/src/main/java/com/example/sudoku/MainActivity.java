package com.example.sudoku;

import static com.example.sudoku.R.color.black;
import static com.example.sudoku.R.color.gray;
import static com.example.sudoku.R.color.teal_200;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[][] s1 =new String[9][9];
    boolean end=false;
    String n="";String s;
    public void load(View view){
        TextView textView=(TextView) view;
        s=textView.getTag().toString();
        int ni=Integer.parseInt(s);
        if(!end && !s.equals("111")){
            if(!n.equals("")){
                boolean b=false;
                int q=ni/9,m=ni%9;
                if(n.equals(s1[q][m]))
                {
                    s1[q][m]="";
                    textView.setText("");
                    n="";
                }
                else{
                    int i;
                    for(i=0;i<9;i++){
                        if(n.equals(s1[i][m])){
                            b=true;break;
                        }
                    }
                    for( i=0;i<9;i++){
                        if(n.equals(s1[q][i])){
                            b=true;break;}
                    }
                    int x1,y1,x2,y2;
                    if(q<=2){
                        x1=0;y1=2;
                    }else if(q<=5){
                        x1=3;y1=5;
                    }else{
                        x1=6;y1=8;
                    }
                    if(m<=2){
                        x2=0;y2=2;
                    }else if(m<=5){
                        x2=3;y2=5;
                    }else{
                        x2=6;y2=8;
                    }
                    for(i=x1;i<=y1;i++){
                        for(int j=x2;j<=y2;j++){
                            if(n.equals(s1[i][j])){
                                b=true;break;
                            }
                        }
                        if(b)
                            break;
                    }
                    if(!b){
                        s1[q][m]=n;
                        textView.setText(n);
                        textView.setTextColor(getResources().getColor(gray));
                        n="";
                        end=true;
                        for(int ii=0;ii<9;ii++){
                            for(int jj=0;jj<9;jj++){
                                if(s1[ii][jj]==null){
                                    end=false;
                                    break;
                            }
                        }
                            if(!end)
                                break;
                        }
                        if(end)
                            Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this,"Invalid Move", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            else{
                s=textView.getTag().toString();
                int q=ni/9;
                s1[q][(ni%9)]="";
                textView.setText("");
            }
        }
    }

    public void buttonClick(View view){
        Button button=(Button) view;
        n=button.getText().toString();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1[0][0]="2";s1[0][4]="3";s1[0][5]="1";s1[0][7]="4";
        s1[1][1]="4";s1[1][8]="6";
        s1[2][4]="8";
        s1[3][3]="5";
        s1[4][2]="7";s1[4][6]="9";
        s1[5][0]="3";s1[5][4]="4";s1[5][5]="2";s1[5][7]="6";
        s1[6][0]="5";s1[6][3]="6";
        s1[7][3]="8";s1[7][7]="1";
        s1[8][2]="3";s1[8][4]="1";s1[8][5]="5";s1[8][8]="7";

        TextView[][] t =new TextView[9][9];
        t[0][0]=findViewById(R.id.textView000);
        t[0][1]=findViewById(R.id.textView001);
        t[0][2]=findViewById(R.id.textView002);
        t[0][3]=findViewById(R.id.textView100);
        t[0][4]=findViewById(R.id.textView101);
        t[0][5]=findViewById(R.id.textView102);
        t[0][6]=findViewById(R.id.textView200);
        t[0][7]=findViewById(R.id.textView201);
        t[0][8]=findViewById(R.id.textView202);
        t[1][0]=findViewById(R.id.textView010);
        t[1][1]=findViewById(R.id.textView011);
        t[1][2]=findViewById(R.id.textView012);
        t[1][3]=findViewById(R.id.textView110);
        t[1][4]=findViewById(R.id.textView111);
        t[1][5]=findViewById(R.id.textView112);
        t[1][6]=findViewById(R.id.textView210);
        t[1][7]=findViewById(R.id.textView211);
        t[1][8]=findViewById(R.id.textView212);
        t[2][0]=findViewById(R.id.textView020);
        t[2][1]=findViewById(R.id.textView021);
        t[2][2]=findViewById(R.id.textView022);
        t[2][3]=findViewById(R.id.textView120);
        t[2][4]=findViewById(R.id.textView121);
        t[2][5]=findViewById(R.id.textView122);
        t[2][6]=findViewById(R.id.textView220);
        t[2][7]=findViewById(R.id.textView221);
        t[2][8]=findViewById(R.id.textView222);
        t[3][0]=findViewById(R.id.textView300);
        t[3][1]=findViewById(R.id.textView301);
        t[3][2]=findViewById(R.id.textView302);
        t[3][3]=findViewById(R.id.textView400);
        t[3][4]=findViewById(R.id.textView401);
        t[3][5]=findViewById(R.id.textView402);
        t[3][6]=findViewById(R.id.textView500);
        t[3][7]=findViewById(R.id.textView501);
        t[3][8]=findViewById(R.id.textView502);
        t[4][0]=findViewById(R.id.textView310);
        t[4][1]=findViewById(R.id.textView311);
        t[4][2]=findViewById(R.id.textView312);
        t[4][3]=findViewById(R.id.textView410);
        t[4][4]=findViewById(R.id.textView411);
        t[4][5]=findViewById(R.id.textView412);
        t[4][6]=findViewById(R.id.textView510);
        t[4][7]=findViewById(R.id.textView511);
        t[4][8]=findViewById(R.id.textView512);
        t[5][0]=findViewById(R.id.textView320);
        t[5][1]=findViewById(R.id.textView321);
        t[5][2]=findViewById(R.id.textView322);
        t[5][3]=findViewById(R.id.textView420);
        t[5][4]=findViewById(R.id.textView421);
        t[5][5]=findViewById(R.id.textView422);
        t[5][6]=findViewById(R.id.textView520);
        t[5][7]=findViewById(R.id.textView521);
        t[5][8]=findViewById(R.id.textView522);
        t[6][0]=findViewById(R.id.textView600);
        t[6][1]=findViewById(R.id.textView601);
        t[6][2]=findViewById(R.id.textView602);
        t[6][3]=findViewById(R.id.textView700);
        t[6][4]=findViewById(R.id.textView701);
        t[6][5]=findViewById(R.id.textView702);
        t[6][6]=findViewById(R.id.textView800);
        t[6][7]=findViewById(R.id.textView801);
        t[6][8]=findViewById(R.id.textView802);
        t[7][0]=findViewById(R.id.textView610);
        t[7][1]=findViewById(R.id.textView611);
        t[7][2]=findViewById(R.id.textView612);
        t[7][3]=findViewById(R.id.textView710);
        t[7][4]=findViewById(R.id.textView711);
        t[7][5]=findViewById(R.id.textView712);
        t[7][6]=findViewById(R.id.textView810);
        t[7][7]=findViewById(R.id.textView811);
        t[7][8]=findViewById(R.id.textView812);
        t[8][0]=findViewById(R.id.textView620);
        t[8][1]=findViewById(R.id.textView621);
        t[8][2]=findViewById(R.id.textView622);
        t[8][3]=findViewById(R.id.textView720);
        t[8][4]=findViewById(R.id.textView721);
        t[8][5]=findViewById(R.id.textView722);
        t[8][6]=findViewById(R.id.textView820);
        t[8][7]=findViewById(R.id.textView821);
        t[8][8]=findViewById(R.id.textView822);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(s1[i][j]!=null){
                    t[i][j].setText(s1[i][j]);
                    t[i][j].setTextColor(getResources().getColor(black));
                    t[i][j].setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    t[i][j].setTag(111);
                }
            }
        }
    }
}
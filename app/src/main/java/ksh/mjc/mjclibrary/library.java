package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class library extends AppCompatActivity {

    ImageView lib_search;
    int code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_library);



        lib_search = findViewById(R.id.lib_search);
        Intent intent  = getIntent();
        code = intent.getIntExtra("location",1);
        int Btype, Blocation;
        Btype = code/100;
        Blocation = code%100;
        Log.d("확인",String.valueOf(Btype));
        Log.d("확인",String.valueOf(Blocation));
        switch (Btype){
            case 0:
            {
                if(Blocation >=0 && Blocation<14)
                {
                    lib_search.setImageResource(R.drawable.library1_0_14);
                }
                if(Blocation>14&&Blocation<=28) {
                    lib_search.setImageResource(R.drawable.library1_14_28);
                }
                if(Blocation>28&&Blocation<=42) {
                    lib_search.setImageResource(R.drawable.library1_28_42);
                }
                if(Blocation>42&&Blocation<=56) {
                    lib_search.setImageResource(R.drawable.library1_42_56);
                }
                if(Blocation>56&&Blocation<=70) {
                    lib_search.setImageResource(R.drawable.library1_56_70);
                }
                if(Blocation>70&&Blocation<=84) {
                    lib_search.setImageResource(R.drawable.library1_70_84);
                }
                if(Blocation>84&& Blocation <99) {
                    lib_search.setImageResource(R.drawable.library1_84_100);
                }

                break;
            }
            case 1:
            {
                if(Blocation>=0&&Blocation<=14) {
                    lib_search.setImageResource(R.drawable.library2_0_14);
                }
                if(Blocation>14&&Blocation<=28) {
                    lib_search.setImageResource(R.drawable.library2_14_28);
                }
                if(Blocation>28&&Blocation<=42) {
                    lib_search.setImageResource(R.drawable.library2_28_42);
                }
                if(Blocation>42&&Blocation<=56) {
                    lib_search.setImageResource(R.drawable.library2_42_56);
                }
                if(Blocation>56&&Blocation<=70) {
                    lib_search.setImageResource(R.drawable.library2_56_70);
                }
                if(Blocation>70&&Blocation<=84) {
                    lib_search.setImageResource(R.drawable.library2_70_84);
                }if(Blocation>84&&Blocation<99) {
                lib_search.setImageResource(R.drawable.library2_84_100);
            }

                break;
            }
            case 2:
            {
                if(code>=0 && code <50){
                lib_search.setImageResource(R.drawable.library3_0_50);
                }
                if(code>=50&&code<99){
                    lib_search.setImageResource(R.drawable.library3_50_100);
                }

                break;
            }
            case 3:
            {
                if(code>=0 && code <5){
                lib_search.setImageResource(R.drawable.library4_0_5);
            }
                if(code>=5 && code <11){
                    lib_search.setImageResource(R.drawable.library4_5_11);
                }
                if(code>=11 && code <16){
                    lib_search.setImageResource(R.drawable.library4_11_16);
                }
                if(code>=16 && code <21){
                    lib_search.setImageResource(R.drawable.library4_16_21);
                }
                if(code>=21 && code <26){
                    lib_search.setImageResource(R.drawable.library4_21_26);
                }
                if(code>=26  && code <31){
                    lib_search.setImageResource(R.drawable.library4_26_31);
                }
                if(code>=31 && code <37){
                    lib_search.setImageResource(R.drawable.library4_31_37);
                }
                if(code>=37 && code <42){
                    lib_search.setImageResource(R.drawable.library4_37_42);
                }
                if(code>=42 && code <47){
                    lib_search.setImageResource(R.drawable.library4_42_47);
                }
                if(code>=47 && code <52){
                    lib_search.setImageResource(R.drawable.library4_47_52);
                }
                if(code>=52 && code <57){
                    lib_search.setImageResource(R.drawable.library4_52_57);
                }
                if(code>=57 && code <62){
                    lib_search.setImageResource(R.drawable.library4_57_62);
                }
                if(code>=62 && code <67){
                    lib_search.setImageResource(R.drawable.library4_62_67);
                }
                if(code>=67 && code <72){
                    lib_search.setImageResource(R.drawable.library4_5_11);
                }
                if(code>=72 && code <77){
                    lib_search.setImageResource(R.drawable.library4_72_77);
                }
                if(code>=77 && code <83){
                    lib_search.setImageResource(R.drawable.library4_77_83);
                }
                if(code>=83 && code <90){
                    lib_search.setImageResource(R.drawable.library4_83_90);
                }
                if(code>=90 && code <99){
                    lib_search.setImageResource(R.drawable.library4_90_100);
                }

                break;
            }
            case 4:
            {
                if(code>=0 && code <25){
                    lib_search.setImageResource(R.drawable.library5_0_25);
                }
                if(code>=25 && code <50){
                    lib_search.setImageResource(R.drawable.library5_25_50);
                }
                if(code>=50 && code <75){
                    lib_search.setImageResource(R.drawable.library5_50_75);
                }
                if(code>=75 && code <99){
                    lib_search.setImageResource(R.drawable.library5_75_100);
                }

                break;
            }
            case 5:
            {
                if(code>=0 && code <10){
                lib_search.setImageResource(R.drawable.library6_0_10);
                }
                if(code>=10 && code <20){
                    lib_search.setImageResource(R.drawable.library6_10_20);
                }
                if(code>=20 && code <25){
                    lib_search.setImageResource(R.drawable.library6_20_25);
                }
                if(code>=25 && code <37){
                    lib_search.setImageResource(R.drawable.library6_25_37);
                }
                if(code>=37 && code <42){
                    lib_search.setImageResource(R.drawable.library6_37_42);
                }
                if(code>=42 && code <50){
                    lib_search.setImageResource(R.drawable.library6_42_50);
                }
                if(code>=50 && code <60){
                    lib_search.setImageResource(R.drawable.library6_50_60);
                }
                if(code>=60 && code <70){
                    lib_search.setImageResource(R.drawable.library6_60_70);
                }
                if(code>=70 && code <80){
                    lib_search.setImageResource(R.drawable.library6_70_80);
                }
                if(code>=80 && code <90){
                    lib_search.setImageResource(R.drawable.library6_80_90);
                }
                if(code>=90 && code <99){
                    lib_search.setImageResource(R.drawable.library6_90_100);
                }
                break;
            }
            case 6:
            {
                if(code>=0 && code <16){
                    lib_search.setImageResource(R.drawable.library7_0_16);
                }
                if(code>=16 && code <32){
                    lib_search.setImageResource(R.drawable.library7_16_32);
                }
                if(code>=32 && code <48){
                    lib_search.setImageResource(R.drawable.library7_32_48);
                }
                if(code>=48 && code <64){
                    lib_search.setImageResource(R.drawable.library7_48_64);
                }
                if(code>=64 && code <99){
                    lib_search.setImageResource(R.drawable.library7_64_80);
                }
                break;
            }
            case 7:
            {
                if(code>=0 && code <30){
                    lib_search.setImageResource(R.drawable.library8_0_30);
                }
                if(code>=30 && code <70){
                    lib_search.setImageResource(R.drawable.library8_30_70);
                }
                if(code>=70 && code <99){
                    lib_search.setImageResource(R.drawable.library8_70_100);
                }
                break;
            }
            case 8:
            {
                if(code>=0 && code <12){
                lib_search.setImageResource(R.drawable.library9_0_12);
            }
                if(code>=12 && code <25){
                    lib_search.setImageResource(R.drawable.library9_12_25);
                }
                if(code>=25 && code <37){
                    lib_search.setImageResource(R.drawable.library9_25_37);
                }
                if(code>=37 && code <50){
                    lib_search.setImageResource(R.drawable.library9_37_50);
                }
                if(code>=50 && code <62){
                lib_search.setImageResource(R.drawable.library9_50_62);
            }
                if(code>=62 && code <75){
                    lib_search.setImageResource(R.drawable.library9_62_75);
                }
                if(code>=75 && code <90){
                    lib_search.setImageResource(R.drawable.library9_75_90);
                }
                if(code>=90 && code <99){
                    lib_search.setImageResource(R.drawable.library9_90_100);
                }
                break;
            }
            case 9:
            {
                if(code>=0 && code <50){
                lib_search.setImageResource(R.drawable.library10_0_50);
            }
                if(code>=50 && code <99){
                    lib_search.setImageResource(R.drawable.library10_50_100);
                }
                break;
            }

            default:
                break;
        }




    }
}

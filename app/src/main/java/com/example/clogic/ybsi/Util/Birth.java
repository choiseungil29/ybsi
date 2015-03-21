package com.example.clogic.ybsi.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import com.example.clogic.ybsi.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CLogic on 15. 3. 22..
 */
public class Birth {

    private static SharedPreferences pref;
    private static Context c;

    public Birth(Context c) {
        pref = c.getSharedPreferences("Stella", Context.MODE_PRIVATE);
        this.c = c;
    }

    public static Drawable getDrawableAtDay(Date date) {
        DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
        Date nowDate = date;
        String tempDate = sdFormat.format(nowDate);

        String month = tempDate.substring(4, 6);
        String day = tempDate.substring(6);

        int iMonth = Integer.parseInt(month);
        int iday = Integer.parseInt(day);

        switch (iMonth) {
            case 1:
                if(iday >= 20) {
                    return c.getResources().getDrawable(R.drawable.stellaaa1);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa2);
                }
            case 2:
                if(iday >= 19) {
                    return c.getResources().getDrawable(R.drawable.stellaaa12);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa1);
                }
            case 3:
                if(iday >= 21) {
                    return c.getResources().getDrawable(R.drawable.stellaaa11);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa12);
                }
            case 4:
                if(iday >= 20) {
                    return c.getResources().getDrawable(R.drawable.stellaaa10);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa11);
                }
            case 5:
                if(iday >= 21) {
                    return c.getResources().getDrawable(R.drawable.stellaaa9);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa10);
                }
            case 6:
                if(iday >= 22) {
                    return c.getResources().getDrawable(R.drawable.stellaaa8);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa9);
                }
            case 7:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaaa7);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa8);
                }
            case 8:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaaa6);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa7);
                }
            case 9:
                if(iday >= 24) {
                    return c.getResources().getDrawable(R.drawable.stellaaa5);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa6);
                }
            case 10:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaaa4);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa5);
                }
            case 11:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaaa3);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa4);
                }
            case 12:
                if(iday >= 25) {
                    return c.getResources().getDrawable(R.drawable.stellaaa2);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaaa3);
                }
            default:
                break;
        }
        return null;
    }

    public static Drawable getDrawableAtDay() {
        String birth = pref.getString("birth","");

        String month = birth.substring(2, 4);
        String day = birth.substring(4);

        int iMonth = Integer.parseInt(month);
        int iday = Integer.parseInt(day);

        switch (iMonth) {
            case 1:
                if(iday >= 20) {
                    return c.getResources().getDrawable(R.drawable.stellaa1);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa2);
                }
            case 2:
                if(iday >= 19) {
                    return c.getResources().getDrawable(R.drawable.stellaa12);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa1);
                }
            case 3:
                if(iday >= 21) {
                    return c.getResources().getDrawable(R.drawable.stellaa11);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa12);
                }
            case 4:
                if(iday >= 20) {
                    return c.getResources().getDrawable(R.drawable.stellaa10);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa11);
                }
            case 5:
                if(iday >= 21) {
                    return c.getResources().getDrawable(R.drawable.stellaa9);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa10);
                }
            case 6:
                if(iday >= 22) {
                    return c.getResources().getDrawable(R.drawable.stellaa8);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa9);
                }
            case 7:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaa7);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa8);
                }
            case 8:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaa6);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa7);
                }
            case 9:
                if(iday >= 24) {
                    return c.getResources().getDrawable(R.drawable.stellaa5);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa6);
                }
            case 10:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaa4);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa5);
                }
            case 11:
                if(iday >= 23) {
                    return c.getResources().getDrawable(R.drawable.stellaa3);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa4);
                }
            case 12:
                if(iday >= 25) {
                    return c.getResources().getDrawable(R.drawable.stellaa2);
                } else {
                    return c.getResources().getDrawable(R.drawable.stellaa3);
                }
            default:
                break;
        }
        return null;
    }
}

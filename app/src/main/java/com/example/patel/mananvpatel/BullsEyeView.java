package com.example.patel.mananvpatel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by patel on 5/2/17.
 * used the bullseye example from the book to create this drawing
 */

public class BullsEyeView extends View{

    private Paint paint;
    private int r;
    private int g;
    private int b;

    public BullsEyeView(Context context){
        super(context);
        //blue, green and red values for the bulls eye
        r = 113;
        g = 198;
        b = 113;

        //initialize a new paint object
        paint = new Paint();
    }

    public void onDraw(Canvas canvas){
        //get the center x and y coordinates
        float centerX = canvas.getWidth()/2;
        float centerY = canvas.getHeight()/2;

        //get the radius value
        float radius = canvas.getHeight()/2;

        //draw the background of canvas with the RGB value provided below
        canvas.drawRGB(255, 69, 20);

        //draw assign the rgb values to the ring variables.
        int redRing = r;
        int greenRing = g;
        int blueRing = b;

        for(int i = 1; i <=12; i++){

            //set style and color for the paint object
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.rgb(redRing, greenRing, blueRing));
            //draw the circle in each radius starting from the center.
            canvas.drawCircle(centerX, centerY, radius, paint);

            //decrement the dimensions for the ring and the radius to re draw another circle.
            redRing -= 14;
            greenRing -= 14;
            blueRing -= 14;
            radius -= 120;
        }
    }
}

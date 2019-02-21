package com.example.sensorgraphing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class PlotView extends View {

    ArrayList<Float> nums = new ArrayList<>(10);

    public PlotView(Context context) {
        super(context);
    }

    public PlotView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PlotView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.v("MY_TAG", "onDraw is being called");
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.FILL);
        Float obj = Collections.max(nums);
        for(int i = 0; i < nums.size(); i++) {
            canvas.drawCircle(i * (this.getWidth()/10), this.getHeight() - nums.get(i) * (this.getHeight()/findMax(nums)), 10, p);
        }
    }

    public void clearList() {
        nums.clear();
    }

    public void addPoint(float x) {
        Log.v("MY_TAG", "addPoint is being called");
        nums.add(x);
        if(nums.size() > 10) {
            nums.remove(0);
        }
    }

    public float findMax(ArrayList<Float> aL) {
        float currentMax = aL.get(0);
        for(int i = 0; i < aL.size(); i++) {
            if (aL.get(i) > currentMax) {
                currentMax = aL.get(i);
            }
        }
        return currentMax;
    }
}

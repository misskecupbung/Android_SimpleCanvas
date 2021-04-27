package com.ananda.simplecanvas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(40);
    }

    @SuppressLint("ResourceAsColor")
    public void drawSomething(View view) {
        // Background
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.LTGRAY);

        // Wall
        mPaint.setColor(ContextCompat.getColor(this,R.color.blue_1));
        Rect mRect=new Rect();
        mRect.set(350,850, 850, 1350);
        mCanvas.drawRect(mRect,mPaint);

        // Roof
        mPaint.setColor(ContextCompat.getColor(this, R.color.black_1));
        Path path = new Path();
        path.moveTo(600, 550);
        path.lineTo(300, 850);
        path.lineTo(900, 850);
        path.close();
        mCanvas.drawPath(path, mPaint);

        // Door
        mPaint.setColor(ContextCompat.getColor(this,R.color.white_1));
        mRect.set(550,1050, 650, 1350);
        mCanvas.drawRect(mRect,mPaint);

        // Door handle
        mPaint.setColor(ContextCompat.getColor(this, R.color.black_1));
        mCanvas.drawCircle(580, 1200, 20, mPaint);

        // Window
        mPaint.setColor(ContextCompat.getColor(this,R.color.white));
        mRect.set(700,1050, 800, 1150);
        mCanvas.drawRect(mRect,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mCanvas.drawLine(750, 1050, 750, 1150, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mCanvas.drawLine(700, 1100, 800, 1100, mPaint);

        // Username
        mCanvas.drawText("Ananda", 520, 950, mPaintText);
        view.invalidate();

    }
}


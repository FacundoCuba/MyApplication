package com.example.facu.myapplication;

//Created by facu on 26/11/17.

        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.util.AttributeSet;
        import android.view.View;


public class CanvasView extends View {

    private Bitmap mBitmap;
    private Canvas mCanvas;
    Context context;
    private Paint paint;

    public CanvasView(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;

        // and we set a new Paint with the desired attributes
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(4f);
    }
    // override onSizeChanged
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            canvas.drawLine(coor.getOldLat(), coor.getOldLong(), coor.getLat(), coor.getLong(), paint);
        }
        catch (NullPointerException e) {
            System.out.print("NullPointerException caught");
        }

    }
}

/* void draw(float x, float y){
        // Declare an object of type Bitmap
        Bitmap blankBitmap;
        // Make it 600 x 600 pixels in size and an appropriate format
        blankBitmap = Bitmap.createBitmap(600,600,Bitmap.Config.ARGB_8888);
        // Declare an object of type canvas
        Canvas canvas;
        // Initialize it by making its surface our previously created blank bitmap
        canvas = new Canvas(blankBitmap);
        // Initialize our previously declared member object of type ImageView
        ourView = new ImageView(this);
        // Put our blank bitmap on ourView
        ourView.setImageBitmap(blankBitmap);
        // We now have a surface ready to draw on
        // But we need something to draw with
        // Declare an object of type Paint
        Paint paint;
        // Initialize it ready for painting our canvas
        paint = new Paint();
        // Make the canvas white
        canvas.drawColor(Color.argb(255, 255, 255, 255));
        // Make the brush blue
        paint.setColor(Color.argb(255,  26, 128, 182));
        // Draw a pixel
        canvas.drawPoint(x, y,paint);
        // Draw a line
        canvas.drawLine(0, 0, x, y,paint);
        // Change the brush color
        //paint.setColor(Color.argb(255,  249, 129, 0));
    }*/
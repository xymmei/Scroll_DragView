package com.example.a16047.scroll_dragview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 16047 on 2018/3/8.
 */

public class ScrollDragView extends View {
    private int lastX;
    private int lastY;

    public ScrollDragView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
    }

    public ScrollDragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollDragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

//        Paint paint=new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.YELLOW);
//        canvas.drawRect(0,0,100,100,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX=x-lastX;
                int offsetY=y-lastY;
                /*
                1.layout方法
                 */
                /*
                layout(getLeft()+offsetX,getTop()+offsetY,
                        getRight()+offsetX,getBottom()+offsetY);
                        */
                /*
                2.offsetLeftAndRight()和offsetTopAndBottom()
                 */
                /*
                offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);
                */
                /*
                3.LayoutParams
                 */
                /*
                ViewGroup.MarginLayoutParams layoutParams=
                        (ViewGroup.MarginLayoutParams)getLayoutParams();
                layoutParams.leftMargin=getLeft()+offsetX;
                layoutParams.topMargin=getTop()+offsetY;
                setLayoutParams(layoutParams);
                break;
                */
                /*
                4.scrollTo 与 scrollBy
                 */
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
        }
        return true;
    }
}

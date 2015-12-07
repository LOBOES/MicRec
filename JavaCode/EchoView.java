package com.example.nativeaudio;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class EchoView extends View {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;

    public EchoView(Context context) {
        super(context);
        init(null, 0);
    }

    public EchoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public EchoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.EchoView, defStyle, 0);

        mExampleString = a.getString(
                R.styleable.EchoView_exampleString);
        mExampleColor = a.getColor(
                R.styleable.EchoView_exampleColor,
                mExampleColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mExampleDimension = a.getDimension(
                R.styleable.EchoView_exampleDimension,
                mExampleDimension);

        if (a.hasValue(R.styleable.EchoView_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.EchoView_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }

        a.recycle();

        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);
    }

    public int iEcho = 50;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(NativeAudio.screen_width);
        // Draw the text.
        canvas.drawLine(NativeAudio.screen_width / 2, NativeAudio.screen_height, NativeAudio.screen_width / 2, NativeAudio.screen_height - (float)iEcho / (float)(65536/40) * NativeAudio.screen_height, paint);
    }

}

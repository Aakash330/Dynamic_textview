package com.codingsick.dynamictextview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PicassoImageGetter implements Html.ImageGetter {

    private final TextView textView;
    private final Context context;
    private int width, height, increaseWidth, increaseHeight = 1;
    private final String TAG = "ho";

    public PicassoImageGetter(TextView mTextView, Context mainActivity3) {

        textView = mTextView;
        context = mainActivity3;

    }

    @Override
    public Drawable getDrawable(String s) {
        Log.w(TAG, "getDrawable");

        BitmapDrawablePlaceHolder drawable = new BitmapDrawablePlaceHolder();

        Picasso.get().load(Uri.parse(s)).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                width = bitmap.getWidth();
                height = bitmap.getHeight();
                // imageView.setImageBitmap(bitmap);
                Log.d("Vishal","Bitmap Dimensions: "+ width + "x" + height);

                double percentageWidth = (width / 100.0f) * 300;
                double percentageHeight = (height / 100.0f) * 300;

                increaseWidth = (int) (width+percentageWidth);
                increaseHeight = (int) (height+percentageHeight);

                Log.d("Vishal", "percentage value of width*height = "+percentageWidth+"*"+percentageHeight);
                Log.d("Vishal", "increased width* height = "+increaseWidth+"*"+increaseHeight);

                if (increaseWidth >= 1096) {
                    Picasso.get()
                            .load(s)
                            .resize(616, increaseHeight)
                            .into((Target) drawable);
                } else {
                    Picasso.get()
                            .load(s)
                            .resize(increaseWidth, increaseHeight)
                            .into((Target) drawable);
                }

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }


            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        });




//        if (height < 30) {
//
//            Picasso.get()
//                    .load(s)
//                    .resize(increaseWidth, increaseHeight)
//                    .into((Target) drawable);
//        } else {
//
//
//            Picasso.get()
//                    .load(s)
//                    .into((Target) drawable);
//        }


        return drawable;
    }

    private class BitmapDrawablePlaceHolder extends BitmapDrawable implements Target {

        protected Drawable drawable;

        @Override
        public void draw(final Canvas canvas) {

            if (drawable != null) {
                drawable.draw(canvas);
            }
            Log.w(TAG, "fun_draw");

        }

        public void setDrawable(Drawable drawable) {
            Log.w(TAG, "fun_setDrawable");

            this.drawable = drawable;

            width = drawable.getIntrinsicWidth();
            height = drawable.getIntrinsicHeight();


            drawable.setBounds(0, 0, width, height);
            setBounds(0, 0, width, height);
            if (textView != null) {
                textView.setText(textView.getText());

            }
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

            setDrawable(new BitmapDrawable(context.getResources(), bitmap));
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {

        }


        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }

    }

}
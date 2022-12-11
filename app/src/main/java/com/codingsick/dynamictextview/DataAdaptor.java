package com.codingsick.dynamictextview;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.MyholderClass> {
    private static final String TAG ="DataAdaptor" ;
    ArrayList<DataResponse.Data> arrayList;
    MainActivity context;
    PicassoImageGetter imageGetter,imageGetter2,imageGetter3,imageGetter4,imageGetter5;


    public DataAdaptor(MainActivity context,ArrayList<DataResponse.Data> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyholderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyholderClass( LayoutInflater.from(parent.getContext()).inflate(R.layout.data_adptor,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyholderClass holder, int position) {
        imageGetter5=new PicassoImageGetter(holder.txQuestion, context,holder.linearLayoutCompat4);
        imageGetter=new PicassoImageGetter(holder.textView,context,holder.linearLayoutCompat1);
        imageGetter2=new PicassoImageGetter(holder.textView2, context,holder.linearLayoutCompat2);
        imageGetter3=new PicassoImageGetter(holder.textView3, context,holder.linearLayoutCompat3);
        imageGetter4=new PicassoImageGetter(holder.textView4, context,holder.linearLayoutCompat4);

                   String opt = arrayList.get(position).getOpt1();
                   String opt2 = arrayList.get(position).getOpt2();
                   String opt3 =arrayList.get(position).getOpt3();
                   String opt4 = arrayList.get(position).getOpt4();
                   String question = arrayList.get(position).getQuestion();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

           /* Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(ConstentClass.data, Html.FROM_HTML_MODE_LEGACY,imageGetter, null));
            Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(ConstentClass.data, Html.FROM_HTML_MODE_LEGACY,imageGetter2, null));
            Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter3, null));
            Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter4, null));*/
           // Log.w(TAG," opt1 if: DataAdaptor"+);
            holder.textView.setText( Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter, null));
            holder.textView2.setText( Html.fromHtml(opt2, Html.FROM_HTML_MODE_LEGACY,imageGetter2, null));
            holder.textView3.setText( Html.fromHtml(opt3, Html.FROM_HTML_MODE_LEGACY,imageGetter3, null));
            holder.textView4.setText( Html.fromHtml(opt4, Html.FROM_HTML_MODE_LEGACY,imageGetter4, null));
            holder.txQuestion.setText( Html.fromHtml(question, Html.FROM_HTML_MODE_LEGACY,imageGetter5, null));

         /*   holder.textView.post(new Runnable() {
                @Override
                public void run() {
                    TextPaint textPaint = new TextPaint();
                    textPaint.setTextSize(holder.textView.getTextSize());
                    float width = textPaint.measureText(holder.textView.getText().toString());
                    ViewGroup.LayoutParams layoutParams = holder.textView.getLayoutParams();
                    layoutParams.height = (int)width;
                    holder.textView.setLayoutParams(layoutParams);
                }
            });*/
        /*    holder.textView2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TextPaint textPaint = new TextPaint();
                    textPaint.setTextSize(holder.textView.getTextSize());
                    float width = textPaint.measureText(holder.textView2.getText().toString());
                    ViewGroup.LayoutParams layoutParams = holder.textView2.getLayoutParams();
                    layoutParams.height = (int)width;
                    holder.textView2.setLayoutParams(layoutParams);

                }
            },5000);*/

        } else {
            //option
            Log.w(TAG," opt1 else: DataAdaptor"+Html.fromHtml(opt,imageGetter , null));
            Log.w(TAG," opt1 else: DataAdaptor"+Html.fromHtml(opt,imageGetter2 , null));
            Log.w(TAG," opt1 else: DataAdaptor"+Html.fromHtml(opt,imageGetter3 , null));
            Log.w(TAG," opt1 else: DataAdaptor"+Html.fromHtml(opt,imageGetter4 , null));

            holder.textView.setText(Html.fromHtml(opt,imageGetter , null));
            holder.textView2.setText(Html.fromHtml(opt2,imageGetter2 , null));
            holder.textView3.setText(Html.fromHtml(opt3,imageGetter3 , null));
            holder.textView3.setText(Html.fromHtml(opt4,imageGetter4 , null));
            holder.itemView.invalidate();

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyholderClass extends RecyclerView.ViewHolder {
        TextView textView,textView2,textView3,textView4,txQuestion;
        LinearLayoutCompat linearLayoutCompat1;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        LinearLayoutCompat linearLayoutCompat4;
        public MyholderClass(@NonNull View itemView) {
            super(itemView);
             textView=itemView.findViewById(R.id.tvOptionChoice);
             textView2=itemView.findViewById(R.id.tvOptionChoice2);
             textView3=itemView.findViewById(R.id.tvOptionChoice3);
             textView4=itemView.findViewById(R.id.tvOptionChoice4);
            txQuestion =itemView.findViewById(R.id.question);
            linearLayoutCompat1=itemView.findViewById(R.id.llOption);
            linearLayoutCompat2=itemView.findViewById(R.id.llOption2);
            linearLayoutCompat3=itemView.findViewById(R.id.llOption3);
            linearLayoutCompat4=itemView.findViewById(R.id.llOption4);
        }
    }
}

package com.codingsick.dynamictextview;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.MyholderClass> {
    private static final String TAG ="DataAdaptor" ;
    ArrayList<DataResponse.Data> arrayList;
    Context context;
    PicassoImageGetter imageGetter,imageGetter2,imageGetter3,imageGetter4;

    public DataAdaptor(Context context,ArrayList<DataResponse.Data> arrayList) {
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
               imageGetter=new PicassoImageGetter(holder.textView,context);
               imageGetter2=new PicassoImageGetter(holder.textView2, context);
               imageGetter3=new PicassoImageGetter(holder.textView3, context);
               imageGetter4=new PicassoImageGetter(holder.textView4, context);

        String opt = arrayList.get(position).getOpt1();
        String opt2 = arrayList.get(position).getOpt2();
        String opt3 =arrayList.get(position).getOpt3();
        String opt4 = arrayList.get(position).getOpt4();


        Log.w(TAG," opt1: DataAdaptor"+opt);
        Log.w(TAG," opt2: DataAdaptor"+opt2);
        Log.w(TAG," opt3: DataAdaptor"+opt3);
        Log.w(TAG," opt4: DataAdaptor"+opt4);

        Log.w(TAG," imageGetter: DataAdaptor"+imageGetter);
        Log.w(TAG," imageGetter2: DataAdaptor"+imageGetter2);
        Log.w(TAG," imageGetter3: DataAdaptor"+imageGetter3);
        Log.w(TAG," imageGetter4: DataAdaptor"+imageGetter4);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter, null));
            Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter2, null));
            Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter3, null));
            Log.w(TAG," opt1 if: DataAdaptor"+Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter4, null));


            holder.textView.setText( Html.fromHtml(opt, Html.FROM_HTML_MODE_LEGACY,imageGetter, null));
            holder.textView2.setText( Html.fromHtml(opt2, Html.FROM_HTML_MODE_LEGACY,imageGetter2, null));
            holder.textView3.setText( Html.fromHtml(opt3, Html.FROM_HTML_MODE_LEGACY,imageGetter3, null));
            holder.textView4.setText( Html.fromHtml(opt4, Html.FROM_HTML_MODE_LEGACY,imageGetter4, null));




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

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyholderClass extends RecyclerView.ViewHolder {
        TextView textView,textView2,textView3,textView4;
        public MyholderClass(@NonNull View itemView) {
            super(itemView);

          textView=itemView.findViewById(R.id.tvOptionChoice);
          textView2=itemView.findViewById(R.id.tvOptionChoice2);
          textView3=itemView.findViewById(R.id.tvOptionChoice3);
          textView4=itemView.findViewById(R.id.tvOptionChoice4);
        }
    }
}

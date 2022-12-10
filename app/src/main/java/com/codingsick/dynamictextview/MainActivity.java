package com.codingsick.dynamictextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    private ArrayList<DataResponse.Data> arrayList;
    private DataResponse.Data response;
    private RecyclerView Rv;
    private TextView Tv;
    private DataAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w(TAG,"onCreate MainActivity");

        Rv=findViewById(R.id.Rv);
        Tv=findViewById(R.id.textView);
        arrayList=new ArrayList<>();
        response=new DataResponse.Data();

        JSONObject object = null;
        try {
            String jsonFileContent = readFile("mydata.json");
            object = new JSONObject(jsonFileContent);
            JSONObject jsonObj=object.getJSONObject("data");

                String opt = jsonObj.getString("opt1");
                String opt2 = jsonObj.getString("opt2");
                String opt3 = jsonObj.getString("opt3");
                String opt4 = jsonObj.getString("opt4");
                String question = jsonObj.getString("question");

                Log.w(TAG," opt1: MainActivity"+opt);
                Log.w(TAG," opt2: MainActivity"+opt2);
                Log.w(TAG," opt3: MainActivity"+opt3);
                Log.w(TAG," opt4: MainActivity"+opt4);

                response.setOpt1(opt);
                response.setOpt2(opt2);
                response.setOpt3(opt3);
                response.setOpt4(opt4);
                response.setQuestion(question);
                arrayList.add(response);
           DataResponse.Data response=new DataResponse.Data();
            response.setOpt1("Akk ajsk kjnas kash hello");
            response.setOpt2(opt2);
            response.setOpt3("hsdfhsdg  sdjhfbhsd ans");
            response.setOpt4(opt4);
            response.setQuestion("Question number 2 ");
            arrayList.add(response);

                Log.w(TAG," arrayList: MainActivity"+arrayList);
                adaptor=new DataAdaptor(MainActivity.this,arrayList);
                Rv.setLayoutManager(new LinearLayoutManager(this));
                Rv.setAdapter(adaptor);
                Log.w(TAG," arrayList: MainActivity"+arrayList);


        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
    public String readFile(String fileName) throws IOException
    {
        Log.w(TAG,"readFile MainActivity");

        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName), "UTF-8"));

        String content = "";
        String line;
        while ((line = reader.readLine()) != null)
        {
            content = content + line;
        }
        Log.w(TAG,"content MainActivity"+content);
        Tv.setText(content);
        return content;

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
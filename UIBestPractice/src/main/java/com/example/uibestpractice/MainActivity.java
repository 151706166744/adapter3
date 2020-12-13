package com.example.uibestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Msg>MsgList =new ArrayList<>();
    EditText inputText;
    Button send;
    MsgAdapter adapter;
    LinearLayoutManager layoutManager;
    RecyclerView msyRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msyRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        msyRecyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(MsgList);
        msyRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (! "".equals(content)) {
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    MsgList.add(msg);
                    adapter.notifyItemInserted(MsgList.size()-1);
                    msyRecyclerView.scrollToPosition(MsgList.size()-1);
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello guy", Msg.TYPE_RECEIVED);
        MsgList.add(msg1);
        Msg msg2 = new Msg("Hello eho is that", Msg.TYPE_SENT);
        MsgList.add(msg2);
        Msg msg3 = new Msg("This is Tom,nice talking to you", Msg.TYPE_RECEIVED);
        MsgList.add(msg3);

    }
}
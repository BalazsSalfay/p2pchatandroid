package com.example.p2pchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.p2pchat.adapters.MessageAdapter;
import com.example.p2pchat.httpconnection.ApiService;
import com.example.p2pchat.models.Client;
import com.example.p2pchat.models.Message;
import com.example.p2pchat.models.MessageResponse;
import com.example.p2pchat.models.StatusResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private MessageAdapter adapter;
    private ListView listView;
    private Button sendButton;
    private EditText newMessage;
    private Retrofit retrofit;
    private ApiService service;
    private StatusResponse statusResp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter= new MessageAdapter(this);
        adapter.add(new Message("Balazs","Hello chat app!"));
        listView = findViewById(R.id.listvw);
        listView.setAdapter(adapter);
        newMessage = findViewById(R.id.editText);
        sendButton = findViewById(R.id.button);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://fkenessey-p2p.herokuapp.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusResp = new StatusResponse(new Message("Balazs", newMessage.getText().toString()), new Client());
                Call<StatusResponse> createCall = service.postMessage(statusResp);
                createCall.enqueue(new Callback<StatusResponse>() {
                    @Override
                    public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                       statusResp = response.body();
                       adapter.add(statusResp.getMessage());
                       newMessage.setText("");
                    }

                    @Override
                    public void onFailure(Call<StatusResponse> call, Throwable t) {
                    }
                });
            }
        });

        service.getMessages().enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                adapter.clear();
                adapter.addAll(response.body().getMessages());
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
            }
        });
    }
}

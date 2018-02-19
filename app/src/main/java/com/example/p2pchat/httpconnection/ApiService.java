package com.example.p2pchat.httpconnection;

import com.example.p2pchat.models.MessageResponse;
import com.example.p2pchat.models.StatusResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("/api/message/receive")
    Call<MessageResponse> getMessages();

    @POST("/api/message/receive")
    Call<StatusResponse> postMessage(@Body StatusResponse statusResponse);
}

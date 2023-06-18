package com.example.mylibrary;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyJokes {
    //put you ip address here from personal computer
    private static final String API_URL = "http:/192.168.1.231:8080";
    private OkHttpClient client;
    private Gson gson;

    public MyJokes() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    public void getRandomJoke(final JokeCallback callback) {
        String endpoint = API_URL + "/jokes/random";
        Request request = new Request.Builder()
                .url(endpoint)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    callback.onSuccess(json);
                } else {
                    callback.onError("Failed to fetch joke");
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.toString());
            }
        });
    }
    public void getRandomFoodJoke(final JokeCallback callback) {
        String endpoint = API_URL + "/jokes/food/random";
        Request request = new Request.Builder()
                .url(endpoint)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    callback.onSuccess(json);
                } else {
                    callback.onError("Failed to fetch joke");
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.toString());
            }
        });
    }public void getRandomProgrammingJoke(final JokeCallback callback) {
        String endpoint = API_URL + "/jokes/programming/random";
        Request request = new Request.Builder()
                .url(endpoint)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    callback.onSuccess(json);
                } else {
                    callback.onError("Failed to fetch joke");
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.toString());
            }
        });
    }
    public void getRandomChickenJoke(final JokeCallback callback) {
        String endpoint = API_URL + "/jokes/chicken/random";
        Request request = new Request.Builder()
                .url(endpoint)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    callback.onSuccess(json);
                } else {
                    callback.onError("Failed to fetch joke");
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.toString());
            }
        });
    }
    public interface JokeCallback {
        void onSuccess(String jokeJson);

        void onError(String errorMessage);
    }
}

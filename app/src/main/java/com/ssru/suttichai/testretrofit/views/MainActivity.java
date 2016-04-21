package com.ssru.suttichai.testretrofit.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ssru.suttichai.testretrofit.R;
import com.ssru.suttichai.testretrofit.model.Model;
import com.ssru.suttichai.testretrofit.presenter.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt_city = (TextView) findViewById(R.id.txt_city);
        final TextView txt_status = (TextView) findViewById(R.id.txt_status);
        final TextView txt_humidity = (TextView) findViewById(R.id.txt_humidity);
        final TextView txt_pressure = (TextView) findViewById(R.id.txt_press);


        String url = "http://api.openweathermap.org/";

        //Creating Rest Services
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApi service = retrofit.create(RestApi.class);


        Call<Model> call = service.getWheatherReport();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                try {

                    String city = response.body().getName();

                    String status = response.body().getWeather().get(0).getDescription();

                    String humidity = response.body().getMain().getHumidity().toString();

                    String pressure = response.body().getMain().getPressure().toString();

                    txt_city.setText("city  :  " + city);
                    txt_status.setText("status  :  " + status);
                    txt_humidity.setText("humidity  : " + humidity);
                    txt_pressure.setText("pressure  :  " + pressure);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }

        });

    }
}

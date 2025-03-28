package com.demo.jokeme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.jokeme.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), Callback<Joke> {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { getJoke() }
    }

    private fun getJoke() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(JokeAPI::class.java).getJoke().enqueue(this)
    }

    override fun onFailure(call: Call<Joke>, t: Throwable) {
        binding.textView.text = getString(R.string.joke_lost)
    }

    override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
        if (response.isSuccessful) {
            binding.textView.text = response.body()?.joke
        } else {
            binding.textView.text = getString(R.string.joke_lost)
        }
    }

    private companion object {
        const val BASE_URL = "https://icanhazdadjoke.com"
    }
}

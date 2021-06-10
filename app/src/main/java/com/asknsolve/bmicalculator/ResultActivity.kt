package com.asknsolve.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asknsolve.bmicalculator.databinding.ActivityResultBinding

private lateinit var binding: ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //전달받은 키와 몸무게
        val height = intent.getStringExtra("height")!!.toInt()
        val weight = intent.getStringExtra("weight")!!.toInt()

        //BMI 계산
        val bmi = weight / Math.pow(height / 100.0, 2.0)

        //결과 표시
        when{
            bmi >= 35 -> binding.resultTextView.text = "고도 비만"
            bmi >= 30 -> binding.resultTextView.text = "2단계 비만"
            bmi >= 25 -> binding.resultTextView.text = "1단계 비만"
            bmi >= 23 -> binding.resultTextView.text = "과체중"
            bmi >= 18.5 -> binding.resultTextView.text = "정상"
            else -> binding.resultTextView.text = "저체중"
        }

        //이미지 표시
        when{
            bmi >= 23 ->
                binding.imageView2.setImageResource(
                    R.drawable.ic_baseline_sentiment_very_dissatisfied_24
                )

            bmi >= 18.5 ->
                binding.imageView2.setImageResource(
                    R.drawable.ic_baseline_sentiment_satisfied_alt_24
                )

            else ->
                binding.imageView2.setImageResource(
                    R.drawable.ic_baseline_sentiment_dissatisfied_24
                )
        }
    }
}
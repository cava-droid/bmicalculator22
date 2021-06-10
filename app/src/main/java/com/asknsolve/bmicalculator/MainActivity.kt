package com.asknsolve.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.asknsolve.bmicalculator.databinding.ActivityMainBinding
import org.jetbrains.anko.startActivity

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultButton.setOnClickListener {
        /*    val intent = Intent(this,ResultActivity::class.java)
        //    Toast.makeText(applicationContext,"버튼이 눌렸어요.",Toast.LENGTH_LONG).show()
            startActivity(intent)*/

            //Anko 라이브러리 사용
            startActivity<ResultActivity>(
                "weight" to binding.weightEditText.text.toString(),
                "height" to binding.heightEditText.text.toString()
            )

/*          intent.putExtra("weight",binding.weightEditText.text.toString())
            intent.putExtra("height",binding.heightEditText.text.toString())
            startActivity(intent)*/
        }
    }
}
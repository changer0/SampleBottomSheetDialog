package com.example.samplebottomsheetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_click.setOnClickListener {
            val bottomSheetDialog = SampleBottomSheetDialog()
            bottomSheetDialog.show(supportFragmentManager)
        }
    }
}

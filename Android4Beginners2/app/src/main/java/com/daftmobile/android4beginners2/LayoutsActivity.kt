package com.daftmobile.android4beginners2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_layouts.*

class LayoutsActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)
        // uzyskujemy referencję do widoku za pomocą metody...
        val button = findViewById<Button>(R.id.myButton)
        // lub kotlinowych extensions
        myButton.setOnClickListener { myTextView.text = (it as Button).text }  // listener jako lambda
        myButton.setOnClickListener(this::handleButtonClick)  // listener jako referencja do metody
        myButton.setOnClickListener(this)  // implementacja listenera w Activity
        // wszystkie powyższe są jednoznaczne
    }

    // handler przypięty w XMLu w android:onClick"
    fun handleButtonClick(view: View) {
        myTextView.text = (view as Button).text
    }

    override fun onClick(v: View) {
        handleButtonClick(v)
    }
}

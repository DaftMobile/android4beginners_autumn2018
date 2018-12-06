package com.daftmobile.android4beginners5.vending

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.daftmobile.android4beginners5.R
import kotlinx.android.synthetic.main.activity_vending.*

class VendingActivity : AppCompatActivity() {

    private val viewModel: VendingViewModel by lazy { ViewModelProviders.of(this).get(VendingViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vending)
        setupClickListeners()
        observeData()
    }

    private fun observeData() {
        // TODO Implement
    }

    private fun setupClickListeners() {
        depositButton.setOnClickListener {
            viewModel.depositCoin()
        }
        vendButton.setOnClickListener {
            viewModel.vend(barNameInput.text.toString())
        }
    }

    private fun showVendingErrorDialog(error: String?) {
        AlertDialog.Builder(this)
                .setTitle(R.string.nope)
                .setMessage(error)
                .setPositiveButton(android.R.string.ok, null)
                .show()
    }

    private fun showVendedDialog(chocoBar: String?) {
        AlertDialog.Builder(this)
                .setTitle(R.string.yay)
                .setMessage(chocoBar)
                .setPositiveButton(android.R.string.ok, null)
                .show()
    }

    private fun updateDeposit(deposit: String?) {
        depositView.text = deposit
    }
}

package com.daftmobile.android4beginners5.vending

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners5.SingleLiveEvent

class VendingViewModel: ViewModel() {
    private val vendingMachine = ChocoBarVendingMachine()
    private val chocoBarLiveData = SingleLiveEvent<String>()
    private val depositLiveData = SingleLiveEvent<String>()
    private val errorLiveData = MutableLiveData<String>()

    fun deposit(): LiveData<String> = depositLiveData
    fun chocoBarVended(): LiveData<String> = chocoBarLiveData
    fun vendingError(): LiveData<String> = errorLiveData

    init {
        refreshDeposit()
    }

    fun depositCoin() {
        vendingMachine.depositCoin()
        refreshDeposit()
    }

    fun vend(barName: String) {
        try {
            val bar = vendingMachine.vend(barName)
            chocoBarLiveData.value = "You vended ${bar.name}"
            refreshDeposit()
        } catch (e: Exception) {
            errorLiveData.value = e.message
        } catch (e: InsufficientFundsException) {
            errorLiveData.value = "Nie masz kasy"
        } catch (e: OutOfStockException) {
            errorLiveData.value = "Skończył się ${e.barName}"
        } catch (e: ItemNotFoundException) {
            errorLiveData.value = "Nie znam ${e.itemName}"
        }
    }

    private fun refreshDeposit() {
        depositLiveData.value = "Coins: ${vendingMachine.getCurrentDeposit()}"
    }
}

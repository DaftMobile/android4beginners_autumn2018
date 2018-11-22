package com.daftmobile.a4bhomework3

import android.content.Context
import android.net.Uri
import android.provider.ContactsContract

interface EmailRetriever {
    fun retrieve(uri: Uri): String?

    class Impl(private val context: Context): EmailRetriever {
        override fun retrieve(uri: Uri): String? {
            val projection = arrayOf(ContactsContract.CommonDataKinds.Email.ADDRESS)
            val cursor = context.contentResolver.query(uri, projection, null, null, null)
            return if (cursor != null && cursor.moveToFirst()) {
                val columnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val address = cursor.getString(columnIndex)
                cursor.close()
                address
            } else {
                null
            }
        }
    }
}

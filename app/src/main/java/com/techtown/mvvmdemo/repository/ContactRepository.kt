package com.techtown.mvvmdemo.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.techtown.mvvmdemo.dao.ContactDao
import com.techtown.mvvmdemo.data.Contact
import com.techtown.mvvmdemo.database.ContactDatabase

class ContactRepository(application: Application){
    private val contactDatabase = ContactDatabase.getInstance(application)!!
    private val contactDao : ContactDao = contactDatabase.contactDao()
    private val contacts : LiveData<List<Contact>> = contactDao.getAll()

    fun getAll() : LiveData<List<Contact>> {
        return contacts
    }

    fun insert(contact : Contact) {
        try{
            val thread = Thread(
                Runnable {
                    contactDao.insert(contact)
                }
            )
            thread.start()
        }catch (e : Exception){

        }
    }

    fun delete(contact : Contact) {
        try{
            val thread = Thread(
                Runnable {
                    contactDao.delete(contact)
                }
            )
        }catch (e : Exception){

        }
    }
}
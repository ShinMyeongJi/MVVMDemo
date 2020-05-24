package com.techtown.mvvmdemo.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.techtown.mvvmdemo.data.Contact




@Dao
interface ContactDao {

    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAll() : LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) //중복된 데이터 있을 시
    fun insert(contact : Contact)

    @Delete
    fun delete(contact : Contact)
}
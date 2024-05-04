package com.example.database.db

import com.example.database.model.User

interface MyDbInterface {
    fun addUser(user: User)
    fun showUser(): ArrayList<User>
    fun editUser(user: User)
    fun deleteUser(user: User)
}
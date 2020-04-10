package com.example.mylibrary


class Book {

    private val image :Int

    constructor(image:Int){

        this.image=image
    }

    fun getImage(): Int {
        return this.image
    }
}
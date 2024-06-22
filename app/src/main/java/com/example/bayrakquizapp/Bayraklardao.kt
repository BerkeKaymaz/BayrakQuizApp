package com.example.bayrakquizapp

import android.annotation.SuppressLint

class Bayraklardao {

    @SuppressLint("Range")
    fun rastgele5BayrakGetir(vt:DBHelper): ArrayList<Bayraklar>{
        val bayrakListe = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5 ",null)

        while (cursor.moveToNext()){
            val bayrak = Bayraklar(
                cursor.getInt(cursor.getColumnIndex("bayrak_id")),
                cursor.getString(cursor.getColumnIndex("bayrak_ad")),
                cursor.getString(cursor.getColumnIndex("bayrak_resim"))

            )
            bayrakListe.add(bayrak)
        }
        return bayrakListe
    }

    @SuppressLint("Range")
    fun rastgele3YanlisSecenekGetir(vt:DBHelper,bayrak_id:Int): ArrayList<Bayraklar>{
        val bayrakListe = ArrayList<Bayraklar>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3 ",null)

        while (cursor.moveToNext()){
            val bayrak = Bayraklar(
                cursor.getInt(cursor.getColumnIndex("bayrak_id")),
                cursor.getString(cursor.getColumnIndex("bayrak_ad")),
                cursor.getString(cursor.getColumnIndex("bayrak_resim"))

            )
            bayrakListe.add(bayrak)
        }
        return bayrakListe
    }







}
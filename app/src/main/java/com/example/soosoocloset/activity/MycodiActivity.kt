package com.example.soosoocloset.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.soosoocloset.R
import kotlinx.android.synthetic.main.activity_mycodi.*

class MycodiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mycodi)

        //CodiFragment 데이터 받아오기
        /*val bytearray = intent.getByteArrayExtra("codi_img")
        val codi_img = bytearray?.let { convertBitmap(it) } //ByteArray를 Bitmap으로 변환*/
        val codi_img = intent.getParcelableExtra<Uri>("codi_img")

        val codi_description = intent.getStringExtra("codi_description")
        val likes = intent.getStringExtra("likes")
        val codi_date = intent.getStringExtra("codi_date")

        //나의 코디 화면 값들 재설정
        Glide.with(applicationContext).load(codi_img).into(iv_mycodi)
        tv_codi_description.setText(codi_description)
        tv_likes_num.setText(likes)
        tv_codi_date.setText(codi_date)
    }

    //ByteArray를 Bitmap으로 변환하는 메서드
    fun convertBitmap(arr: ByteArray): Bitmap {
        try {
            var bitmap = BitmapFactory.decodeByteArray(arr, 0, arr.size)
            return bitmap
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    // 상단바와 메뉴를 연결하는 메소드
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.mycodi_menu, menu)
        return true
    }

    // 상단바의 메뉴 클릭시 호출되는 메소드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_delete_codi -> {
                return true
            }
            R.id.item_update_codi -> {
                return true
            }
            else -> {return super.onOptionsItemSelected(item)}
        }
    }
}
package com.example.drawerlayoutpro

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.drawerlayoutpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //1. 액션 바 대신에 툴바로 대체.
        setSupportActionBar(binding.toolbar)
        //2.ActionBarDrawerToggle 버튼 적용
        toggle =ActionBarDrawerToggle(this, binding.drawerlayout,R.string.drawer_open,R.string.drawer_close)
        //3.업 버튼 활성화
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //4. 토글 sync
        toggle.syncState()
    }

    // 메튜 토글 버튼을 눌렀을 때 네비게이션 바 활성화 < -- >
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
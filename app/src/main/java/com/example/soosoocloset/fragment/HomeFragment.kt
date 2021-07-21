package com.example.soosoocloset.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soosoocloset.activity.CodiActivity
import com.example.soosoocloset.R
import com.example.soosoocloset.adapter.HomeAdapter
import com.example.soosoocloset.domain.Home
import com.example.soosoocloset.RetrofitClient
import com.example.soosoocloset.data.homeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// author: Sumin, created: 21.05.19, last modified : 21.07.13
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true) // 상단바의 메뉴 허용

        var homeList = arrayListOf<Home>()
        val rv_home : RecyclerView = view.findViewById(R.id.rv_home)
        val homeAdapter = HomeAdapter(context!!, homeList)
        val layoutManager : GridLayoutManager = GridLayoutManager(view.context, 2)

        rv_home.layoutManager = layoutManager
        rv_home.adapter = homeAdapter

        //홈화면 서버와 통신
        var nickname : String
        var likes : String
        RetrofitClient.api.homeRequest().enqueue(object : Callback<homeResponse> {
            override fun onFailure(call: Call<homeResponse>, t: Throwable) {
                //  Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<homeResponse>, response: Response<homeResponse>) {
                var result: homeResponse = response.body()!! // 응답 결과

                if(result.code.equals("404")) { // 에러 발생 시
                    // Toast.makeText(context ,"Error", Toast.LENGTH_SHORT).show()
                }  else if(result.code.equals("200")) { // 홈화면 코디들 조회 성공

                    nickname = result.resultArray.get(0).nickname
                    likes = result.resultArray.get(0).likeCount
                    homeList.add(Home(nickname, likes))

                    homeAdapter.notifyDataSetChanged()
                }
            }
        })

        // 홈 화면의 코디리스트 아이템 클릭시
        homeAdapter.setItemClickListener(object : HomeAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                startActivity(Intent(context, CodiActivity::class.java))

            }
        })
        return view
    }
}

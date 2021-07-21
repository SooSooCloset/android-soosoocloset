package com.example.soosoocloset

import com.example.soosoocloset.data.findpwResponse
import com.example.soosoocloset.data.findidResponse
import com.example.soosoocloset.data.homeResponse
import com.example.soosoocloset.data.loginResponse
import com.example.soosoocloset.data.signupResponse
import com.example.soosoocloset.data.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitApi {
    // 회원가입 API
    @FormUrlEncoded
    @POST("/user/signup")
    fun requestSignup(
        @Field("user_name") name: String,
        @Field("nickname") nickname: String,
        @Field("gender") gender: String,
        @Field("birth") birth: String,
        @Field("user_id") id: String,
        @Field("user_pw") pw: String
    ): Call<signupResponse>

    // 로그인 API
    @FormUrlEncoded
    @POST("/user/login")
    fun loginRequest(
        @Field("user_id") id: String,
        @Field("user_pw") pw: String
    ) : Call<loginResponse>

    // 비밀번호 찾기 API
    @FormUrlEncoded
    @POST("/user/findpw")
    fun requestFindpw(
        @Field("user_id") id:String,
        @Field("user_email") email:String
    ) : Call<findpwResponse>

    // 아이디 찾기 API
    @FormUrlEncoded
    @POST("/user/findid")
    fun findidRequest(
        @Field("user_name") name: String,
        @Field("birth") birth: String
    ) : Call<findidResponse>

    // 홈 화면 API
    //@FormUrlEncoded
    @POST("/user/home")
    fun homeRequest(
    ) : Call<homeResponse>

}
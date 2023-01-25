package ru.stas.fitnesstest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface LessonApi {
        @GET("schedule/get_v3/")
        suspend fun getLessons(@Query("club_id") clubId: Int): Response<Data>
}

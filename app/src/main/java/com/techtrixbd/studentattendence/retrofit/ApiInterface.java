package com.techtrixbd.studentattendence.retrofit;

import com.techtrixbd.studentattendence.model.ModelAttendence;
import com.techtrixbd.studentattendence.model.ModelResponse;
import com.techtrixbd.studentattendence.model.ModelStudent;

import java.util.List;

import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ApiInterface {

    @POST("student_registration.php/")
    Single<ModelResponse> register(@Body ModelStudent student);

    @POST("present.php/")
    Single<ModelResponse> attendence(@Body ModelAttendence attendence);

    @GET("login.php/")
    Single<ModelResponse> login(@Query("id") String id);

    @GET("get_ids.php/")
    Single<List<ModelAttendence>> get_ids(@Query("date") String date);

   /* @GET("get_news_data.php/")
    Single<List<ModelNews>> getNewsData();

    @POST("get_inst_by_category.php/")
    Single<List<ModelInstitution>> getInstitutes(@Body ModelInstitution inst);

    @GET("get_all_bottom_ads.php/")
    Single<List<ModelBottomAd>> getBottomAd();

    @GET("get_inter_ad.php/")
    Single<List<ModelInterAd>> getInterAd();

    @POST("get_all_notice_data.php/")
    Single<List<ModelNotice>> getNotices(@Body ModelNotice notice);

    @POST("inst_login.php/")
    Single<ResponseModel> instLogin(@Body ModelLogin login);

    @POST("send_inter_clicks.php/")
    Single<ResponseModel> sendInterClick(@Body ModelInterAd ad);

    @POST("send_bottom_clicks.php/")
    Single<ResponseModel> sendBottomClick(@Body ModelBottomAd ad);

    @POST("user_login.php/")
    Single<ResponseModel> userLogin(@Body ModelLogin login);

    @POST("get_inst_info.php/")
    Single<List<ModelInstitution>> getInstitutionProfileData(@Body ModelInstitution institution);

    @POST("get_calender.php/")
    Single<List<ModelCalender>> getCalender(@Body ModelCalender calender);

    @POST("check_block.php/")
    Single<ResponseModel> getIfBlocked(@Body ModelInstitution institution);

    @POST("update_inst_pass.php/")
    Single<ResponseModel> updatePass(@Body ModelInstitutionEdit institution);

    @POST("subscribe.php/")
    Single<ResponseModel> subscribe(@Body ModelNotice modelNotice);

    @POST("unsubscribe.php/")
    Single<ResponseModel> unsubscribe(@Body ModelNotice modelNotice);

    @POST("update_notice_info.php/")
    Single<ResponseModel> updateNoticeData(@Body ModelNotice notice);

    //update_user_info.php
    @POST("update_user_info.php/")
    Single<ResponseModel> updateUserData(@Body ModelStudent student);

    @POST("delete_notice.php/")
    Single<ResponseModel> deleteNotice(@Body ModelNotice notice);

    @POST("make_inst_payment.php/")
    Single<ResponseModel> makeInstPayment(@Body ModelPayment payment);

    @POST("edit_inst.php/")
    Single<ResponseModel> editInstitution(@Body ModelInstitutionEdit edit);

    @POST("user_registration.php/")
    Single<ResponseModel> studentSignUp(@Body ModelStudent student);

    @POST("upload_notice_without_pdf.php/")
    Single<ResponseModel> uploadNoticeWithoutPdf(@Body ModelNotice modelNotice);

    @POST("get_inst_payment_data.php/")
    Single<List<ModelPayment>> getPayment(@Body ModelPayment payment);

    @POST("get_user_subs.php/")
    Observable<List<ModelInstitution>> getUserSubs(@Body ModelStudent student);

    @POST("get_user_info.php/")
    Observable<List<ModelStudent>> getUserData(@Body ModelStudent student);

    @POST("get_sub_notice_count.php/")
    Observable<ResponseModel> getSubNoticeCount(@Body ModelInstitution institution);

    @GET("send_verification_mail.php/")
    Observable<ResponseModel> requestVerificationCode(@Query("email") String email, @Query("user") String user, @Query("code") String code);

    @GET("reset_password.php/")
    Observable<ResponseModel> resetPass(@Query("email") String email, @Query("user") String user, @Query("pass") String pass);

    @GET
    Observable<ResponseModel> sendNotification(@Url String url);

    @Multipart
    @POST("upload_calender.php/")
    Single<ResponseModel> calenderUpload(
            @Part("image_information") RequestBody description,
            @Part MultipartBody.Part file);

    @Multipart
    @POST("change_profile_image.php/")
    Single<ResponseModel> uploadImage(
            @Part("image_information") RequestBody description,
            @Part MultipartBody.Part file);

    @Multipart
    @POST("update_notice_pdf.php/")
    Single<ResponseModel> updatePdf(
            @Part("image_information") RequestBody description,
            @Part MultipartBody.Part file);

    @Multipart
    @POST("upload_notice.php/")
    Single<ResponseModel> uploadNoticeWithPdf(
            @Part("image_information") RequestBody description,
            @Part MultipartBody.Part file);


    @Multipart
    @POST("inst_registration.php/")
    Single<ResponseModel> fileUpload(
            @Part("image_information") RequestBody description,
            @Part MultipartBody.Part file);*/

}

package com.zczczy.leo.fuwuwangapp.rest;


import com.zczczy.leo.fuwuwangapp.model.BaseModel;

import org.androidannotations.annotations.rest.Delete;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Put;
import org.androidannotations.annotations.rest.RequiresAuthentication;
import org.androidannotations.annotations.rest.RequiresCookie;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.annotations.rest.SetsCookie;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.androidannotations.api.rest.RestClientHeaders;
import org.androidannotations.api.rest.RestClientRootUrl;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;

/**
 * Created by Leo on 2015/3/9.
 */

@Rest(rootUrl = "http://112.126.73.18:8081/api/values", requestFactory = MyRequestFactory.class, interceptors = { MyInterceptor.class },
        converters = {StringHttpMessageConverter.class,	MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class, ByteArrayHttpMessageConverter.class })
public interface MyRestClient extends RestClientRootUrl, RestClientSupport, RestClientHeaders, RestClientErrorHandling {

    @Post("/Post/{id}")
    @RequiresHeader(value = {"Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE, "Content-Disposition", "filename", "charset"})
    String uploadAvatar(int id, MultiValueMap<String, Object> formData);

    @Post("/testPostEntity/{id}")
    String testPostEntity(int id, BaseModel bm);


    @Delete("/deleteTest/{id}")
    @RequiresAuthentication
    BaseModel deleteTest(int id);


    @Get("/Login/{id}")
    @SetsCookie("JSESSIONID")
    BaseModel login(int id);

    /**
     * 必须传入一个JSESSIONID
     * 也就是说，必须在登录的情况下才可以
     *
     * @param page
     * @param rows
     * @return
     */
    @Post("/getVideoInfoList/{page}/{rows}")
    @RequiresCookie("JSESSIONID")
    String getVideoInfoList(int page, int rows);

    @Put("/Put")
    String putTest(BaseModel bm);


    //void setHeader(String value,String va);

}

package com.example.frank.commemorativebook;

import android.app.Activity;


import com.example.frank.commemorativebook.config.URLConfig;
import com.tamic.novate.Novate;
import com.tamic.novate.callback.RxListCallback;
import com.tamic.novate.callback.RxStringCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 2017/12/20.
 */

public class ApiService {
    public static final String Base_Url = URLConfig.ServiceURL;
    private static HashMap<String, Object> header;

    public static void GetString(final Activity activity, final String url, final Map<String, Object> parameter, final RxStringCallback rxStringCallback) {

        header = new HashMap<>();
            header.put("token", Token.getTOKEN(activity));
            Novate novate = new Novate.Builder(activity)
                    .addCache(false)
                    .baseUrl(Base_Url)
                    .addHeader(header)
                    .addCookie(false)
                    .connectTimeout(500000)
                    .writeTimeout(500000)
                    .build();
            novate.rxPost(url, parameter, rxStringCallback);

    }

    public static void GetList(Activity activity, String url, Map<String, Object> parameter, RxListCallback rxListCallback) {
        header = new HashMap<>();
        header.put("token", Token.getTOKEN(activity));
        Novate novate = new Novate.Builder(activity)
                .addCache(false)
                .baseUrl(Base_Url)
                .addHeader(header)
                .addCookie(false)
                .build();
        novate.rxPost(url, parameter, rxListCallback);
    }
}
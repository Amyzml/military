package com.daicy.military.core;

import com.daicy.military.exception.base.ParamException;
import com.daicy.military.util.HttpUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenInterceptor implements HandlerInterceptor {

    private static Logger log = Logger.getLogger(AuthenInterceptor.class);
    @Value("${daicy.auth.host}")
    private String user_host;
    @Value("${daicy.auth.port}")
    private String user_port;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        JSONObject user_json = null;
        JSONObject admin_json = null;
      /*  try{
            if(!url.contains("/identity/admin")){
                String user_info = HttpUtil.get(request,user_host,Integer.parseInt(user_port),"/user/identity/getUserToken");
                user_json = JSONObject.fromObject(user_info);
                String user_id = user_json.getString("uId");
                request.setAttribute("id",user_id);
                request.setAttribute("user",user_json);
            }else{
                String admin_info = HttpUtil.get(request,user_host,Integer.parseInt(user_port),"/user/identity/admin/getAdminToken");
                admin_json = JSONObject.fromObject(admin_info);
                String admin_id = admin_json.getString("adminuserId");
                request.setAttribute("adminuserId",admin_id);
                request.setAttribute("admin",admin_json);
            }
        }catch(ParamException e){
            throw new ParamException();
        }*/
        return true;
    }

}

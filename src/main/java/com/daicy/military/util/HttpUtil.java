package com.daicy.military.util;

import com.daicy.military.exception.base.InternalRequestException;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


public class HttpUtil {

    /**
     * 根据也无需求自己修改对应方法
     */

    private static String HTTP_PROTOCOL = "http";
    private static Logger log = Logger.getLogger(HttpUtil.class);

    public static String get(HttpServletRequest request, String host, int port, String server) throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.getHostConfiguration().setHost(host, port, HTTP_PROTOCOL);
        GetMethod method = new GetMethod(server);
        method.setRequestHeader("Daicy-Token", (String) request.getAttribute("Daicy-Token"));
        method.releaseConnection();
        String response = null;
        try {
            int httpStatus = httpClient.executeMethod(method);
            if (httpStatus != HttpStatus.SC_OK) {
                throw new InternalRequestException();
            }
            response = method.getResponseBodyAsString();
        } catch (Exception e) {
            log.error("httpClient get remote method error :" + e);
            throw e;
        }
        return response;
    }

    public static String put(HttpServletRequest request, String host, int port, String server,
                             String body) throws Exception {
        String response = null;
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.getHostConfiguration()
                    .setHost(host, port, HTTP_PROTOCOL);
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
            PutMethod method = new PutMethod(server);
            method.setRequestHeader("Daicy-Token", (String) request.getAttribute("Daicy-Token"));
            log.debug("put ip = " + host + "  port= " + port
                    + " request server" + method.getURI() + " params is  "
                    + body);
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler());
            StringRequestEntity entity;
            entity = new StringRequestEntity(body,
                    "application/json", "UTF-8");
            method.setRequestEntity(entity);
            method.releaseConnection();
            int statusCode = httpClient.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                throw new InternalRequestException();
            }
            response = method.getResponseBodyAsString();
        } catch (Exception e) {
            log.error("httpClient put json remote method error :" + e);
            throw e;
        }
        return response;
    }

    public static String delete(HttpServletRequest request, String host, int port, String server) throws Exception {
        String response = null;
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.getHostConfiguration()
                    .setHost(host, port, HTTP_PROTOCOL);
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
            DeleteMethod method = new DeleteMethod(server);
            method.setRequestHeader("Daicy-Token", (String) request.getAttribute("Daicy-Token"));
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler());
            method.releaseConnection();
            int statusCode = httpClient.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                throw new InternalRequestException();
            }
            response = method.getResponseBodyAsString();
        } catch (Exception e) {
            log.error("httpClient put json remote method error :" + e);
            throw e;
        }
        return response;
    }

    public static String post(HttpServletRequest request, String host, int port, String server,
                              String body) throws Exception {
        String response = null;
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.getHostConfiguration()
                    .setHost(host, port, HTTP_PROTOCOL);
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
            PostMethod method = new PostMethod(server);
            method.setRequestHeader("Daicy-Token", (String) request.getAttribute("Daicy-Token"));
            log.debug("post request server" + method.getURI() + " params is  " + body);
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler());
            StringRequestEntity entity;
            entity = new StringRequestEntity(body, "application/json", "UTF-8");
            method.setRequestEntity(entity);
            method.releaseConnection();
            int statusCode = httpClient.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                throw new InternalRequestException();
            }
            response = method.getResponseBodyAsString();
        } catch (Exception e) {
            log.error("httpClient post json remote method error :" + e);
            throw e;
        }
        return response;
    }
}

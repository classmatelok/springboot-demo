package com.lok.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CookieTools {
    /**
     * 根据cookie的名称获取Cookie
     * @param cookieName 名称
     * @return Cookie
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName ){
          /** 获取用户浏览器中所有的 cookie */
         Cookie[] cookies = request.getCookies();
          if (cookies != null && cookies.length > 0){
              for (Cookie cookie : cookies ){
                   if (cookie .getName().equals(cookieName )){
                        return cookie ;
                  }
             }
         }
          return null ;
    }
    /**
     * 添加cookie
     * @param cookieName 名称
     * @param cookieValue 值
     * @param maxAge 存活时间按秒计算
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue , int maxAge ){
          /** 获取cookie */
         Cookie cookie = getCookie(request, cookieName);
          if (cookie == null){
              /** 创建cookie */
              cookie = new Cookie(cookieName , cookieValue );
         }
          /** 设置cookie的存活时间 */
          cookie.setMaxAge( maxAge);
          /** 设置cookie的访问路径  http://localhost:8080/ */
          cookie.setPath( "/" );
          /** 设置cookie跨域访问 http://risk.gf.com.cn -> http://xxx.gf.com.cn */
          cookie.setDomain(".gf.com.cn");
          /** 在用户浏览器中生成cookie */
          response.addCookie(cookie);
    }
    /**
     * 删除Cookie
     * @param cookieName 名称
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response,String cookieName){
          /** 获取cookie */
         Cookie cookie = getCookie(request, cookieName);
          if (cookie != null){
              /** 让cookie失效 */
              cookie.setMaxAge(0);
              /** 设置cookie的访问路径  http://localhost:8080/ */
              cookie.setPath( "/" );
              /** 在用户浏览器中生成新的cookie覆盖 */
              response.addCookie(cookie);
         }
    }
}

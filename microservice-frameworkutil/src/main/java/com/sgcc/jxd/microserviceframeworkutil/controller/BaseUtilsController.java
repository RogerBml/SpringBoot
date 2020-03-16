package com.sgcc.jxd.microserviceframeworkutil.controller;

import com.sgcc.jxd.microserviceframeworkutil.service.TimeService;
import com.sgcc.jxd.microserviceframeworkutil.utils.qrutils.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/base/util")
public class BaseUtilsController {


    @Autowired
    private TimeService timeService;
    /**
     * 统一获取时间
     * @return
     */
    @GetMapping("/time")
        public String getTime(){
            return timeService.getTime();
        }
    /**
     * 二维码
     * @param request
     * @param response
     */
    @GetMapping ("/qrcode")
    public void qrcode(HttpServletRequest request, HttpServletResponse response)  throws IOException {
        StringBuffer url = request.getRequestURL();
        try {
            OutputStream os = response.getOutputStream();
            //从配置文件读取需要生成二维码的连接
//            String requestUrl = GraphUtils.getProperties("requestUrl");
            //requestUrl:需要生成二维码的连接，logoPath：内嵌图片的路径，os：响应输出流，needCompress:是否压缩内嵌的图片
            QRCodeUtil.encode("http://www.baidu.com", null, os, true);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}

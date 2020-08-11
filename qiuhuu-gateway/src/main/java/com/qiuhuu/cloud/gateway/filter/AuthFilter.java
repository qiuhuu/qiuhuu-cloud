//package com.qiuhuu.gateway.filter;
//
///**
// * @author : qiuhuu
// * @date : 2020-07-09 15-10
// */
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.collect.Maps;
//import com.qiuhuu.common.core.constants.ResultEnum;
//import com.qiuhuu.common.core.model.ResultBody;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Map;
//
///**
// * 鉴权过滤器
// * @author qiuhuu
// * @date 2020-07-09 15-12
// */
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token = exchange.getRequest().getQueryParams().getFirst("token");
//
//        if (token == null || token.isEmpty()) {
//            ServerHttpResponse response = exchange.getResponse();
//
//            // 封装错误信息
//            ResultBody resultBody = new ResultBody().failure(ResultEnum.NO_AUTHORIZATION, "非法请求", 401);
//
//            // 将信息转换为 JSON
//            byte[] data = JSON.toJSONBytes(resultBody);
//
//            // 输出错误信息到页面
//            DataBuffer buffer = response.bufferFactory().wrap(data);
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//            return response.writeWith(Mono.just(buffer));
//        }
//
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 设置过滤器的执行顺序
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return Ordered.LOWEST_PRECEDENCE;
//    }
//}

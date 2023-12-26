package com.recordrock.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/naverLogin")
    public void loginNaver(HttpServletResponse httpServletResponse) throws IOException {
        SecureRandom sr = new SecureRandom();
        String stateCode = new BigInteger(130, sr).toString();

        httpServletResponse.sendRedirect("https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=_fFGK1D4khKcBZzjprq1&state="+stateCode+"&redirect_uri=http://localhost:8080/login/naver_callback");
    }


    /************************************
    // 1. Naver 인증 토큰을 발급 받는 로직
    // 2. 발급 받은 인증 토큰으로 Naver로부터 유저의 Profile 정보를 받아오는 로직
    // 3. 서비스서버에서 해당 유저의 정보를 조회 후, 가입이 필요하면 가입을 시킨 뒤, 로그인 처리해주는 로직

     * 요청 프로세스:
     * 1. 유저가 클라이언트를 통해 로그인 요청(서비스로부터 받은 redirect_url과 state 전달)
     * 2. Naver인증서버에서 서비스서버로 callback API 요청 (code와 state가 파라미터로 들어옴, state로 보안검증)
     * 3. 서비스 서버에서 Naver인증서버 요청 기준에 맞춰 Token발급 POST(또는 GET) 요청
     * 4. 서비스 서버에서 Naver 인증서버 요청 기준에 맞춰 유저 Profile POST(또는 GET) 요청 (NAVER 토큰 전달)
     * 5. Naver 인증서버로부터 받은 유저의 Profile 정보를 바탕으로 서비스 서버 회원가입 및 로그인
     * 6. 유저에게 토큰 발급 및 로그인 성공
    ************************************/
    @GetMapping("/naver_callback")
    public void callBack(HttpServletRequest request){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://nid.naver.com/oauth2.0/token";
        String grantType = "authorization_code";
        String clientId = "_fFGK1D4khKcBZzjprq1";
        String clientSecret = "g2FjHTQ6uK";

        HttpHeaders httpHeaders = new HttpHeaders();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", grantType);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", request.getParameter("code"));
        params.add("state", request.getParameter("state"));
        HttpEntity<MultiValueMap<String, String>> naverTokenRequest
                = new HttpEntity<>(params, httpHeaders);

        System.out.println("naverTokenRequest = " + naverTokenRequest);

        ResponseEntity<String> oauthTokenResponse = restTemplate.exchange(
                "https://nid.naver.com/oauth2.0/token",
                HttpMethod.POST,
                naverTokenRequest,
                String.class
        );

        System.out.println("oauthTokenResponse = " + oauthTokenResponse);

        ObjectMapper token_om = new ObjectMapper();
        NaverTokenVo naverToken = null;

        System.out.println("oauthTokenResponse.getBody() = " + oauthTokenResponse.getBody());
        
        try {
            naverToken = token_om.readValue(oauthTokenResponse.getBody(), NaverTokenVo.class);
        } catch(JsonProcessingException je){
            je.printStackTrace();
        }

        System.out.println("naverToken = " + naverToken);

        // 토큰을 이용해 정보를 받아올 API 요청을 보낼 로직
        RestTemplate restTemplateProfile = new RestTemplate();
        HttpHeaders userDetailReqHeaders = new HttpHeaders();

        userDetailReqHeaders.add("Authorization", "Bearer " + naverToken.getAccess_token());
        userDetailReqHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");;
        HttpEntity<MultiValueMap<String, String>> naverProfileRequest = new HttpEntity<>(userDetailReqHeaders);

        ResponseEntity<String> userDetailResponse = restTemplateProfile.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                naverProfileRequest,
                String.class
        );

        System.out.println("userDetailResponse = " + userDetailResponse);

    }
}

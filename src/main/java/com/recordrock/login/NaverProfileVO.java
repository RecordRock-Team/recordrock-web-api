package com.recordrock.login;

import lombok.Data;

@Data
public class NaverProfileVO {
    private String resultCode;
    private String message;
    private response response;

    @Data
    public class response {
        private String id;
        private String nickName;
        private String name;
        private String email;
        private String gender;
        private String age;
        private String birthday;
        private String profileImage;
        private String birthYear;
        private String mobile;
        private String mobile_el64;
    }
}

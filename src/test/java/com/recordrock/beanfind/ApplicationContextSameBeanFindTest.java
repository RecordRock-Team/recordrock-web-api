package com.recordrock.beanfind;

import com.recordrock.member.MemberRepository;
import com.recordrock.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

//    @Test
//    @DisplayName("중복오류 테스트")
//    void findBeanByTypeDuplicate(){
//        assertThrows(NoUniqueBeanDefinitionException.class,
//                () -> ac.getBean(MemberRepository.class));
//    }

//    @Test
//    @DisplayName("중복ㅇ오류 테스트")
//    void findBeanByName(){
//       MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
//    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}

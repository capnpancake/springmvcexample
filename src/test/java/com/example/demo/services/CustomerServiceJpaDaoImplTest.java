package com.example.demo.services;

import com.example.demo.config.JpaIntegrationConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class CustomerServiceJpaDaoImplTest {
}

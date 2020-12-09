package org.geekbang.thinking.in.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * @author Linn-cn
 * @create 2020/11/25
 */
public class PayloadApplicationEventDemo implements ApplicationEventPublisherAware {

        private static ApplicationEventPublisher publisher;

        public static void main(String[] args) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
            context.register(PayloadApplicationEventDemo.class);
            // context.addApplicationListener((ApplicationListener<PayloadApplicationEvent<String>>) System.out::println);
            context.refresh();
            publisher.publishEvent("Hello world");
            context.close();
        }

        @Override
        public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
            publisher = applicationEventPublisher;
        }

        @EventListener
        // @Order(1)
        public void payloadEventListener(PayloadApplicationEvent<String> event) {
            System.out.println(event);
        }
    }

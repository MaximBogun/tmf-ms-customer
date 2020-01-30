package com.icthh.xm.tmf.ms.customer.client;

import com.icthh.xm.tmf.ms.customer.config.faign.OAuth2UserClientFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@FeignClient
@Target(TYPE)
@Retention(RUNTIME)
public @interface AuthorizedUserFeignClient {

    @AliasFor(annotation = FeignClient.class, attribute = "name")
    String name() default "";

    /**
     * A custom {@code @Configuration} for the feign client.
     *
     * Can contain override {@code @Bean} definition for the pieces that make up the client, for instance {@link
     * feign.codec.Decoder}, {@link feign.codec.Encoder}, {@link feign.Contract}.
     *
     * @see FeignClientsConfiguration for the defaults.
     */
    @AliasFor(annotation = FeignClient.class, attribute = "configuration")
    Class<?>[] configuration() default OAuth2UserClientFeignConfiguration.class;

    /**
     * An absolute URL or resolvable hostname (the protocol is optional).
     */
    String url() default "";

    /**
     * Whether 404s should be decoded instead of throwing FeignExceptions.
     */
    boolean decode404() default false;

    /**
     * Fallback class for the specified Feign client interface. The fallback class must implement the interface
     * annotated by this annotation and be a valid Spring bean.
     */
    Class<?> fallback() default void.class;

    /**
     * Path prefix to be used by all method-level mappings. Can be used with or without {@code @RibbonClient}.
     */
    String path() default "";
}

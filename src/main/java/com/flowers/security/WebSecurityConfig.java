package com.flowers.security;

import com.flowers.security.jwt.JwtAuthEntryPoint;
import com.flowers.security.jwt.JwtAuthTokenFilter;
import com.flowers.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.flowers.utils.Constants.APP_ROOT;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
        return new JwtAuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/**/auth/authenticated").permitAll()
                .antMatchers("/**/auth/signUp").permitAll()
                .antMatchers("/**/auth/registerUser").permitAll()

                .antMatchers("/**/categories/create").permitAll()
                .antMatchers("/**/categories/update/{catId}").permitAll()
                .antMatchers("/**/categories/findById/{catId}").permitAll()
                .antMatchers("/**/categories/search-all-active-categories").permitAll()
                .antMatchers("/**/categories/delete-category/{catId}").permitAll()

                .antMatchers("/**/subcategories/create").permitAll()
                .antMatchers("/**/subcategories/update/*").permitAll()
                .antMatchers("/**/subcategories/findById/{subCatId}").permitAll()
                .antMatchers("/**/subcategories/search-subcategories-by-categoryId/{catId}").permitAll()
                .antMatchers("/**/subcategories/search-all-active-subcategories").permitAll()
                .antMatchers("/**/subcategories/delete-subcategory/{catId}").permitAll()

                .antMatchers("/**/products/create-with-file").permitAll()
                .antMatchers("/**/products/create-with-file-In-folder").permitAll()
                .antMatchers("/**/products/update/{idProduct}").permitAll()
                .antMatchers("/**/products/findById/{idProduct}").permitAll()
                .antMatchers("/**/products/search-product-by-reference/{reference}").permitAll()
                .antMatchers("/**/products/search-product-by-selected-is-true").permitAll()
                .antMatchers("/**/products/all").permitAll()
                .antMatchers("/**/products/search-all-active-products").permitAll()
                .antMatchers("/**/products/products-by-subcategories/{subCatId}").permitAll()
                .antMatchers("/**/products/products-by-fournisseur/{fournisseurId}").permitAll()
                .antMatchers("/**/products/products-by-subcategory-name/{subCatName}").permitAll()
                .antMatchers("/**/products/search-product-by-keyword").permitAll()
                .antMatchers("/**/products/search-top3-product-by-orderIdDesc").permitAll()
                .antMatchers("/**/products/search-top4-product-by-orderIdDesc").permitAll()
                .antMatchers("/**/products/search-top8-product-by-orderIdDesc").permitAll()
                .antMatchers("/**/products/search-top24-product-by-order").permitAll()
                .antMatchers("/**/products/photoProduct/{idProduct}").permitAll()
                .antMatchers("/**/products/photoProductInFolder/{idProduct}").permitAll()
                .antMatchers("/**/products/uploadProductPhoto/{idProduct}").permitAll()
                .antMatchers("/**/products/uploadProductPhotoInFolder/{idProduct}").permitAll()
                .antMatchers("/**/products/search-product-by-pageable").permitAll()
                .antMatchers("/**/products/search-product-by-subcategory-by-pageable").permitAll()
                .antMatchers("/**/products/search-all-products-by-pageable").permitAll()
                .antMatchers("/**/products/search-all-products-by-subcategory-by-pageable").permitAll()
                .antMatchers("/**/products/search-products-by-subcategory-name-by-pageable").permitAll()
                .antMatchers("/**/products/search-all-products-by-keyword-by-pageable").permitAll()
                .antMatchers("/**/products/productSize").permitAll()
                .antMatchers("/**/products/productSize-by-subcategoryId").permitAll()
                .antMatchers("/**/products/product-size-by-subcategory-name").permitAll()
                .antMatchers("/**/products/productSize-by-keyword").permitAll()
                .antMatchers("/**/products/count-number-total-of-products").permitAll()
                .antMatchers("/**/products/delete-product/*").permitAll()

                .antMatchers("/**/fournisseurs/create").permitAll()
                .antMatchers("/**/fournisseurs/findById/*").permitAll()
                .antMatchers("/**/fournisseurs/update/{idFournisseur}").permitAll()
                .antMatchers("/**/fournisseurs/search-all-active-fournisseurs").permitAll()
                .antMatchers("/**/fournisseurs/count-number-of-fournisseur").permitAll()
                .antMatchers("/**/fournisseurs/delete-fournisseur/{idFournisseur}").permitAll()

                .antMatchers("/**/orders/findById/{idOrder}").permitAll()
                .antMatchers("/**/orders/update-status-of-order/{id}").permitAll()
                .antMatchers("/**/orders/find-list-order-by-status-pending").permitAll()
                .antMatchers("/**/orders/find-list-order-by-status-payed").permitAll()
                .antMatchers("/**/orders/search-all-active-orders").permitAll()
                .antMatchers("/**/orders/search-order-by-userId-order-by-IdDesc/*").permitAll()
                .antMatchers("/**/orders/search-order-by-billing-addressIdDesc/*").permitAll()
                .antMatchers("/**/orders/search-order-by-shipping-addressIdDesc/*").permitAll()
                .antMatchers("/**/orders/search-orders-by-userId-by-pageable/***").permitAll()
                .antMatchers("/**/orders/count-number-of-orders-by-pending-status").permitAll()
                .antMatchers("/**/orders/count-number-of-order").permitAll()
                .antMatchers("/**/orders/count-number-of-orders-in-month").permitAll()
                .antMatchers("/**/orders/sum-total-of-order-by-day").permitAll()
                .antMatchers("/**/orders/sum-total-of-order-by-month").permitAll()
                .antMatchers("/**/orders/sum-total-of-order-by-year").permitAll()
                .antMatchers("/**/orders/number-of-order-by-day").permitAll()
                .antMatchers("/**/orders/number-of-order-by-month").permitAll()
                .antMatchers("/**/orders/sum-total-of-order-by-month-by-list").permitAll()
                .antMatchers("/**/orders/ sum-total-of-order-by-year-list").permitAll()
                .antMatchers("/**/orders/delete-order/*").permitAll()

                .antMatchers("/**/orderItems/findById/{idOrderItem}").permitAll()
                .antMatchers("/**/orderItems/find-all-orderItems-group-by-IdDesc").permitAll()
                .antMatchers("/**/orderItems/search-all-orderItems-by-orderId/{comId}").permitAll()
                .antMatchers("/**/orderItems/search-all-active-orderItems").permitAll()
                .antMatchers("/**/orderItems/search-top200-orderItems-order-by-IdDesc").permitAll()
                .antMatchers("/**/orderItems/search-top8-orderItems-order-by-IdDesc").permitAll()
                .antMatchers("/**/orderItems/search-top3-orderItems-order-by-IdDesc").permitAll()


                //        .antMatchers("/**/checkout/placeToOrder").permitAll()
                //        .antMatchers("/**/checkout/placeToOrderWithUser/**").permitAll()

                .antMatchers("/**/checkout/placeToOrderWithLoginUser/**").permitAll()

                .antMatchers("/**/clients/findById/*").permitAll()
                .antMatchers("/**/clients/search-all-active-clients").permitAll()
                .antMatchers("/**/clients/count-number-of-client").permitAll()
                .antMatchers("/**/clients/delete-client/{idClient}").permitAll()



             //   .antMatchers("/**/blogs/findById/{blogId}").permitAll()
                .antMatchers("/**/blogs/all").permitAll()
                .antMatchers("/**/blogs/searchAllBlogsOrderByIdDesc").permitAll()

                .antMatchers("/**/addresses/findById/{addId}").permitAll()
                .antMatchers("/**/addresses/search-all-active-addresses").permitAll()
                .antMatchers("/**/addresses/delete-address/{addId}").permitAll()

                .antMatchers("/**/countries/create").permitAll()
                .antMatchers("/**/countries/**").permitAll()
                .antMatchers("/**/countries/all").permitAll()
                .antMatchers("/**/countries/search-all-active-countries").permitAll()
                .antMatchers("/**/countries/delete-country/{idCountry}").permitAll()

                .antMatchers("/**/states/**").permitAll()
                .antMatchers("/**/states/search-all-active-states").permitAll()
                .antMatchers("/**/states/search-state-by-country-code/**").permitAll()
                .antMatchers("/**/states/delete-state/{stateId}").permitAll()

                .antMatchers("/**/wishlists/create").permitAll()
             //   .antMatchers("/**/wishlists/update/{idWishlist}").permitAll()
             //   .antMatchers("/**/wishlists/findById/{idWishlist}").permitAll()
                .antMatchers("/**/wishlists/all").permitAll()
            //    .antMatchers("/**/wishlists/delete/{idWishlist}").permitAll()

                .antMatchers("/**/ratings/create").permitAll()
                .antMatchers("/**/ratings/create-rating-to-article").permitAll()
               .antMatchers("/**/ratings/search-all-active-ratings").permitAll()
               .antMatchers("/**/ratings/count-number-of-rating").permitAll()
                .antMatchers("/**/ratings/count-number-of-rating-by-productId/{idProd}").permitAll()
                .antMatchers("/**/ratings/create-rating-to-article-with-user/**").permitAll()
                .antMatchers("/**/ratings/search-top4-rating-order-by-createdDateDesc-by-productId/{idProd}").permitAll()
                .antMatchers("/**/ratings/delete-rating/{idRating}").permitAll()

                .antMatchers("/**/newsletters/create").permitAll()
               .antMatchers("/**/newsletters/count-number-of-newsletter").permitAll()
                .antMatchers("/**/newsletters/search-all-active-newsletters").permitAll()
                .antMatchers("/**/newsletters/delete-newsletter/{idNewsletter}").permitAll()

                .antMatchers("/**/emails/count-number-of-email").permitAll()
                .antMatchers("/**/emails/send-to-fournisseur").permitAll()
                .antMatchers("/**/emails/send-to-newsletter").permitAll()
                .antMatchers("/**/emails/send-mail-to-all-customers").permitAll()
                .antMatchers("/**/emails/send-mail-to-manager").permitAll()
                .antMatchers("/**/emails/findById/{idEmail}").permitAll()
                .antMatchers("/**/emails/search-all-active-emails").permitAll()
                .antMatchers("/**/emails/delete-email/{idEmail}").permitAll()

                .antMatchers("/**/utilisateurs/create").permitAll()
                .antMatchers("/**/utilisateurs/update/{idUser}").permitAll()
                .antMatchers("/**/utilisateurs/findById/{idUtilisateur}").permitAll()
                .antMatchers("/**/utilisateurs/search-utilisateur-by-username").permitAll()
                .antMatchers("/**/utilisateurs/search-all-active-utilisateurs").permitAll()
                .antMatchers("/**/utilisateurs/update-username-of-user-by-username").permitAll()
                .antMatchers("/**/utilisateurs/update-username-of-user-by-id").permitAll()
                .antMatchers("/**/utilisateurs/update-password-by-username").permitAll()
                .antMatchers("/**/utilisateurs/update-password-by-user-id").permitAll()
                .antMatchers("/**/utilisateurs/update-customer-profile-by-username").permitAll()
                .antMatchers("/**/utilisateurs/activated-user/{id}").permitAll()
                .antMatchers("/**/utilisateurs/avatar/{id}").permitAll()
                .antMatchers("/**/utilisateurs/upload-userPhoto/{id}").permitAll()
                .antMatchers("/**/utilisateurs/delete-utilisateur/{idUtilisateur}").permitAll()
                .antMatchers("/**/utilisateurs/count-number-of-register-in-month").permitAll()
                .antMatchers("/**/utilisateurs/count-number-of-register-peer-month").permitAll()

                .antMatchers("/**/historiques/count-number-of-historique-commandes").permitAll()
                .antMatchers("/**/historiques/search-all-active-historique-commandes").permitAll()
                .antMatchers("/**/historiques/delete-historique-commande/{id}").permitAll()
                .antMatchers("/**/historiques/count-number-of-historique-login").permitAll()
                .antMatchers("/**/historiques/search-all-active-historique-logins").permitAll()
                .antMatchers("/**/historiques/delete-historique-login/{idHistLog}").permitAll()

                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
        ;

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                     //  .allowedOrigins("http://localhost:4200","http://localhost:3200")
                       .allowedOrigins("https://fleurpourtous.com", "https://portail.fleurpourtous.com/")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .maxAge(3600L)
                        .allowedHeaders("*")
                        .exposedHeaders("Authorization")
                        .allowCredentials(true);


            }
        };
    }

}

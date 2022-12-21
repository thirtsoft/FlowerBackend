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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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


                //         .antMatchers("/**/products/create").permitAll()
                //         .antMatchers("/**/products/createWithFile").permitAll()
                //         .antMatchers("/**/products/createWithFilesInFolder").permitAll()
                //         .antMatchers("/**/products/update/{idProduct}").permitAll()

                .antMatchers("/**/products/findById/{idProduct}").permitAll()
                .antMatchers("/**/products/searchProductbyReference/{reference}").permitAll()
                .antMatchers("/**/products/all").permitAll()
                .antMatchers("/**/products/searchAllProductOrderByIdDesc").permitAll()
                .antMatchers("/**/products/productsBySubCategories/{subCatId}").permitAll()
                .antMatchers("/**/products/searchProductByKeyword").permitAll()
                .antMatchers("/**/products/searchTop24ProductByOrder").permitAll()
                .antMatchers("/**/products/searchTop4ProductByOrderIdDesc").permitAll()
                .antMatchers("/**/products/searchProductByPrice/{price}").permitAll()
                .antMatchers("/**/products/searchProductBySelectedIsTrue").permitAll()
                .antMatchers("/**/products/searchProductByPageables").permitAll()
                .antMatchers("/**/products/searchProductBySubcategoryByPageables").permitAll()
                .antMatchers("/**/products/searchProductBySamePriceByPageables/**").permitAll()
                .antMatchers("/**/products/delete/{idProduct}").permitAll()
                .antMatchers("/**/products/photoProduct/{idProduct}").permitAll()
                .antMatchers("/**/products/photoProductInFolder/{idProduct}").permitAll()
                .antMatchers("/**/products/uploadProductPhoto/{idProduct}").permitAll()
                .antMatchers("/**/products/uploadProductPhotoInFolder/{idProduct}").permitAll()
                .antMatchers("/**/products/countNumberTotalOfProducts").permitAll()

                .antMatchers("/**/products/searchAllProductsByPageable").permitAll()
                .antMatchers("/**/products/searchAllProductsBySubCategoryByPageable").permitAll()
                .antMatchers("/**/products/searchAllProductsByKeywordByPageable").permitAll()
                .antMatchers("/**/products/productSize").permitAll()
                .antMatchers("/**/products/productSizeBySubCategoryId").permitAll()
                .antMatchers("/**/products/productSizeByKeyword").permitAll()
                .antMatchers("/**/products/searchTop3ProductByOrderIdDesc").permitAll()
                .antMatchers("/**/products/searchTop8ProductByOrderIdDesc").permitAll()

                .antMatchers("/**/subcategories/create").permitAll()
                .antMatchers("/**/subcategories/update/*").permitAll()
                .antMatchers("/**/subcategories/findById/{subCatId}").permitAll()
                .antMatchers("/**/subcategories/searchSubcategoryByCategoryId/{catId}").permitAll()
                .antMatchers("/**/subcategories/all").permitAll()
                .antMatchers("/**/subcategories/searchAllSubCategoriesOrderByIdDesc").permitAll()
                .antMatchers("/**/subcategories/delete/*").permitAll()

                .antMatchers("/**/categories/create").permitAll()
                .antMatchers("/**/categories/update/{catId}").permitAll()
                .antMatchers("/**/categories/findById/{catId}").permitAll()
                .antMatchers("/**/categories/searchCategoryByCode/*").permitAll()
                .antMatchers("/**/categories/searchCategoryByDesignation/*").permitAll()
                .antMatchers("/**/categories/all").permitAll()
                .antMatchers("/**/categories/searchAllCategoriesOrderByIdDesc").permitAll()
                .antMatchers("/**/categories/searchListCategoriesByCode/*").permitAll()
                .antMatchers("/**/categories/delete/{catId}").permitAll()

                .antMatchers("/**/orders/create").permitAll()
                .antMatchers("/**/orders/findById/{idOrder}").permitAll()
                .antMatchers("/**/orders/all").permitAll()
                .antMatchers("/**/orders/searchAllOrdersOrderByIdDesc").permitAll()
                .antMatchers("/**/orders/findListOrderByStatuePending").permitAll()
                .antMatchers("/**/orders/findListOrderByStatuePayed").permitAll()
                .antMatchers("/**/orders/searchOrderByUserIdOrderByIdDesc/*").permitAll()
                .antMatchers("/**/orders/searchOrderByBillingAddressIdDesc/*").permitAll()
                .antMatchers("/**/orders/searchOrderByShippingAddressIdDesc/*").permitAll()
                .antMatchers("/**/orders/countNumberOfOrdersByPendingStatus").permitAll()
                .antMatchers("/**/orders/searchOrderByCustomerByPageables/***").permitAll()
                .antMatchers("/**/orders/searchOrderByUtilisateurByPageables/***").permitAll()
                .antMatchers("/**/orders/countNumberOfOrder").permitAll()
                .antMatchers("/**/orders/sumTotalOfOrderByDay").permitAll()
                .antMatchers("/**/orders/sumTotalOfOrderByMonth").permitAll()
                .antMatchers("/**/orders/sumTotalOfOrderByYear").permitAll()
                .antMatchers("/**/orders/numberOfOrderByMonth").permitAll()
                .antMatchers("/**/orders/countNumberOfOrdersInMonth").permitAll()
                .antMatchers("/**/orders/sumTotaleOfOrderByMonthByList").permitAll()
                .antMatchers("/**/orders/sumTotaleOfOrderByYearList").permitAll()
                .antMatchers("/**/orders/updateStatusOfOrder/*").permitAll()
                .antMatchers("/**/orders/update/*").permitAll()

                .antMatchers("/**/orderItems/create").permitAll()
                .antMatchers("/**/orderItems/findById/{idOrderItem}").permitAll()
                .antMatchers("/**/orderItems/all").permitAll()
                .antMatchers("/**/orderItems/searchAllOrderItemsByOrderId/{comId}").permitAll()

                .antMatchers("/**/orderItems/searchAllOrderItemOrderByIdDesc").permitAll()
                .antMatchers("/**/orderItems/findAllOrderItemsGroupByIdDesc").permitAll()
                .antMatchers("/**/orderItems/searchTop200OrderItemsOrderByIdDesc").permitAll()
                .antMatchers("/**/orderItems/searchTop8OrderItemsOrderByIdDesc").permitAll()
                .antMatchers("/**/orderItems/searchTop3OrderItemsOrderByIdDesc").permitAll()
                .antMatchers("/**/orderItems/delete/{idOrderItem}").permitAll()


                //        .antMatchers("/**/checkout/placeToOrder").permitAll()
                //        .antMatchers("/**/checkout/placeToOrderWithUser/**").permitAll()

                .antMatchers("/**/checkout/placeToOrderWithLoginUser/**").permitAll()

                .antMatchers("/**/clients/create").permitAll()
                .antMatchers("/**/clients/findById/*").permitAll()
                .antMatchers("/**/clients/all").permitAll()
                .antMatchers("/**/clients/searchAllClientsOrderByIdDesc").permitAll()
                .antMatchers("/**/clients/countNumberOfClient").permitAll()
                .antMatchers("/**/clients/delete/{idClient}").permitAll()

                .antMatchers("/**/fournisseurs/create").permitAll()
                .antMatchers("/**/fournisseurs/findById/*").permitAll()
                .antMatchers("/**/fournisseurs/update/{idFournisseur}").permitAll()
                .antMatchers("/**/fournisseurs/all").permitAll()
                .antMatchers("/**/fournisseurs/searchAllFournisseurOrderByIdDesc").permitAll()
                .antMatchers("/**/fournisseurs/countNumberOfFournisseur").permitAll()
                .antMatchers("/**/fournisseurs/delete/*").permitAll()

                .antMatchers("/**/blogs/findById/{blogId}").permitAll()
                .antMatchers("/**/blogs/all").permitAll()
                .antMatchers("/**/blogs/searchAllBlogsOrderByIdDesc").permitAll()

                .antMatchers("/**/addresses/create").permitAll()
                .antMatchers("/**/addresses/findById/{addId}").permitAll()
                .antMatchers("/**/addresses/update/{addId}").permitAll()
                .antMatchers("/**/addresses/all").permitAll()
                .antMatchers("/**/addresses/searchAllAddressOrderByIdDesc").permitAll()
                .antMatchers("/**/addresses/delete/{addId}").permitAll()

                .antMatchers("/**/countries/create").permitAll()
                .antMatchers("/**/countries/update/{idCountry}").permitAll()
                .antMatchers("/**/countries/all").permitAll()
                .antMatchers("/**/countries/findById/{idCountry}").permitAll()
                .antMatchers("/**/countries/searchAllCountriesOderByIdDesc").permitAll()
                .antMatchers("/**/countries/delete/{idCountry}").permitAll()

                .antMatchers("/**/states/create").permitAll()
                .antMatchers("/**/states/update/{stateId}").permitAll()
                .antMatchers("/**/states/findById/{stateId}").permitAll()
                .antMatchers("/**/states/all").permitAll()
                .antMatchers("/**/states/searchAllStatesOrderByIdDesc").permitAll()
                .antMatchers("/**/states/searchStateByCountryCode/**").permitAll()
                .antMatchers("/**/states/delete/{stateId}").permitAll()

                .antMatchers("/**/wishlists/create").permitAll()
                .antMatchers("/**/wishlists/update/{idWishlist}").permitAll()
                .antMatchers("/**/wishlists/findById/{idWishlist}").permitAll()
                .antMatchers("/**/wishlists/all").permitAll()
                .antMatchers("/**/wishlists/delete/{idWishlist}").permitAll()

                .antMatchers("/**/ratings/create").permitAll()
                .antMatchers("/**/ratings/createRatingToArticle").permitAll()
                .antMatchers("/**/ratings/findById/{idRating}").permitAll()
                .antMatchers("/**/ratings/all").permitAll()
                .antMatchers("/**/ratings/searchAllRatingsOrderByIdDesc").permitAll()
                .antMatchers("/**/ratings/countNumberOfRating").permitAll()
                .antMatchers("/**/ratings/countNumberOfRatingByProductId/{idProd}").permitAll()
                .antMatchers("/**/ratings/createRatingToArticleWithUser/**").permitAll()
                .antMatchers("/**/ratings/searchTop3RatingOrderByCreatedDateDesc").permitAll()
                .antMatchers("/**/ratings/searchTop4RatingOrderByCreatedDateDescByProductId/{idProd}").permitAll()
                .antMatchers("/**/ratings/delete/{idRating}").permitAll()

                .antMatchers("/**/newsletters/create").permitAll()
                .antMatchers("/**/newsletters/findById/{idNewsletter}").permitAll()
                .antMatchers("/**/newsletters/countNumberOfNewsletters").permitAll()
                .antMatchers("/**/newsletters/searchAllNewslettersOrderByIdDesc").permitAll()
                .antMatchers("/**/newsletters/delete/{idNewsletter}").permitAll()

                .antMatchers("/**/emails/all").permitAll()
                .antMatchers("/**/emails/findById/*").permitAll()
                .antMatchers("/**/emails/searchAllEmailssOrderByIdDesc").permitAll()

                .antMatchers("/**/emails/sendEmail").permitAll()
                .antMatchers("/**/emails/sendToFournisseur").permitAll()
                .antMatchers("/**/emails/sendToNewsletter").permitAll()
                .antMatchers("/**/emails/sendMailToAllCustomers").permitAll()
                .antMatchers("/**/emails/sendMailToManager").permitAll()
                .antMatchers("/**/emails/findById/{idEmail}").permitAll()
                .antMatchers("/**/emails/searchAllEmailsOrderByIdDesc").permitAll()
                .antMatchers("/**/emails/countNumberOfEmail").permitAll()
                .antMatchers("/**/emails/delete/{idEmail}").permitAll()

                .antMatchers("/**/utilisateurs/all").permitAll()
                .antMatchers("/**/utilisateurs/findById/{idUtilisateur}").permitAll()
                .antMatchers("/**/utilisateurs/update/{idUser}").permitAll()
                .antMatchers("/**/utilisateurs/avatar/{id}").permitAll()
                .antMatchers("/**/utilisateurs/uploadUserPhoto/{id}").permitAll()
                .antMatchers("/**/utilisateurs/*").permitAll()
                .antMatchers("/**/utilisateurs/updateCustomerProfileByUsername").permitAll()
                .antMatchers("/**/utilisateurs/countNumberOfRegisterInMonth").permitAll()
                .antMatchers("/**/utilisateurs/countNumberOfRegisterPeerMonth").permitAll()

                .antMatchers("/**/historiqueCommandes/searchAllHistoriqueCommandesOrderByIdDesc").permitAll()
                .antMatchers("/**/historiqueCommandes/delete/{idHistCom}").permitAll()
                .antMatchers("/**/historiqueLogins/searchAllHistoriqueLoginsOrderByIdDesc").permitAll()
                .antMatchers("/**/historiqueLogins/delete/{idHistLog}").permitAll()

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
                        //  .allowedOrigins("**")
                        //        .allowedOrigins("http://localhost:4200","http://localhost:3200")
                        .allowedOrigins("https://fleurpourtous.com", "https://portail.fleurpourtous.com")
                    //    .allowedOrigins("https://fleurpourtous.com")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .maxAge(3600L)
                        .allowedHeaders("*")
                        .exposedHeaders("Authorization")
                        .allowCredentials(true);


            }
        };
    }

}

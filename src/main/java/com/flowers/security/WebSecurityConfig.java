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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static com.flowers.utils.Constants.APP_ROOT;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
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
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");

            }
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/**/auth/signUp").permitAll()
                .antMatchers("/**/auth/registerUser").permitAll()
                .antMatchers("/**/auth/authenticated").permitAll()

                .antMatchers("/**/products/createWithFile/**").permitAll()
                .antMatchers("/**/products/update/{idProduct}").permitAll()
                .antMatchers("/**/products/findById/{idProduct}").permitAll()
                .antMatchers("/**/products/searchProductbyReference/{reference}").permitAll()
                .antMatchers("/**/products/all").permitAll()
                .antMatchers("/**/products/productsByScategories/{subCatId}").permitAll()
                .antMatchers("/**/products/searchProductByKeyword/*").permitAll()
                .antMatchers("/**/products/searchProductbyReference/{reference}").permitAll()
                .antMatchers("/**/products/productsByScategories/{subCatId}").permitAll()
                .antMatchers("/**/products/searchProductByKeyword/*").permitAll()
                .antMatchers("/**/products/searchProductByPrice/{price}").permitAll()
                .antMatchers("/**/products/searchProductByselectedIsTrue").permitAll()
                .antMatchers("/**/products/searchProductByPageables/**").permitAll()
                .antMatchers("/**/products/searchProductBySubcategoryByPageables/**").permitAll()
                .antMatchers("/**/products/searchProductBySamePriceByPageables/**").permitAll()
                .antMatchers("/**/products/delete/{idProduct}").permitAll()
                .antMatchers("/**/products/photoProduct/{idProduct}").permitAll()
                .antMatchers("/**/products/uploadProductPhoto/{idProduct}").permitAll()

                .antMatchers("/**/subcategories/all").permitAll()
                .antMatchers("/**/subcategories/findById/{subCatId}").permitAll()
                .antMatchers("/**/subcategories/searchSubcategoryByCategoryId/{catId}").permitAll()

                .antMatchers("/**/categories/findById/{catId}").permitAll()
                .antMatchers("/**/categories/searchCategoryByCode/*").permitAll()
                .antMatchers("/**/categories/searchCategoryByDesignation/*").permitAll()
                .antMatchers("/**/categories/all").permitAll()
                .antMatchers("/**/categories/searchListCategoriesByCode/*").permitAll()

                .antMatchers("/**/states/findById/{stateId}").permitAll()
                .antMatchers("/**/states/all").permitAll()
                .antMatchers("/**/states/searchStateByCountryCode?{code}").permitAll()
                .antMatchers("/**/countries/all").permitAll()

                .antMatchers("/**/checkout/placeToOrderWithLoginUser/*").permitAll()
                .antMatchers("/**/checkout/placeToOrder").permitAll()
                .antMatchers("/**/checkout/placeToOrderWithUser/{id}").permitAll()
                .antMatchers("/**/checkout/purchase").permitAll()

                .antMatchers("/**/blogs/findById/{blogId}").permitAll()
                .antMatchers("/**/blogs/all").permitAll()
                .antMatchers("/**/blogs/searchAllBlogsOrderByIdDesc").permitAll()

                .antMatchers("/**/addresses/create").permitAll()
                .antMatchers("/**/addresses/findById/{addId}").permitAll()
                .antMatchers("/**/addresses/update/{addId}").permitAll()

                .antMatchers("/**/orders/create").permitAll()
                .antMatchers("/**/orders/findById/{idOrder}").permitAll()
                .antMatchers("/**/orders/all").permitAll()
                .antMatchers("/**/orders/searchOrderByCustomerByPageables/**").permitAll()
                .antMatchers("/**/orders/searchOrderByUtilisateurByPageables/**").permitAll()

                .antMatchers("/**/emails/sendMailToManager").permitAll()

                .antMatchers("/**/newsletters/create").permitAll()

                .antMatchers("/**/orderItems/create").permitAll()
                .antMatchers("/**/orderItems/findById/{idOrderItem}").permitAll()
                .antMatchers("/**/orderItems/all").permitAll()

                .antMatchers("/**/wishlists/create").permitAll()
                .antMatchers("/**/wishlists/update/{idWishlist}").permitAll()
                .antMatchers("/**/wishlists/findById/{idWishlist}").permitAll()
                .antMatchers("/**/wishlists/all").permitAll()
                .antMatchers("/**/wishlists/delete/{idWishlist}").permitAll()


                .antMatchers("/**/lignecommandes/all").permitAll()
                .antMatchers("/**/lignecommandes/searchAllLigneCommandeOrderByIdDesc").permitAll()
                .antMatchers("/**/lignecommandes/findListArticleGroupByIdDesc").permitAll()
                .antMatchers("/**/lignecommandes/searchAllLigneCommandesByCommandeId/*").permitAll()
                .antMatchers("/**/lignecommandes/searchTopLigneCommandesOrderByIdDesc").permitAll()
                .antMatchers("/**/lignecommandes/findListArticleGroupByIdDesc").permitAll()
                .antMatchers("/**/scategories/all").permitAll()
                .antMatchers("/**/states/all").permitAll()
                .antMatchers("/**/states/searchStateByCountryCode/**").permitAll()
                .antMatchers("/**/utilisateurs/all").permitAll()
                .antMatchers("/**/utilisateurs/findById/{idUtilisateur}").permitAll()
                .antMatchers("/**/utilisateurs/update/{idUser}").permitAll()
                .antMatchers("/**/utilisateurs/avatar/{id}").permitAll()
                .antMatchers("/**/utilisateurs/uploadUserPhoto/{id}").permitAll()
                .antMatchers("/**/utilisateurs/*").permitAll()
                .antMatchers("/**/utilisateurs/updateCustomerProfileByUsername").permitAll()
                .antMatchers("/**/clients/**").permitAll()
                .antMatchers("/**/clients/countNumberOfClient").permitAll()
                .antMatchers("/**/notifications/**").permitAll()
                .antMatchers("/**/notifications/all").permitAll()
                .antMatchers("/**/notifications/countNumberOfNotification").permitAll()
                .antMatchers("/**/notifications/createRatingToArticle/**").permitAll()
                .antMatchers("/**/notifications/searchTop3RatingOrderByCreatedDateDesc").permitAll()

                .antMatchers("/**/notifications/countNumberOfNotificationByProductId/{idProd}").permitAll()
                .antMatchers("/**/notifications/searchTop4RatingOrderByCreatedDateDescByProductId/{idProd}").permitAll()

                .antMatchers("/**/addresslivraisons/all").permitAll()
                .antMatchers("/**/addresslivraisons/searchAllAddressLivraisonsOrderByIdDesc").permitAll()

                .antMatchers("/**/addresseclients/searchAllAddressClientsOrderByIdDesc").permitAll()


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
                .antMatchers("/**/historiqueLogins/searchAllHistoriqueLoginsOrderByIdDesc").permitAll()

                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}

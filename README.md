## 🚀 CSRF (cross site reuest frogery)

when we create our backend server and api it must be very secure..Also login using our credentials it can authorize to our application.
but the case is when we log in it has a ``session id`` to recognize the user is logged and authorize to accesible pages.But some malicious websites or hackers can get the session id and acess without using creadentials it can be cause to the data intergrity.

in spring security it enable the csrf token to access ``HTTP Request`` (put ,post,delete and other)  but by default GET request do not have csrf token because it only get the data from database..


``` @GetMapping("/token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
       return (CsrfToken) request.getAttribute("_csrf");

    } 
```
#### 🎆 In Above code snippet show how to get CsRF Token .
now how can we add in headers section we can add  header name `X-CSRF-TOKEN ` and value  ` value of the token`


### 💻 Next Method we can do one thing for this session id .. we can say the session id does not allowd to access another sites..
    For that we can say SAME SITE STRICT - Do not allow to any other site for our session id
we can do this thing also for securty.

For this we can enabled the configuration jav class and ..create like below code snippet..
 - this is only first configuration.Creating a java class and make simple configuration
   ```
   @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            return http.build();
        }
    }

   ```

-:accessibility: Now Disabling CSRF (but use basic auth)

  ```
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session->session.
                sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
        }
    }
  ```

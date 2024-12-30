# Spring-Security
### Project: Spring Security with JWT Authentication  

This project demonstrates a comprehensive implementation of **Spring Security** to secure a REST API, focusing on authentication and authorization using **JWT (JSON Web Token)**. It covers various aspects of modern application security, including password management, token generation, and validation.

---

#### 🔐 **Key Features**  
1. **Password Management**:
   - Storing credentials in `application.properties`.
   - Securely managing credentials in the database.
   - Encoding passwords using `BCryptPasswordEncoder`.

2. **JWT Implementation**:
   - Generating JWT tokens based on the username during login.
   - Validating JWT tokens for subsequent requests.
   - Extracting and verifying claims from the token.

3. **Authentication and Authorization**:
   - Configured **HttpSecurity** to define security chains.
   - Added CSRF protection using `SecurityFilterChain`.
   - Implemented **HTTP Basic Authentication** with DAO-based authentication provider.

4. **Security Filter**:
   - Added a custom `JwtFilter` extending `OncePerRequestFilter` to validate each request's token.
   - Managed the security context using `SecurityContextHolder`.

---

#### 🛠 **Core Components**  
- **Configuration**:
  - `SecurityConfig`: Enables web security.
  - `SecurityFilterChain`: Customizes security filters and chains.
  - `AuthenticationManager` & `DaoAuthenticationProvider`: Configures authentication and password encoding with `BCryptPasswordEncoder`.

- **Services**:
  - `UserDetailsService`: Retrieves user information from the database.
  - `JwtService`: Handles token generation, validation, expiration checks, and extraction of user details.

- **Entities**:
  - `UserDetails`: Stores user credentials and roles.

- **Utilities**:
  - `UsernamePasswordAuthenticationToken`: For managing authentication context.
  - `HttpServletRequest` & `HttpServletResponse`: For handling requests and responses.
  - `SecurityContextHolder`: Manages security context for the application.

---

#### 📌 **Tools & Libraries Used**  
- **Spring Boot**: For application development.
- **Spring Security**: For authentication and authorization.
- **JWT**: For stateless authentication.
- **BCryptPasswordEncoder**: For secure password encoding.

---

#### 🚀 **How It Works**  
1. **User Login**:
   - The username and password are validated against the database.
   - A JWT token is generated and returned to the user.

2. **Authenticated Requests**:
   - For each API call, the `JwtFilter` verifies the token.
   - Valid tokens grant access, while invalid tokens reject the request.

3. **Token Management**:
   - Tokens include claims such as username and expiration.
   - The application ensures tokens are secure and cannot be reused after expiration.

---

#### 📝 **Learning Outcomes**  
This project is a hands-on guide for:
- Implementing **Spring Security** with modern best practices.
- Understanding **JWT-based authentication** in REST APIs.
- Managing passwords securely with **BCryptPasswordEncoder**.
- Customizing security chains and filters in a Spring application.

Check out the repository for the complete implementation! 😊

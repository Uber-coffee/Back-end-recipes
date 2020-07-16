# Back-end-recipes

Firstly, you must download GlobalProtect and connect to EPAM's VPN.  
After that you may find all endpoints and their requests and responses structure on this page:   
http://ecse005008ef.epam.com:8080/swagger/menu/swagger-ui.html#  
  
For all web requests required JWT token with assigned admin role.   
For all mobile requests required JWT token with assigned customer role.  
JWT token is the result of an auth request.  
Read more here:  
http://ecse005008ef.epam.com:8080/swagger/auth-mobile/swagger-ui.html  
http://ecse005008ef.epam.com:8080/swagger/auth-web/swagger-ui.html  
You must pass it in the header of a request  

#### CSRF (cross site reuest frogery)

when we create our backend server and api it must be very secure..Also login using our credentials it can authorize to our application.
but the case is when we log in it has a ``session id`` to recognize the user is logged and authorize to accesible pages.But some malicious websites or hackers can get the session id and acess without using creadentials it can be cause to the data intergrity.

in spring security it enable the csrf token to access ``HTTP Request`` (put ,post,delete and other)  but by default GET request do not have csrf token because it only get the data from database..

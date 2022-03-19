Springboot application demonstrating handling of different exceptions thrown in controller using
@ExceptionHandler annotated methods (in the controller).

Three test users hardcoded in UserRepository for testing:

        user = "Vasya"; password = "123" ; Authorities = READ,WRITE
        user ="Masha"; password = "234"; Authorities = READ,WRITE,DELETE
        user = "Grisha"; password = "567"; Authotities = Empty
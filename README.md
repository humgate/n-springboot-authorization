Springboot application implementing the simplest authorization service and demonstrating handling 
of different exceptions thrown in controller using @ExceptionHandler annotated methods.

Three test users hardcoded in UserRepository for testing:

        user = "Vasya"; password = "123" ; Authorities = READ,WRITE
        user ="Masha"; password = "234"; Authorities = READ,WRITE,DELETE
        user = "Grisha"; password = "567"; Authotities = Empty
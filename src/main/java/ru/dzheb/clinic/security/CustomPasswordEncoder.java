package ru.dzheb.clinic.security;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomPasswordEncoder implements PasswordEncoder {
//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
//
//    @Override
//    public String encode(CharSequence rawPassword) {
//        // шифруем пароль сила - 10
//        //user1:$2y$10$whzcH.p7L2BqEr.J4iBuAeXEp8F6zBWS6Dv1DJ/vg0sZD.8/Bf3Gu
//        //admin:$2y$10$uHxtVYB.Fbs.iWqa53Nx3epEPXBavB0ojfXQDKmJSgJQ8F.UUPiXu
//        return String.valueOf(encoder.encode(rawPassword));
//    }
//
//    //    @Override
////    public boolean matches(CharSequence rawPassword, String encodedPassword) {
////        return encode(rawPassword).equals(encodedPassword);
////    }
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return encoder.matches(rawPassword, encodedPassword);
//    }
//
//}

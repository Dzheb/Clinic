package ru.dzheb.clinic.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import ru.dzheb.clinic.model.Role;
//import ru.dzheb.clinic.repository.UserRepository;
//import ru.dzheb.clinic.service.UserService;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    private final UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        ru.dzheb.clinic.model.User user = userService.getUserByLogin(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Такого пользователя нет");
//        }
//        List<Role> roles = user.getRoles();
//        List<SimpleGrantedAuthority> roleList = roles.stream()
//                .map(it -> new SimpleGrantedAuthority(
//                        it.getRole())).toList();
//        return new User(user.getLogin(), user.getPassword(), roleList);
//
//    }
//
//    public ru.dzheb.clinic.model.User getUserByName(String username) {
//        return userRepository.findByLogin(username)
//                .orElseThrow(() -> new UsernameNotFoundException(username));
//    }
//}
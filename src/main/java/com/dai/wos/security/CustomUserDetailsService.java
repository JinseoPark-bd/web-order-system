package com.dai.wos.security;

import com.dai.wos.domain.user.entity.User;
import com.dai.wos.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = repository.findById(username);
        return optionalUser
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));
    }
}

/*
@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO principal = userMapper.selectUser(username);

		return new PrincipalDetail(principal);
	}

}


 */
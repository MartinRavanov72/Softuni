package com.example.demo.services.user;

import com.example.demo.models.dtos.binding.user.UserCreateBindingModel;
import com.example.demo.models.entity.User;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper mapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository,
						   ModelMapper mapper) {
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	public void save(UserCreateBindingModel model) {
		User u = this.mapper.map(model, User.class);
		this.userRepository.saveAndFlush(u);
	}

	@Override
	public void save(Collection<UserCreateBindingModel> models) {
		Type listType = new TypeToken<List<User>>(){}.getType();
		Collection<User> users = this.mapper.map(models,listType);
		this.userRepository.save(users);
	}
}
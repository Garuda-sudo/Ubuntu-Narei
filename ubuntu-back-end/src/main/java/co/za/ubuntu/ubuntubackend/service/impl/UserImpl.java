package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.Transaction;
import co.za.ubuntu.model.TransactionResponse;
import co.za.ubuntu.model.User;
import co.za.ubuntu.ubuntubackend.persistence.entity.TransactionEntity;
import co.za.ubuntu.ubuntubackend.persistence.entity.UserEntity;
import co.za.ubuntu.ubuntubackend.persistence.repository.AccountRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.TransactionRepository;
import co.za.ubuntu.ubuntubackend.persistence.repository.UserRepository;
import co.za.ubuntu.ubuntubackend.service.TransactionService;
import co.za.ubuntu.ubuntubackend.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserImpl implements UserService {

    UserRepository userRepository;


    @Override
    public User createUser(User userDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userEntity.getName());
        userEntity.setSurname(userEntity.getSurname());
        userEntity.setEmail(userEntity.getEmail());
        userEntity.setUsername(userEntity.getUsername());

        return domainToDTO(userRepository.save(userEntity));
    }

    @Override
    public User getUser(Integer userId) {

        UserEntity userEntity = userRepository.findById(userId).orElseThrow();

        return domainToDTO(userEntity);
    }

    private User domainToDTO(UserEntity userEntity) {

        User user = new User();
        user.setId(userEntity.getId().longValue());
        user.setName(userEntity.getName());
        user.setSurname(userEntity.getSurname());
        user.setEmail(userEntity.getEmail());
        user.setUsername(userEntity.getUsername());

        return user;
    }
}

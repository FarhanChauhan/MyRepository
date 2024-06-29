package in.ineuron.farhan.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.farhan.dao.UserRepository;
import in.ineuron.farhan.exception.UserNotFoundExcepton;
import in.ineuron.farhan.model.User;

@Service("service2")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getAllUser() {
		return (List<User>) repo.findAll();
	}

	@Override
	public User saveUser(User User) {
		return repo.save(User);
	}

	@Override
	public User getUserById(Long id) {
		User User =repo.findById(id).orElseThrow(()-> new UserNotFoundExcepton(
			"User does not exists with the id : "+id));
		return User;
	}
	
	@Override
	public void deleteUserById(Long id) {
		User User = repo.findById(id)
				.orElseThrow(() ->
				new UserNotFoundExcepton("Record not exists with the id:: " + id));
		repo.delete(User);
	}
	
    public String generateReferralCode() {
        UUID uuid = UUID.randomUUID();
        String referralCode = uuid.toString().replaceAll("-", "").substring(0, 8);
        return referralCode.toUpperCase(); // convert to uppercase for readability
    }
	
}

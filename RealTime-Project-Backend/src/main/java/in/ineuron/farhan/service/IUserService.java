package in.ineuron.farhan.service;

import java.util.List;

import in.ineuron.farhan.model.User;

public interface IUserService {

	public List<User> getAllUser();
	public User saveUser(User User);
	public User getUserById(Long id);
	public void deleteUserById(Long id);
	public String generateReferralCode();
}

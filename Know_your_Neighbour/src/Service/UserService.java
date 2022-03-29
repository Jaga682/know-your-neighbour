package Service;

import Model.Userbean;

public interface UserService {
	public void addUserdata(Userbean userbean);
	public boolean loginuser(Userbean userbean);

}

package Service;

import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserService {


    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public void save(User a){
        repository.save(a);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

//    public List<User> listAll(){
//        return repository.findAll();
//    }
    public User findById(Long id){
        return repository.getById(id);
    }

    public void deletedtrue(Long id){
        repository.deleteById(id);
    }

    public UserRepository getRepository(){
        return repository;
    }


}

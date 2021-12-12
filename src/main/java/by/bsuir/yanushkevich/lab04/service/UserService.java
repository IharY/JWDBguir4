package by.bsuir.yanushkevich.lab04.service;

import by.bsuir.yanushkevich.lab04.entity.User;
import by.bsuir.yanushkevich.lab04.exception.RepositoryException;
import by.bsuir.yanushkevich.lab04.exception.ServiceException;
import by.bsuir.yanushkevich.lab04.repository.creator.RepositoryCreator;
import by.bsuir.yanushkevich.lab04.repository.impl.UserRepository;
import by.bsuir.yanushkevich.lab04.specification.common.FindById;
import by.bsuir.yanushkevich.lab04.specification.user.FindByUsername;
import by.bsuir.yanushkevich.lab04.specification.user.FindByUsernameAndPassword;

import java.util.Optional;

public class UserService {

    public Optional<User> findByUsernameAndPassword(String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsernameAndPassword(username, password));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public Optional<User> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public Optional<User> findByUsername(String username) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsername(username));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void signUpUser(Integer id, String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, username, password);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

}

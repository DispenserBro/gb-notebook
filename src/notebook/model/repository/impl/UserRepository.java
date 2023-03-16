package notebook.model.repository.impl;

import notebook.model.dao.impl.FileOperation;
import notebook.util.mapper.impl.UserMapper;
import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements GBRepository<User, Long> {
    private final UserMapper mapper;
    private final FileOperation operation;

    public UserRepository(FileOperation operation) {
        this.mapper = new UserMapper();
        this.operation = operation;
    }

    @Override
    public List<User> findAll() {
        List<String> lines = operation.readAll();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.toOutput(line));
        }
        return users;
    }

    @Override
    public User create(User user) {
        List<User> users = findAll();
        long max = 0L;
        for (User u : users) {
            long id = u.getId();
            if (max < id){
                max = id;
            }
        }
        long next = max + 1;
        user.setId(next);
        users.add(user);
        List<String> lines = new ArrayList<>();
        for (User u: users) {
            lines.add(mapper.toInput(u));
        }
        operation.saveAll(lines);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(Long id, User update) {
        try {
            List<User> users = findAll();
            User userToUpdate = users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
            userToUpdate.setFirstName(update.getFirstName());
            userToUpdate.setLastName(update.getLastName());
            userToUpdate.setPhone(update.getPhone());
            List<String> usersOutput = new ArrayList<>();
            for (User user : users) {
                usersOutput.add(this.mapper.toInput(user));
            }
            operation.saveAll(usersOutput);
            return Optional.of(userToUpdate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

}

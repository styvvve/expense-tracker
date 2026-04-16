package expenseManager.infrastructures.repos;

import Errors.NoFileDetected;
import expenseManager.domain.interfaces.UserRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import expenseManager.domain.user.User;
import expenseManager.infrastructures.persistence.JacksonConfig;

public class JsonUserRepository implements UserRepository {

    private final Path path;
    private final ObjectMapper om;

    public JsonUserRepository(Path path) {
        this.path = path;
        this.om = JacksonConfig.getObjectMapper();
    }

    @Override
    public void save(User user) {
        try {
            Path parentDir = path.getParent();

            if (parentDir != null && Files.notExists(parentDir)) {
                Files.createDirectories(parentDir);
            }

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                om.writeValue(writer, user);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to save user json file to : " + path, e);
        }
    }

    @Override
    public User load() throws NoFileDetected {
        try {
            if (Files.notExists(path)) {
                throw new NoFileDetected("No file at " + path.toString());
            }

            try (BufferedReader reader = Files.newBufferedReader(path)) {
                return om.readValue(reader, User.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to load user json file from : " + path, e);
        }
    }
}

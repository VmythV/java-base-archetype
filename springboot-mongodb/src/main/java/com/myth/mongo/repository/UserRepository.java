package com.myth.mongo.repository;


import com.myth.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findUserById(Long id);
    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     */
    User findByName(String name);
}





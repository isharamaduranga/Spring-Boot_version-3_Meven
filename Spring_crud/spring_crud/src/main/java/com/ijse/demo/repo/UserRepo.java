package com.ijse.demo.repo;

import com.ijse.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM User WHERE id =?1",nativeQuery = true)
    User getUserByUserId(int userId);

    @Query(value = "SELECT * FROM User WHERE name =?1 AND address=?2  ",nativeQuery = true)
    User getUserByNameAndAddress(String name,String address);


}

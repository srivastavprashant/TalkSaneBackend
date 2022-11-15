package com.talksane.chat.TalkSane.repository;


import com.talksane.chat.TalkSane.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);


    String getUserByUsername = "SELECT id,cast(aes_decrypt(Unhex(username),'Secret Key')as char) as username,cast(aes_decrypt(Unhex(password),'Secret Key')as char) as password,email FROM talksane_uat.user_database where username=HEX(AES_ENCRYPT(?1,'Secret Key'));";

    @Query(nativeQuery = true, value = getUserByUsername)
    public User getUserByUsername(String username);

}
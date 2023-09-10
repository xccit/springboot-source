package io.xccit.repository;

import io.xccit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author CH_ywx
 * @date 2023-08-09
 * @description UserDao  泛型:实体  主键类型
 */
public interface IUserRepository extends JpaRepository<User,Integer> {

}

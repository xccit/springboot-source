package io.xccit.controller;

import io.xccit.entity.User;
import io.xccit.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CH_ywx
 * @date 2023-08-09
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    /**
     * 查询列表
     * @return
     */
    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }

    /**
     * 根据ID查询单个
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User selectUserByID(@PathVariable Integer id){
        return userRepository.getById(id);
    }

    /**
     * 添加
     * @param user
     * @return
     */
    @PostMapping
    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @PutMapping
    public User updateUser(User user){
        return userRepository.saveAndFlush(user);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public String deleteUser(@PathVariable List<Integer> ids){
        userRepository.deleteAllById(ids);
        return "删除成功";
    }
}

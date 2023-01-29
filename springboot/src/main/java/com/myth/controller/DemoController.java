package com.myth.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author may
 */
@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/init")
    public Object init() {
        return "Hello World! 你好！";
    }

    @PutMapping("/insert")
    public Object put(@RequestBody User user) {
        return user.toString();
    }

    @PostMapping("/update")
    public Object insert(@RequestBody User user) {
        return user.toString();
    }

    @DeleteMapping ("/del")
    public Object del(@RequestParam Integer id) {
        return id + "号用户已被删除";
    }

    static class User {
        private String name;
        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name) && Objects.equals(age, user.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

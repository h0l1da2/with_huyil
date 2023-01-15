package com.with.hyuil.config;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.model.enumaration.Role;
import com.with.hyuil.model.enumaration.Wheres;
import com.with.hyuil.model.users.AdminVo;
import com.with.hyuil.model.users.UsersVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@Slf4j
@SpringBootTest
class MyBatisTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    void insertUser() {
        UsersVo usersVo = new UsersVo(
                "asdf","asdf","asd@asd.com","asdf","asdf",
                Wheres.WITH_HYUIL, Role.USER, null);
        int result = usersMapper.insertUser(usersVo);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void insertAdmin() {
        AdminVo adminVo = new AdminVo("asdf", "asdf", "aas");
        int result = usersMapper.insertAdmin(adminVo);
        assertThat(result).isEqualTo(1);
    }

}
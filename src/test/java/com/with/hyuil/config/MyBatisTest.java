package com.with.hyuil.config;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.enumaration.Role;
import com.with.hyuil.model.enumaration.Wheres;
import com.with.hyuil.model.AdminVo;
import com.with.hyuil.model.UsersVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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
                Wheres.WITH_HYUIL, Role.USER);
        int result = usersMapper.insertUser(usersVo);
        assertThat(result).isEqualTo(1);

    }

    @Test
    void insertAdmin() {
        AdminVo adminVo = new AdminVo("asdf", "asdf", "aas");
        int result = usersMapper.insertAdmin(adminVo);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void insertHost() {
        BusinessVo businessVo = new BusinessVo("1111","1111","농협");
        UsersVo usersVo = new UsersVo(
                "asdf","asdf","asd@asd.com","asdf","asdf",
                Wheres.WITH_HYUIL, Role.HOST);
        int i = usersMapper.insertBusiness(businessVo);
        Map map = new HashMap();
        map.put("account", "1111");

        BusinessVo businessVo1 = usersMapper.selectBusiness(map);
        log.info("비즈니스 id = {}", businessVo1.getId());
        assertThat(businessVo1).isNotNull();
        assertThat(businessVo1.getAccount()).isEqualTo(map.get("account"));

        int i1 = usersMapper.insertHost(usersVo);
        assertThat(i1).isEqualTo(1);

    }

}
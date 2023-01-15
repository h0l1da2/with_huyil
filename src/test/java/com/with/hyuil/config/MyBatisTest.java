package com.with.hyuil.config;

import com.with.hyuil.dao.UsersMapper;
import com.with.hyuil.model.Role;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.model.Wheres;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@Transactional
@Slf4j
@SpringBootTest
class MyBatisTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private UsersMapper usersMapper;

    @Test
    void myBatisConnection() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            Connection con = dataSource.getConnection();

            assertThat(con).isNotNull();
            assertThat(session).isNotNull();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void insertUser() {
        UsersVo usersVo = new UsersVo("asdf","asdf","asd@asd.com","asdf","asdf", Wheres.WITH_HYUIL, Role.USER);
        usersMapper.insertUser(usersVo);
    }

}
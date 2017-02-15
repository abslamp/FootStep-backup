package demo.domain;

import org.apache.ibatis.annotations.*;

/**
 * Created by new on 17-2-15.
 */
public interface UserMapper {

    /*
        #{name}         对应数据库的列
        @Param("name")  对应java类中的变量
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    /*
        #{name} 与 #{age}
        默认为User类中的变量
    */
    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

}


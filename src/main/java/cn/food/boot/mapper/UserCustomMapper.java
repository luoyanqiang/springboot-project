package cn.food.boot.mapper;

import cn.food.boot.po.UserQueryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserCustomMapper {

    public List getUserOrders(UserQueryVo userQueryVo);

    @Update("update user set username = #{newName} where username like '%${oldName}%'")
    int updateByExample(@Param("newName") String newName, @Param("oldName") String oldName);

}

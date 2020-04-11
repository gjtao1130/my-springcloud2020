package com.sky.cloud2020.mapper;

import com.sky.cloud2020.entity.Payment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaymentMapper {
    @Insert("insert into payment(id,serial) values(#{id},#{serial})")
    @Options(useGeneratedKeys = true,keyProperty = "id")   //主键自增长
    public int create(Payment payment);

    @Update("update payment set serial=#{serial} where id=#{id}")
    public int updatePaymentById(@Param("id") Long id);

    @Delete("delete payment where id=#{id}")
    public int deletePaymentById(@Param("id") Long id);

    @Select("select id,serial from payment where id=#{id}")
    public Payment getPaymentById(@Param("id") Long id);

    @Select("select id,serial from payment")
    public List<Payment> getPaymentAll();
}

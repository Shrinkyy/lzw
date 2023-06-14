package com.iweb.dao;

import com.iweb.pojo.Partment;

import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/11 16:41
 */
public interface PartmentDao {
    /** 插入一条分类信息
     * @param partment 包含了要添加的分类信息 其中id为空 因为id是自增长的 不需要开发者提供
     */
    void insert(Partment partment);

    /**  根据id修改分类的name属性值
     * @param partment 提供需要被修改的name字段的值 已经根据哪一个id进行update的主键id
     *  update category set name = ? where id = ?
     */
    void update(Partment partment);

    /** 根据id或者name进行删除
     * @param partment 如果提供的id不为空 则根据id删除 如果提供的name不为空 且id为空
     *                 则根据name进行删除 如果name id都为空 可以后续定义一个自定义异常进行抛出
     */
    void delete(Partment partment);

    /** 根据主键id获取指定的分类信息(单个)
     * @param id 要获取的分类的主键id
     * @return 存放了分类信息的Category对象
     */
    Partment get(int id);



    /** 以key作为关键字 对分类进行全模糊的模糊查询 由于是全模糊 查询的时候无法通过索引查询
     * 只能在表数据较少的时候使用
     * @param key 模糊查询的关键字
     * @return 根据关键字进行模糊查询分类的返回结果
     */
    List<Partment> listByNameLike(String key);
}

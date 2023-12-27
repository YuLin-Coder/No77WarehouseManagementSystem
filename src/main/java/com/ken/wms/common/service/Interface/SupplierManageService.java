package com.ken.wms.common.service.Interface;


import com.ken.wms.domain.Supplier;
import com.ken.wms.exception.SupplierManageServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 供应商信息管理 service
 *
 * @author Ken
 */
public interface SupplierManageService {

    /**
     * 返回指定supplierID 的供应商记录
     *
     * @param supplierId 供应商ID
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String, Object> selectById(Integer supplierId) throws SupplierManageServiceException;

    /**
     * 返回指定 supplierName 的供应商记录
     * 支持查询分页以及模糊查询
     *
     * @param offset       分页的偏移值
     * @param limit        分页的大小
     * @param supplierName 供应商的名称
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String, Object> selectByName(int offset, int limit, String supplierName) throws SupplierManageServiceException;

    /**
     * 返回指定 supplierName 的供应商记录
     * 支持模糊查询
     *
     * @param supplierName supplierName 供应商名称
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String, Object> selectByName(String supplierName) throws SupplierManageServiceException;

    /**
     * 分页查询供应商记录
     *
     * @param offset 分页的偏移值
     * @param limit  分页的大小
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String, Object> selectAll(int offset, int limit) throws SupplierManageServiceException;

    /**
     * 查询所有的供应商记录
     *
     * @return 结果的一个Map，其中： key为 data 的代表记录数据；key 为 total 代表结果记录的数量
     */
    Map<String, Object> selectAll() throws SupplierManageServiceException;

    /**
     * 添加供应商记录
     *
     * @param supplier 供应商信息
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    boolean addSupplier(Supplier supplier) throws SupplierManageServiceException;

    /**
     * 更新供应商记录
     *
     * @param supplier 供应商信息
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    boolean updateSupplier(Supplier supplier) throws SupplierManageServiceException;

    /**
     * 删除供应商记录
     *
     * @param supplierId 供应商ID
     * @return 返回一个boolean值，值为true代表更新成功，否则代表失败
     */
    boolean deleteSupplier(Integer supplierId);

    /**
     * 从文件中导入供应商信息
     *
     * @param file 导入信息的文件
     * @return 返回一个Map，其中：key为total代表导入的总记录数，key为available代表有效导入的记录数
     */
    Map<String, Object> importSupplier(MultipartFile file);

    /**
     * 导出供应商信息到文件中
     *
     * @param suppliers 包含若干条 Supplier 信息的 List
     * @return excel 文件
     */
    File exportSupplier(List<Supplier> suppliers);
}

package com.windcloud.windupmsbiz.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.windcloud.windupmsbiz.service.ISysDepartmentService;

/**
 * <p>
 * 前端控制器
 * </p>
 * file:SysDepartmentController.js
 * created by Fanghonghui on 2019-09-12
 * email:a6551142@163.com
 */
@Slf4j
@RestController
@RequestMapping("/sys_department")
@AllArgsConstructor
@Api(value = "sys_department控制器", description = "sys_department管理")
public class SysDepartmentController {

    private ISysDepartmentService iservice;

    /**
     * 查询所有记录
     *
     * @return
     */
    @PostMapping("/list")
    public List<SysDepartment> list() {
        return iservice.list();
    }

    /**
     * 根据ID获取详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public SysDepartment find(@PathVariable("id") Long id) {
        return iservice.getById(id);
    }

    /**
     * 保存
     *
     * @param customer
     * @return
     */
    @PostMapping("/save")
    public boolean save(@RequestBody SysDepartment customer) {
        return iservice.save(customer);
    }

    /**
     * 更新
     *
     * @param customer
     * @return
     */
    @PutMapping("/update")
    public boolean update(@RequestBody SysDepartment customer) {
        return iservice.updateById(customer);
    }

    /**
     * 根据ID删除 逻辑删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return iservice.removeById(id);
    }

    /**
     * 查询列表分页
     *
     * @param page
     * @return
     */
    @GetMapping("/page")
    public IPage page(Page page) {
        return iservice.page(page, Wrappers.<SysDepartment>lambdaQuery());
    }
}
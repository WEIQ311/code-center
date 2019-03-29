package com.code.controller;

import com.code.enums.GlobalEnum;
import com.code.utils.ResultUtil;
import com.code.vo.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * CodeController
 *
 * @author weiqiang
 * @Description
 * @Date 2019-03-29 15:00
 */
@RestController
@CrossOrigin
@Api("code Controller")
public class CodeController {

    /**
     * 第一次查询
     *
     * @return
     */
    @ApiOperation("第一次查询")
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public ResultEntity code() {
        List<String> dataList = new ArrayList<>();
        dataList.add("Hello world");
        return ResultUtil.success(GlobalEnum.QuerySuccess,dataList);
    }
}

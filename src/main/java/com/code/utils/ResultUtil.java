package com.code.utils;

import com.code.enums.GlobalEnum;
import com.code.vo.ResultEntity;

import java.util.List;

/**
 * 返回结果封装工具类
 *
 * @author weiQiang
 */
public class ResultUtil {

  /**
   * 失败方法
   *
   * @param globalEnum
   * @return
   */
  public static ResultEntity error(GlobalEnum globalEnum) {
    return error(globalEnum.getMessage());
  }

  /**
   * 失败方法
   *
   * @param message
   * @return
   */
  public static ResultEntity error(String message) {
    return error(message, null);
  }

  /**
   * 失败方法
   *
   * @param message
   * @param data
   * @return
   */
  public static ResultEntity error(String message, List data) {
    return ResultEntity.builder().success(false).message(message).data(data).build();
  }

  /**
   * 成功返回分页数据和总页数
   *
   * @param querySuccess
   * @param resultList
   * @return
   */
  public static ResultEntity success(GlobalEnum querySuccess, List resultList) {
    return ResultEntity.builder().message(querySuccess.getMessage()).success(true).data(resultList).build();
  }

  /**
   * 成功方法
   *
   * @param globalEnum
   * @return
   */
  public static ResultEntity success(GlobalEnum globalEnum) {
    return success(globalEnum.getMessage(), null);
  }

  /**
   * 成功方法
   *
   * @param message
   * @param data
   * @return
   */
  public static ResultEntity success(String message, List data) {
    return ResultEntity.builder().success(true).message(message).data(data).build();
  }

}

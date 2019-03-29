package com.code.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author weiQiang
 * @date 2018/3/24
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
@Builder
public class ResultEntity implements Serializable {

    private static final long serialVersionUID = -5159330866402406443L;

    /**
     * 返回结果
     */
    @ApiModelProperty(value = "返回结果数据")
    private List<?> data;
    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回结果提示信息")
    private String message;
    /**
     * 返回成功与否
     */
    @ApiModelProperty(value = "返回结果状态")
    private boolean success;
    /**
     * 数据条数
     */
    @Builder.Default
    @ApiModelProperty(value = "返回结果数据条数")
    private Long total = 0L;
    /**
     * 耗时
     */
    @Builder.Default
    @ApiModelProperty(value = "请求耗时,单位ms")
    private Long totalTime = 0L;

}

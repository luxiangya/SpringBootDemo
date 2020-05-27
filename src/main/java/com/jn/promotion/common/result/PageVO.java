package com.jn.promotion.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页数据信息")
@Data
public class PageVO<T> implements Serializable {

    @ApiModelProperty("当前页码")
    private Long current;

    @ApiModelProperty("页容量")
    private Long size;

    @ApiModelProperty("总条数")
    private Long total;

    @ApiModelProperty("列表数据")
    private List<T> list;


    public PageVO(List<T> list, Long total, Long current, Long size) {
        this.list = list;
        this.total = total;
        this.current = current;
        this.size = size;
    }

    public PageVO(List<T> list, int total, int current, int size) {
        this.list = list;
        this.total = Long.valueOf(total);
        this.current = Long.valueOf(current);
        this.size = Long.valueOf(size);
    }


}

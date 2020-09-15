package com.flower.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 淮南
 * 查询条件
 */
@Data
public class FlowerQueryVo implements Serializable {

    /*鲜花的模糊查询、鲜花类别的分类列表、分类查询
（这个鲜花信息列表需要带上商家id，这样点进去才能知道是哪个商家的商品，就是这个我有点阐述不清楚，实现的效果就是点进去能知道是哪个商家的）*/

    /**根据关键词模糊查询,商品标题*/
    private String keyword;
}

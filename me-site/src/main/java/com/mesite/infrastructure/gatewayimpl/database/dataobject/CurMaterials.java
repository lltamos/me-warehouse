package com.mesite.infrastructure.gatewayimpl.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 资料管理
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cur_materials")
public class CurMaterials extends Model<CurMaterials> {

    private static final long serialVersionUID = 1L;

    /**
     * 资料管理
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    /**
     * 资料分类 81辅导讲义  82范文专区  83串讲资料  84复习资料
     */
    @TableField("classify_id")
    private Integer classifyId;

    /**
     * 省份id
     */
    @TableField("province_id")
    private Integer provinceId;

    /**
     * 项目类型id
     */
    @TableField("kind")
    private Integer kind;

    /**
     * '专业分类   104 职业类 103 新闻学类 102 公安学类 101 社会学类 95 艺术类 58 农科类 56 教育学类 55 医药类  54 工学类  53 语言文学类 52 经济管理类  51法学类',
     */
    @TableField("zyfl_id")
    private Integer zyflId;

    /**
     * 专业id
     */
    @TableField("zy_id")
    private Integer zyId;

    /**
     * 课id
     */
    @TableField("k_id")
    private Integer kId;

    /**
     * 资料名称
     */
    @TableField("title")
    private String title;

    /**
     * 1 推荐 2不推荐
     */
    @TableField("recommend")
    private Integer recommend;

    @TableField("com_words")
    private String comWords;

    /**
     * Meta标题
     */
    @TableField("meta_title")
    private String metaTitle;

    /**
     * Meta关键词
     */
    @TableField("meta_key")
    private String metaKey;

    /**
     * Meta描述
     */
    @TableField("meta_scr")
    private String metaScr;

    /**
     * 编辑
     */
    @TableField("editor")
    private String editor;

    /**
     * 来源
     */
    @TableField("source")
    private String source;

    /**
     * 上传资料地址
     */
    @TableField("names")
    private String names;

    /**
     * 状态 1 会员  0免费
     */
    @TableField("VIP")
    private Integer vip;

    /**
     * 文件后缀名
     */
    @TableField("Icon")
    private String icon;

    /**
     * 下载数量
     */
    @TableField("download_num")
    private Integer downloadNum;

    /**
     * 内容
     */
    @TableField("Introduction")
    private String introduction;

    /**
     * 1 审核通过 0未审核
     */
    @TableField("is_pass")
    private Integer isPass;

    /**
     * 添加时间
     */
    @TableField("add_time")
    private String addTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private String updateTime;

    /**
     * 上传图
     */
    @TableField("pic_url")
    private String picUrl;

    /**
     * 点击次数
     */
    @TableField("clicks")
    private Integer clicks;

    /**
     * 上传音频
     */
    @TableField("multimedia")
    private String multimedia;


    @Override
    protected Serializable pkVal() {
        return this.mid;
    }

}

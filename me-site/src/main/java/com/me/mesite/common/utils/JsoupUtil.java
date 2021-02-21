package com.me.mesite.common.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

/** 
 * xss非法标签过滤工具类 
 * 过滤html中的xss字符 
 * @author xbz 
 */  
public class JsoupUtil {  
  
    /** 
     * 使用自带的basicWithImages 白名单 
     * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span, 
     * strike,strong,sub,sup,u,ul,img 
     * 以及a标签的href,img标签的src,align,alt,height,width,title属性 
     */  
    private static final Whitelist whitelist = Whitelist.basicWithImages();  
    /** 配置过滤化参数,不对代码进行格式化 */  
    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);  
    static {  
        // 富文本编辑时一些样式是使用style来进行实现的  
        // 比如红色字体 style="color:red;"  
        // 所以需要给所有标签添加style属性  
        whitelist.addAttributes(":all", "style");  
    }  
  
    public static String clean(String content) {  
        if(StringUtils.isNotBlank(content)){  
            content = content.trim();  
        }  
        return Jsoup.clean(content, "", whitelist, outputSettings);  
    }  
      
    public static String cleanJson(String json) {  
    	JSONObject jsonObj = JSONUtil.parseObj(json);
    	System.out.println(json);
    	Set<Entry<String, Object>> entries = jsonObj.entrySet();
    	for (Entry<String, Object> ent : entries) {  
     		if(ent.getValue() != null) {
        		if("null".equalsIgnoreCase(ent.getValue().toString())) {
        			ent.setValue(null);

        		}else {
        			ent.setValue(clean(ent.getValue().toString()));
        		}
     		}

    	}
    	
         return JSONUtil.toJsonStr(jsonObj);  
    }  
    
    public static void main(String[] args) throws IOException {  
        String text = "   <a href=\"http://www.baidu.com/a\" onclick=\"alert(1);\">sss</a><script>alert(0);</script>sss   ";  
        System.out.println(clean(text));  
    }  
}  

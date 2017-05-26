package com.dodonew.entityVo;

import jvc.util.StringUtils;
import net.sf.json.JSONObject;

/**
 * Created by yukx on 17/5/9.
 */
public class SendModelVo {
    private String touser;
    private String template_id;
    private String page;
    private String form_id;
    private JSONObject data;
    private String color;
    private String emphasis_keyword;

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", touser);
        jsonObject.put("form_id", form_id);
        jsonObject.put("data", data);

        if (StringUtils.isNotBlank(template_id))
            jsonObject.put("template_id", template_id);
        if (StringUtils.isNotBlank(page))
            jsonObject.put("page", page);
        if (StringUtils.isNotBlank(emphasis_keyword))
            jsonObject.put("emphasis_keyword", emphasis_keyword);
        return jsonObject.toString();
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEmphasis_keyword() {
        return emphasis_keyword;
    }

    public void setEmphasis_keyword(String emphasis_keyword) {
        this.emphasis_keyword = emphasis_keyword;
    }
}

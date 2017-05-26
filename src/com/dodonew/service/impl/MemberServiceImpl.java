package com.dodonew.service.impl;

import com.dodonew.dao.WxMemberMapper;
import com.dodonew.entityVo.RegMemberVo;
import com.dodonew.entityVo.SendModelVo;
import com.dodonew.model.WxMember;
import com.dodonew.model.WxMemberKey;
import com.dodonew.service.MemberService;
import com.dodonew.utils.WxUtils;
import jvc.util.DateUtils;
import jvc.util.StringUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by yukx on 17/5/5.
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    Logger logger = Logger.getLogger(MemberServiceImpl.class);

    @Autowired
    WxMemberMapper wxMemberMapper;

    @Override
    @Transactional
    public void register(RegMemberVo regMemberVo) {

        WxMemberKey wxMemberKey = new WxMemberKey();
        wxMemberKey.setStoreId(regMemberVo.getStoreId());
        wxMemberKey.setMobile(regMemberVo.getMobile());

        WxMember wxMember = wxMemberMapper.queryByOpenId(wxMemberKey);
        if (wxMember != null) {
            wxMember.setUnionId(regMemberVo.getUnionId());
            try {
                wxMember.setNickname(URLDecoder.decode(regMemberVo.getNickNmae(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (StringUtils.isNotBlank(regMemberVo.getOpenId())) {
                wxMember.setOpenid(regMemberVo.getOpenId());
            }
            wxMember.setMobile(regMemberVo.getMobile());
            wxMember.setBirthday(regMemberVo.getBirthday());
            wxMember.setGender(regMemberVo.getSex());
            wxMemberMapper.updateByPrimaryKeySelective(wxMember);
        } else {
            Integer cardId = wxMemberMapper.selectCardId(regMemberVo.getStoreId());
            if(cardId < 100000){
                cardId = 100000;
            }

            wxMember = new WxMember();
            wxMember.setBalance((float) 0);
            try {
                wxMember.setNickname(URLDecoder.decode(regMemberVo.getNickNmae(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            wxMember.setMemberCardId(cardId);
            if (StringUtils.isNotBlank(regMemberVo.getOpenId())) {
                wxMember.setOpenid(regMemberVo.getOpenId());
            }
            wxMember.setRegisttime(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
            wxMember.setMobile(regMemberVo.getMobile());
            wxMember.setUnionId(regMemberVo.getUnionId());
            wxMember.setGender(regMemberVo.getSex());
            wxMember.setStoreid(regMemberVo.getStoreId());
            wxMember.setBirthday(regMemberVo.getBirthday());
            wxMemberMapper.insertSelective(wxMember);
        }

        // 模版消息
        if (StringUtils.isNotBlank(regMemberVo.getFormId()) && StringUtils.isNotBlank(regMemberVo.getOpenId())) {
            String access_token = WxUtils.getAccess_token();

            SendModelVo sendModelVo = new SendModelVo();
            sendModelVo.setForm_id(regMemberVo.getFormId());
            sendModelVo.setTouser(regMemberVo.getOpenId());
            sendModelVo.setTemplate_id(WxUtils.ZCTZ_MODEL);

            JSONObject object = new JSONObject();
            object.put("keyword1", WxUtils.newJSONDATA(wxMember.getMemberCardId()+"", null));
            try {
                object.put("keyword2", WxUtils.newJSONDATA(URLDecoder.decode(regMemberVo.getNickNmae(), "utf-8"), null));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            object.put("keyword3", WxUtils.newJSONDATA(regMemberVo.getMobile(), null));
            object.put("keyword4", WxUtils.newJSONDATA("欢迎您下次光临", null));

            sendModelVo.setData(object);

            String rs = WxUtils.sendModel(access_token, sendModelVo);
            logger.info("会员注册模版通知:" + rs);
        }
    }
}

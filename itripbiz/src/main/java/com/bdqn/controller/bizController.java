package com.bdqn.controller;
import cn.itrip.dao.itripAreaDic.ItripAreaDicMapper;
import cn.itrip.dao.itripLabelDic.ItripLabelDicMapper;
import cn.itrip.dao.itripUserLinkUser.ItripUserLinkUserMapper;
import cn.itrip.pojo.ItripAreaDic;
import cn.itrip.pojo.ItripLabelDic;
import cn.itrip.pojo.ItripUserLinkUser;
import itrip.common.Dto;
import itrip.common.DtoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class bizController {
    @Resource
    ItripAreaDicMapper dao;
    @RequestMapping(value = "/api/hotel/queryhotcity/{type}")
    @ResponseBody
    public Dto getCitty(@PathVariable("type")int t) throws Exception {
        Map map=new HashMap();
        map.put("aa",t);
        List<ItripAreaDic> list=dao.getItripAreaDicListByMap(map);
        return DtoUtil.returnDataSuccess(list);
    }
    @Resource
    ItripLabelDicMapper dao1;
    @RequestMapping(value = "/api/hotel/queryhotelfeature")
    @ResponseBody
    public Dto getCittytese() throws Exception {
    List<ItripLabelDic> list=dao1.fisttop();
        return DtoUtil.returnDataSuccess(list);
    }




    @Resource
    ItripUserLinkUserMapper dao2;
    @RequestMapping(value="/api/userinfo/queryuserlinkuser",produces="application/json; charset=utf-8")
    @ResponseBody
    public Dto select() throws Exception {
        List<ItripUserLinkUser> list=dao2.select();
        return DtoUtil.returnDataSuccess(list);
    }
    /*@Resource
    ItripUserLinkUserMapper dao2;
    @RequestMapping(value = "api/hotelorder/getpersonalorderlist")
    @ResponseBody
    public Dto select(@PathVariable("id") Long id) throws Exception {
        Map Map=new HashMap();
        Map.put("id",id);
        ItripUserLinkUser list=dao2.getItripUserLinkUserById(id);
        return DtoUtil.returnDataSuccess(list);
    }

    @RequestMapping(value = "api/hotelorder/getpersonalorderlist")
    @ResponseBody
    public Dto getItripUserLinkUserListByMap(Map<String, Object> param, HttpServletRequest request) throws Exception {
     String parm=request.getHeader("token");
     Map Map=new HashMap();
     Map.put("map",parm);
        return DtoUtil.returnDataSuccess(parm);
    }
*/




}

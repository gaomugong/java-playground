package org.feichai.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.feichai.common.domain.QueryRequest;
import org.feichai.system.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;


public class BaseController {
    protected static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    protected Session getSession(Boolean create) {
        return  getSubject().getSession(create);
    }

    protected Session getSession() {
        return getSubject().getSession();
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }

    private Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    protected Map<String, Object> selectByPageNumSize(QueryRequest request, Supplier<?> s) {
        // 支持全量返回
        List<?> dataList = (List<?>) s.get();
        int pageNum = (request.getPageNum() == 0) ? 1 : request.getPageNum();
        int pageSize = (request.getPageSize() == 0) ? dataList.size() : request.getPageSize();

        // PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageHelper.startPage(pageNum, pageSize);
        // PageInfo<?> pageInfo = new PageInfo<>(dataList);
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }
}

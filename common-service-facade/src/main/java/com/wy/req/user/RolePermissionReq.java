package com.wy.req.user;

import com.wy.req.AbsReq;

import java.util.List;

/**
 * @Auther：weib
 * @Date：2019/3/26 15 51
 * @Description:角色对应权限的修改请求
 */
public class RolePermissionReq extends AbsReq {
    /** 角色ID */
    private String roleId;

    /** 权限ID列表 */
    private List<String> permissionIdList;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(List<String> permissionIdList) {
        this.permissionIdList = permissionIdList;
    }

    @Override
    public String toString() {
        return "RolePermissionReq{" +
                "roleId='" + roleId + '\'' +
                ", permissionIdList=" + permissionIdList +
                '}';
    }
}
